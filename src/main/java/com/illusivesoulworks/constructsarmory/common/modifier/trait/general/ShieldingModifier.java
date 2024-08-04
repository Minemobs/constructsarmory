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

package com.illusivesoulworks.constructsarmory.common.modifier.trait.general;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.modules.technical.ArmorLevelModule;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.capability.TinkerDataCapability;
import com.illusivesoulworks.constructsarmory.ConstructsArmoryMod;

public class ShieldingModifier extends Modifier {

  private static final TinkerDataCapability.TinkerDataKey<Integer> SHIELDING =
      ConstructsArmoryMod.createKey("shielding");

  public ShieldingModifier() {
    MinecraftForge.EVENT_BUS.addListener(ShieldingModifier::onPotionStart);
  }

  @Override
  protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
    super.registerHooks(hookBuilder);
    hookBuilder.addModule(new ArmorLevelModule(SHIELDING, false, null));
  }

  private static void onPotionStart(final MobEffectEvent.Added evt) {
    MobEffectInstance newEffect = evt.getEffectInstance();

    if (!newEffect.getCurativeItems().isEmpty()) {
      LivingEntity living = evt.getEntity();
      living.getCapability(TinkerDataCapability.CAPABILITY).ifPresent(data -> {
        int levels = data.get(SHIELDING, 0);

        if (levels > 0) {
          float change = levels * 0.05f;

          if (!newEffect.getEffect().isBeneficial()) {
            change *= -1;
          }
          newEffect.duration = Math.max(0, (int) (newEffect.getDuration() * (1 + change)));
          /*try {
            Field f_19503_ = FieldUtils.getDeclaredField(MobEffectInstance.class, "f_19503_", true);
            f_19503_.setAccessible(true);
            f_19503_.set(newEffect, Math.max(0, (int) (newEffect.getDuration() * (1 + change))));
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          }*/
        }
      });
    }
  }
}
