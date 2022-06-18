package top.theillusivec4.constructsarmory.common.modifier.trait.speed;

import java.util.UUID;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.inventory.EquipmentSlotType;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.EquipmentChangeContext;
import slimeknights.tconstruct.library.tools.nbt.IModifierToolStack;
import top.theillusivec4.constructsarmory.common.modifier.EquipmentUtil;
import top.theillusivec4.constructsarmory.common.modifier.IArmorUpdateModifier;

public abstract class AbstractSpeedModifier extends Modifier implements IArmorUpdateModifier {

  public AbstractSpeedModifier(int color) {
    super(color);
  }

  @Override
  public void onUnequip(@Nonnull IModifierToolStack tool, int level,
                        EquipmentChangeContext context) {
    LivingEntity livingEntity = context.getEntity();
    IModifierToolStack newTool = context.getReplacementTool();

    if (newTool == null || newTool.isBroken() || newTool.getModifierLevel(this) != level) {
      ModifiableAttributeInstance attribute = livingEntity.getAttribute(Attributes.MOVEMENT_SPEED);

      if (attribute != null) {
        attribute.removeModifier(EquipmentUtil.getUuid(getId(), context.getChangedSlot()));
      }
    }
  }

  @Nullable
  @Override
  public <T> T getModule(@Nonnull Class<T> type) {
    return tryModuleMatch(type, IArmorUpdateModifier.class, this);
  }

  @Override
  public void onUpdate(IModifierToolStack armor, EquipmentSlotType slotType, int level,
                       LivingEntity living) {

    if (living.world.isRemote) {
      return;
    }
    ModifiableAttributeInstance attribute = living.getAttribute(Attributes.MOVEMENT_SPEED);

    if (attribute == null) {
      return;
    }
    UUID uuid = EquipmentUtil.getUuid(getId(), slotType);
    attribute.removeModifier(uuid);

    if (!armor.isBroken()) {
      applyBoost(armor, slotType, attribute, uuid, level, living);
    }
  }

  protected abstract void applyBoost(IModifierToolStack armor, EquipmentSlotType slotType,
                                     ModifiableAttributeInstance attribute, UUID uuid, int level,
                                     LivingEntity living);
}
