package de.einfachadi.survival.Item;

import de.einfachadi.survival.Survival;
import de.einfachadi.survival.util.ModTags;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.EnumMap;

public class ModArmorMaterials {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> NETHER_EMERALD_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(Survival.MOD_ID, "nether_emerald"));

    public static final ArmorMaterial NETHER_EMERALD_ARMOR_MATERIAL = new ArmorMaterial(1800, Util.make(new EnumMap<>(EquipmentType.class), map -> {
        map.put(EquipmentType.BOOTS, 5);
        map.put(EquipmentType.LEGGINGS, 7);
        map.put(EquipmentType.CHESTPLATE, 8);
        map.put(EquipmentType.HELMET, 4);
        map.put(EquipmentType.BODY, 10);
    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModTags.Items.NETHER_EMERALD_REPAIR, NETHER_EMERALD_KEY);

}