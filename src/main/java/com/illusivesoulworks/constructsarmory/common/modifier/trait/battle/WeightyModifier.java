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

package com.illusivesoulworks.constructsarmory.common.modifier.trait.battle;

import java.util.List;

import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;
import slimeknights.mantle.client.TooltipKey;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.ModifierHooks;
import slimeknights.tconstruct.library.modifiers.hook.armor.ProtectionModifierHook;
import slimeknights.tconstruct.library.modifiers.hook.display.TooltipModifierHook;
import slimeknights.tconstruct.library.module.ModuleHookMap;
import slimeknights.tconstruct.library.tools.context.EquipmentContext;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import com.illusivesoulworks.constructsarmory.common.modifier.EquipmentUtil;

public class WeightyModifier extends Modifier implements ProtectionModifierHook, TooltipModifierHook {

  private static final float BASELINE_MOVEMENT = 0.1f;
  private static final float MAX_MOVEMENT = 0.15f;

  @Override
  protected void registerHooks(ModuleHookMap.Builder hookBuilder) {
    super.registerHooks(hookBuilder);
    hookBuilder.addHook(this, ModifierHooks.PROTECTION, ModifierHooks.TOOLTIP);
  }

  private static float getBonus(float movementSpeed, float min, float max) {

    if (movementSpeed > BASELINE_MOVEMENT) {

      if (movementSpeed > MAX_MOVEMENT) {
        return min;
      }
      return (MAX_MOVEMENT - movementSpeed) / (MAX_MOVEMENT - BASELINE_MOVEMENT) * (max - min);
    }
    return max;
  }

  @Override
  public float getProtectionModifier(IToolStackView tool, ModifierEntry modifier, EquipmentContext context, EquipmentSlot slotType, DamageSource source, float modifierValue) {
    if (!source.isBypassMagic() && !source.isBypassInvul()) {
      AttributeInstance attributeInstance =
          context.getEntity().getAttribute(Attributes.MOVEMENT_SPEED);

      if (attributeInstance != null) {
        modifierValue += getBonus((float) attributeInstance.getValue(), 0.0f, 1.5f) * modifier.getLevel();
      }
    }
    return modifierValue;
  }

  @Override
  public void addTooltip(IToolStackView tool, ModifierEntry modifier, @Nullable Player player, List<Component> tooltip, TooltipKey tooltipKey, TooltipFlag tooltipFlag) {
    float bonus;

    if (player != null) {
      AttributeInstance attributeInstance =
          player.getAttribute(Attributes.MOVEMENT_SPEED);

      if (attributeInstance != null) {
        bonus = getBonus((float) attributeInstance.getValue(), 0.0f, 1.5f) * modifier.getLevel();
      } else {
        bonus = 0f;
      }
    } else {
      bonus = modifier.getLevel() * 1.5f;
    }
    EquipmentUtil.addResistanceTooltip(this, tool, bonus, tooltip);

  }
}
