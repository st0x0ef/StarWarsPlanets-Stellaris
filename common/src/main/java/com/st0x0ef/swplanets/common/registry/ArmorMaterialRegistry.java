package com.st0x0ef.swplanets.common.registry;

import com.st0x0ef.swplanets.common.items.armour.BeskarArmorMaterial;
import com.st0x0ef.swplanets.common.items.armour.TrooperArmorMaterial;
import net.minecraft.world.item.ArmorMaterial;

public class ArmorMaterialRegistry {
    public static final ArmorMaterial STORMTROOPER_MATERIAL = new TrooperArmorMaterial();
    public static final ArmorMaterial BESKAR_MATERIAL = new BeskarArmorMaterial();
}
