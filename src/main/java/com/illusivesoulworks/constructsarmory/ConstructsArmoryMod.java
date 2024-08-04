/*
 * Copyright (C) 2018-2022 Illusive Soulworks
 *
 * Construct's Armory is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * Construct's Armory is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Construct's Armory.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.illusivesoulworks.constructsarmory;

import com.illusivesoulworks.constructsarmory.client.ConstructsArmoryClient;
import com.illusivesoulworks.constructsarmory.common.ConstructsArmoryEffects;
import com.illusivesoulworks.constructsarmory.common.ConstructsArmoryEvents;
import com.illusivesoulworks.constructsarmory.common.ConstructsArmoryItems;
import com.illusivesoulworks.constructsarmory.common.ConstructsArmoryModifiers;
import com.illusivesoulworks.constructsarmory.common.stat.ConstructsArmoryMaterialStats;
import com.illusivesoulworks.constructsarmory.common.stat.ConstructsArmoryStats;
import com.illusivesoulworks.constructsarmory.data.ArmorDefinitionDataProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorMaterialDataProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorMaterialSpriteProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorMaterialStatsDataProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorMaterialTraitsDataProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorPartSpriteProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorRecipeProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorSlotLayoutProvider;
import com.illusivesoulworks.constructsarmory.data.ArmorTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;
import slimeknights.tconstruct.common.data.tags.BlockTagProvider;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import slimeknights.tconstruct.library.tools.definition.ToolDefinitionData;
import slimeknights.tconstruct.library.tools.nbt.MultiplierNBT;
import slimeknights.tconstruct.library.tools.nbt.StatsNBT;

import java.lang.reflect.Field;
import java.util.function.Supplier;

@Mod(ConstructsArmoryMod.MOD_ID)
public class ConstructsArmoryMod {

  public static final String MOD_ID = "constructsarmory";
  public static final Logger LOGGER = LogManager.getLogger();

  public ConstructsArmoryMod() {
    IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
    eventBus.addListener(this::setup);
    eventBus.addListener(this::gatherData);
    ConstructsArmoryItems.init();
    ConstructsArmoryModifiers.init();
    ConstructsArmoryStats.init();
    ConstructsArmoryEffects.init();
    DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ConstructsArmoryClient::init);
  }

  private void setup(final FMLCommonSetupEvent evt) {
    ConstructsArmoryEvents.setup();
    evt.enqueueWork(ConstructsArmoryMaterialStats::setup);
  }

  private void gatherData(final GatherDataEvent evt) {
    ExistingFileHelper existingFileHelper = evt.getExistingFileHelper();
    DataGenerator generator = evt.getGenerator();
    boolean server = evt.includeServer();
    boolean client = evt.includeClient();

    BlockTagsProvider blockTags = new BlockTagProvider(generator, existingFileHelper);
    AbstractMaterialDataProvider materials = new ArmorMaterialDataProvider(generator);
    generator.addProvider(server, materials);
    generator.addProvider(server, new ArmorMaterialStatsDataProvider(generator, materials));
    generator.addProvider(server, new ArmorMaterialTraitsDataProvider(generator, materials));
    generator.addProvider(server, new ArmorRecipeProvider(generator));
    generator.addProvider(server, new ArmorDefinitionDataProvider(generator));
    generator.addProvider(server, new ArmorSlotLayoutProvider(generator));
    generator.addProvider(server, new ArmorTagProvider(generator, blockTags, existingFileHelper));

    ArmorPartSpriteProvider armorPartSpriteProvider = new ArmorPartSpriteProvider();
    generator.addProvider(client,
        new GeneratorPartTextureJsonGenerator(generator, ConstructsArmoryMod.MOD_ID,
            armorPartSpriteProvider));
    generator.addProvider(client,
        new MaterialPartTextureGenerator(generator, existingFileHelper, armorPartSpriteProvider,
            new ArmorMaterialSpriteProvider()));
  }

  public static ResourceLocation getResource(String id) {
    return new ResourceLocation(MOD_ID, id);
  }

  public static <T> TinkerDataCapability.TinkerDataKey<T> createKey(String name) {
    return TinkerDataCapability.TinkerDataKey.of(getResource(name));
  }

  public static <T> TinkerDataCapability.ComputableDataKey<T> createKey(String name, Supplier<T> value) {
    return TinkerDataCapability.ComputableDataKey.of(getResource(name), value);
  }

  @Nullable
  public static StatsNBT getBaseStats(ToolDefinitionData data) {
    try {
      Field baseStats = ToolDefinitionData.class.getDeclaredField("baseStats");
      baseStats.trySetAccessible();
      return (StatsNBT) baseStats.get(data);
    } catch (Exception e) {
      LOGGER.error("Failed to get base stats", e);
      return null;
    }
  }

  @Nullable
  public static MultiplierNBT getMultiplier(ToolDefinitionData data) {
    try {
      Field baseStats = ToolDefinitionData.class.getDeclaredField("multipliers");
      baseStats.trySetAccessible();
      return (MultiplierNBT) baseStats.get(data);
    } catch (Exception e) {
      LOGGER.error("Failed to get base stats", e);
      return null;
    }
  }
}
