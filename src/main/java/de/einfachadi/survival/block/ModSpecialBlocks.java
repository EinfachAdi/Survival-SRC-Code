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
import net.minecraft.util.Identifier;

public class ModSpecialBlocks {
    private static Block registerBlock(String name, Block block) {registerBlockItem(name, block);return Registry.register(Registries.BLOCK, Identifier.of(Survival.MOD_ID, name), block);}
    //special blocks
    public static final Block MAGICBLOCK = registerBlock("magic_block", new magic_block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "magic_block"))).strength(0.5f)));
    public static final Block diamond_apple = registerBlock("diamond_apple", new diamond_apple(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "diamond_apple"))).strength(1f)));
    public static final Block evoker_fangs_altar = registerBlock("evoker_fangs_altar", new evoker_fangs_altar(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "evoker_fangs_altar"))).strength(1f)));
    public static final Block ender_dragon_altar = registerBlock("ender_dragon_altar", new ender_dragon_altar(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "ender_dragon_altar"))).strength(1f)));
    public static final Block fireball_altar = registerBlock("fireball_altar", new fireball_altar(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "fireball_altar"))).strength(1f)));
    public static final Block lightning_bolt_altar = registerBlock("lightning_bolt_altar", new lightning_bolt_altar(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "lightning_bolt_altar"))).strength(1f)));
    public static final Block wither_altar = registerBlock("wither_altar", new wither_altar(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "wither_altar"))).strength(1f)));


    public static final Block WEAPON_BLOCK = registerBlock("weapon_block", new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Survival.MOD_ID, "weapon_block"))).strength(4f)));

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Survival.MOD_ID, name),
                new BlockItem(block, new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Survival.MOD_ID, name)))));
    }
        public static void registerModBlocks() {
            Survival.LOGGER.info("Registering Mod Blocks for " + Survival.MOD_ID);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            });

        }}
