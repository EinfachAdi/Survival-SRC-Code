package de.einfachadi.survival.Item;

import de.einfachadi.survival.Item.custom.AirChiselItem;
import de.einfachadi.survival.Item.custom.ChiselItem;
import de.einfachadi.survival.Item.custom.HammerItem;
import de.einfachadi.survival.Item.custom.ModArmorItem;
import de.einfachadi.survival.Survival;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModNetherItems {

    //normal items
    public static final Item EMERALD_COAL = registerItem("emerald_coal", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "emerald_coal")))));
    public static final Item NETHER_EMERALD = registerItem("nether_emerald", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald")))));
    public static final Item RAW_NETHER_EMERALD = registerItem("raw_nether_emerald", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "raw_nether_emerald")))));
    //special crafting items
    public static final Item NETHER_EMERALD_CLUMP = registerItem("nether_emerald_clump", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_clump")))));
    public static final Item NETHER_EMERALD_SHARD = registerItem("nether_emerald_shard", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_shard")))));
    public static final Item GHOST_FRAGMENT = registerItem("ghost_fragment", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "ghost_fragment")))));
    public static final Item FRAGMENT_SHARD = registerItem("fragment_shard", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "fragment_shard")))));
    public static final Item FRAGMENT_TEMPLATE = registerItem("fragment_template", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "fragment_template")))));
    public static final Item GHOST_TEMPLATE = registerItem("ghost_template", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "ghost_template")))));
    public static final Item UPGRADE_TEMPLATE = registerItem("upgrade_template", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "upgrade_template")))));

    //Tools
    public static final Item NETHER_EMERALD_SWORD = registerItem("nether_emerald_sword", new Item(new Item.Settings().sword(ModToolMaterials.NETHER_EMERALD, 8, -0.8f).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_sword")))));
    public static final Item NETHER_EMERALD_PICKAXE = registerItem("nether_emerald_pickaxe", new Item(new Item.Settings().pickaxe(ModToolMaterials.NETHER_EMERALD, 1, -2.8f).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_pickaxe")))));
    public static final Item NETHER_EMERALD_SHOVEL = registerItem("nether_emerald_shovel", new ShovelItem(ModToolMaterials.NETHER_EMERALD, 1.5f, -3.0f, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_shovel")))));
    public static final Item NETHER_EMERALD_AXE = registerItem("nether_emerald_axe", new AxeItem(ModToolMaterials.NETHER_EMERALD, 6, -3.2f, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_axe")))));
    public static final Item NETHER_EMERALD_HOE = registerItem("nether_emerald_hoe", new HoeItem(ModToolMaterials.NETHER_EMERALD, 0, -1.2f,new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_hoe")))));
    //Special Tools
    public static final Item NETHER_EMERALD_HAMMER = registerItem("nether_emerald_hammer", new HammerItem(ModToolMaterials.NETHER_EMERALD, 7, -3.4f, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_hammer")))));
    //Armor
    public static final Item NETHER_EMERALD_HELMET = registerItem("nether_emerald_helmet", new ModArmorItem(new Item.Settings().armor(ModArmorMaterials.NETHER_EMERALD_ARMOR_MATERIAL, EquipmentType.HELMET).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_helmet")))));
   public static final Item NETHER_EMERALD_CHESTPLATE = registerItem("nether_emerald_chestplate", new Item(new Item.Settings().armor(ModArmorMaterials.NETHER_EMERALD_ARMOR_MATERIAL, EquipmentType.CHESTPLATE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_chestplate")))));
    public static final Item NETHER_EMERALD_LEGGINGS = registerItem("nether_emerald_leggings", new Item(new Item.Settings().armor(ModArmorMaterials.NETHER_EMERALD_ARMOR_MATERIAL, EquipmentType.LEGGINGS).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_leggings")))));
    public static final Item NETHER_EMERALD_BOOTS = registerItem("nether_emerald_boots", new Item(new Item.Settings().armor(ModArmorMaterials.NETHER_EMERALD_ARMOR_MATERIAL, EquipmentType.BOOTS).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_boots")))));
    //AnimalArmor
    public static final Item NETHER_EMERALD_HORSE_ARMOR = registerItem("nether_emerald_horse_armor",
            new Item(new Item.Settings().horseArmor(ModArmorMaterials.NETHER_EMERALD_ARMOR_MATERIAL).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "nether_emerald_horse_armor"))).maxCount(1)));    //Bow
    //Spawn Eggs
    public static final Item BLAZE_SPAWN = registerItem("blaze_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.BLAZE).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "blaze_spawn")))));
    public static final Item WITHER_SPAWN = registerItem("wither_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.WITHER).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "wither_spawn"))).maxCount(1)));
    public static final Item FIER_CHARGE_SPAWN = registerItem("fire_charge_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.FIREBALL).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "fire_charge_spawn"))).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Survival.LOGGER.info("Registering Mod Items for" + Survival.MOD_ID);

    }
}