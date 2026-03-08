package de.einfachadi.survival.block;

import de.einfachadi.survival.Survival;
import de.einfachadi.survival.block.custom.*;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
public class ModNetherBlocks {
    private static Block registerBlock(String name, Block block) {registerBlockItem(name, block);return Registry.register(Registries.BLOCK, Identifier.of(Survival.MOD_ID, name), block);}
    //Non-Blocks
    //public static final Block NETHER_EMERALD_STAIRS = registerBlock("nether_emerald_stairs", new StairsBlock(ModNetherBlocks.NETHER_EMERALD_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(2f).requiresTool().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_stairs")))));
    public static final Block NETHER_EMERALD_SLAB = registerBlock("nether_emerald_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_slab"))).strength(2f)));
    public static final Block NETHER_EMERALD_BUTTON = registerBlock("nether_emerald_button", new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_button"))).strength(0.25f).noCollision()));
    public static final Block NETHER_EMERALD_PRESSURE_PLATE = registerBlock("nether_emerald_pressure_plate", new PressurePlateBlock(BlockSetType.IRON,AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_pressure_plate"))).strength(0.5f)));
    public static final Block NETHER_EMERALD_FENCE = registerBlock("nether_emerald_fence", new FenceBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_fence"))).strength(1f)));
    public static final Block NETHER_EMERALD_FENCE_GATE = registerBlock("nether_emerald_fence_gate", new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_fence_gate"))).strength(1f)));
    public static final Block NETHER_EMERALD_WALL = registerBlock("nether_emerald_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_wall"))).strength(2f)));
    public static final Block NETHER_EMERALD_DOOR = registerBlock("nether_emerald_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_door"))).strength(2f).requiresTool().nonOpaque()));
    public static final Block NETHER_EMERALD_TRAPDOOR = registerBlock("nether_emerald_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_trapdoor"))).strength(2f).requiresTool().nonOpaque()));
   //normal blocks
    public static final Block RAW_NETHER_EMERALD_BLOCK = registerBlock("raw_nether_emerald_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "raw_nether_emerald_block"))).strength(3f)));
    public static final Block NETHER_EMERALD_BLOCK = registerBlock("nether_emerald_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_block"))).strength(4f)));
    //ores
    public static final Block NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore", new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "nether_emerald_ore"))).strength(3f).sounds(BlockSoundGroup.NETHER_ORE)));
    //special blocks

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name)))));
    }
        public static void registerModBlocks() {
            Survival.LOGGER.info("Registering Mod Blocks for " + Survival.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            });

        }}
