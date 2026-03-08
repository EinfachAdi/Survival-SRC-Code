package de.einfachadi.survival.Item;

import de.einfachadi.survival.Survival;
import net.minecraft.entity.EntityType;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEndItems {


    public static final Item END_BOW = registerItem("end_bow", new BowItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "end_bow"))).maxDamage(500)));

    //Spawn
    public static final Item ENDER_DRAGON_SPAWN = registerItem("ender_dragon_spawn", new SpawnEggItem(new Item.Settings().spawnEgg(EntityType.ENDER_DRAGON).registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, "ender_dragon_spawn"))).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Survival.LOGGER.info("Registering Mod Items for" + Survival.MOD_ID);

    }
}