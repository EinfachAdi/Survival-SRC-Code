package de.einfachadi.survival.block;

import de.einfachadi.survival.Survival;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModGhostBlocks {
    private static Block registerBlock(String name, Block block) {registerBlockItem(name, block);return Registry.register(Registries.BLOCK, Identifier.of(Survival.MOD_ID, name), block);}
    //ghost_blocks
    public static final Block NETHER_EMERALD_GHOST_BLOCK = registerBlock("nether_emerald_ghost_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ghost_block"))).noCollision()));
    //public static final Block NETHER_EMERALD_GHOST_STAIRS = registerBlock("nether_emerald_ghost_stairs", new StairsBlock(ModNetherBlocks.NETHER_EMERALD_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(2f).requiresTool().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ghost_stairs"))).noCollision()));

    //unbreakable
    //.strength(-1.0F, 3600000.0F)
    public static final Block NETHER_EMERALD_GHOST_SLAB = registerBlock("nether_emerald_ghost_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ghost_slab"))).strength(2f).noCollision()));
    public static final Block NETHER_EMERALD_GHOST_DOOR = registerBlock("nether_emerald_ghost_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ghost_door"))).strength(2f).requiresTool().nonOpaque().noCollision()));
    public static final Block NETHER_EMERALD_GHOST_TRAPDOOR = registerBlock("nether_emerald_ghost_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ghost_trapdoor"))).strength(2f).requiresTool().nonOpaque().noCollision()));

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name)))));
    }
        public static void registerModBlocks() {
            Survival.LOGGER.info("Registering Mod Blocks for " + Survival.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            });

        }}
