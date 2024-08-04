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

package com.illusivesoulworks.constructsarmory.common.modifier.trait.speed;

import java.util.List;
import java.util.UUID;

import com.illusivesoulworks.constructsarmory.ConstructsArmoryMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.build.VolatileDataModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.nbt.IToolContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import slimeknights.tconstruct.library.tools.nbt.ModDataNBT;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import com.illusivesoulworks.constructsarmory.common.modifier.EquipmentUtil;

/**
 * Modified copy of {@link MaintainedModifier} from Tinkers' Construct
 * MIT License (c) SlimeKnights
 */
public class ImmaculateModifier extends AbstractSpeedModifier implements VolatileDataModifierHook, TooltipModifierHook {

  private static final ResourceLocation KEY_ORIGINAL_DURABILITY =
      TConstruct.getResource("durability");

  @Override
  protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
    super.registerHooks(hookBuilder);
    hookBuilder.addHook(this, ModifierHooks.VOLATILE_DATA, ModifierHooks.TOOLTIP);
  }

  @Override
  public void addVolatileData(IToolContext context, ModifierEntry modifier, ModDataNBT volatileData) {
    volatileData.putInt(KEY_ORIGINAL_DURABILITY,
        ConstructsArmoryMod.getBaseStats(context.getDefinitionData()).getInt(ToolStats.DURABILITY) *
            (int) ConstructsArmoryMod.getMultiplier(context.getDefinition().getData()).get(ToolStats.DURABILITY));
  }

  public static float boost(int durability, float boost, int min, int max) {

    if (durability > min) {

      if (durability > max) {
        return boost;
      }
      return boost * (durability - min) / (max - min);
    }
    return 0.0f;
  }

  @Override
  public void addTooltip(IToolStackView armor, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey key, TooltipFlag flag) {
    if (armor.hasTag(TinkerTags.Items.ARMOR)) {
      float boost;

      if (player != null && key == TooltipKey.SHIFT) {
        boost = getTotalBoost(armor, modifier.getLevel());
      } else {
        boost = 0.02f * modifier.getLevel();
      }

      if (boost > 0) {
        EquipmentUtil.addSpeedTooltip(this, armor, boost, tooltip);
      }
    }
  }

  protected float getTotalBoost(IToolStackView armor, int level) {
    int durability = armor.getCurrentDurability();
    int baseMax = armor.getVolatileData().getInt(KEY_ORIGINAL_DURABILITY);
    float boost = boost(durability, 0.02f, baseMax / 2, baseMax);
    int fullMax = armor.getStats().getInt(ToolStats.DURABILITY);

    if (fullMax > baseMax) {
      boost += boost(durability, 0.01f, baseMax, Math.max(baseMax * 2, fullMax));
    }
    return boost * level;
  }

  @Override
  protected void applyBoost(IToolStackView armor, EquipmentSlot slotType,
                            AttributeInstance attribute, UUID uuid, int level,
                            LivingEntity living) {
    float boost = getTotalBoost(armor, level);

    if (boost > 0) {
      attribute.addTransientModifier(
          new AttributeModifier(uuid, "constructsarmory.modifier.immaculate", boost,
              AttributeModifier.Operation.MULTIPLY_TOTAL));
    }
  }
}
