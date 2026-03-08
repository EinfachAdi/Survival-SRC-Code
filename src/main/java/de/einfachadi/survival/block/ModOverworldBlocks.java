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

public class ModOverworldBlocks {
    private static Block registerBlock(String name, Block block) {registerBlockItem(name, block);return Registry.register(Registries.BLOCK, Identifier.of(Survival.MOD_ID, name), block);}
    //Non-Blocks
    public static final Block BEDROCK = registerBlock("bedrock", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock"))).strength(-1.0F, 3600000.0F)));
    //Non-Blocks
    //public static final Block BEDROCK_STAIRS = registerBlock("bedrock_stairs", new StairsBlock(ModNetherBlocks.NETHER_EMERALD_BLOCK.getDefaultState(), AbstractBlock.Settings.create().strength(-1f).registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_stairs")))));

    public static final Block BEDROCK_SLAB = registerBlock("bedrock_slab", new SlabBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_slab"))).strength(-1f)));
    public static final Block BEDROCK_BUTTON = registerBlock("bedrock_button", new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_button"))).strength(-1f).noCollision()));
    public static final Block BEDROCK_PRESSURE_PLATE = registerBlock("bedrock_pressure_plate", new PressurePlateBlock(BlockSetType.IRON,AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_pressure_plate"))).strength(-1f)));
    public static final Block BEDROCK_FENCE = registerBlock("bedrock_fence", new FenceBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_fence"))).strength(-1f)));
    public static final Block BEDROCK_FENCE_GATE = registerBlock("bedrock_fence_gate", new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_fence_gate"))).strength(-1f)));
    public static final Block BEDROCK_WALL = registerBlock("bedrock_wall", new WallBlock(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_wall"))).strength(-1f)));
    public static final Block BEDROCK_DOOR = registerBlock("bedrock_door", new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_door"))).strength(-1f).nonOpaque()));
    public static final Block BEDROCK_TRAPDOOR = registerBlock("bedrock_trapdoor", new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "bedrock_trapdoor"))).strength(-1f).nonOpaque()));


    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name)))));
    }
        public static void registerModBlocks() {
            Survival.LOGGER.info("Registering Mod Blocks for " + Survival.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            });

        }}
