package de.einfachadi.survival.util;

import de.einfachadi.survival.Survival;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_NETHER_EMERALD_TOOL = createTag("needs_nether_emerald_tool");
        public static final TagKey<Block> INCORRECT_FOR_NETHER_EMERALD_TOOL = createTag("incorrect_for_nether_emerald_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, name));
        }

    }
    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name));
        }

        public static class spawn_items {
            public static final TagKey<Item> SPAWN_ITEMS = createTag("spawn_items");

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name));
            } }

        public static class boss_spawn_items {
            public static final TagKey<Item> BOSS_SPAWN_ITEMS = createTag("boss_spawn_items");

            private static TagKey<Item> createTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name));
            } }

            public static final TagKey<Item> NETHER_EMERALD_REPAIR = createTag("nether_emerald_repair");

    }
}
