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
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModOverworldItems {

    public static final Item DIRT_EMERALD_CLUMP = registerItem("dirt_emerald_clump", new Item(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "dirt_emerald_clump")))));

    public static final Item AIR_CHISEL = registerItem("air_chisel", new AirChiselItem(new Item.Settings().maxDamage(16).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID,"air_chisel")))));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32).fireproof().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID,"chisel")))));
    //Food
    public static final Item Healthy_Snack = registerItem("healthy_snack", new Item(new Item.Settings().food(ModFoodComponent.HealthySnack).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID,"healthy_snack")))));
    //spawn
    public static final Item LIGHTNING_BOLT_SPAWN = registerItem("lightning_bolt_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.LIGHTNING_BOLT).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "lightning_bolt_spawn")))));
    public static final Item EVOKER_FANGS_SPAWN = registerItem("evoker_fangs_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.EVOKER_FANGS).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "evoker_fangs_spawn")))));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Survival.LOGGER.info("Registering Mod Items for" + Survival.MOD_ID);

    }
}