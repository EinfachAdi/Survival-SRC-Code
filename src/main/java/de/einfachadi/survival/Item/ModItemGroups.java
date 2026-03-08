package de.einfachadi.survival.Item;

import de.einfachadi.survival.Survival;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModOverworldBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "usually_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModNetherItems.NETHER_EMERALD))
                    .displayName(Text.translatable("itemgroup.survival.usually_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModNetherItems.NETHER_EMERALD);
                      entries.add(ModNetherItems.RAW_NETHER_EMERALD);
                      entries.add(ModNetherItems.NETHER_EMERALD_SHARD);
                      entries.add(ModNetherItems.NETHER_EMERALD_CLUMP);
                      entries.add(ModOverworldItems.DIRT_EMERALD_CLUMP);
                      //craft items
                      entries.add(ModNetherItems.GHOST_FRAGMENT);
                      entries.add(ModNetherItems.FRAGMENT_SHARD);
                      entries.add(ModNetherItems.FRAGMENT_TEMPLATE);
                      entries.add(ModNetherItems.GHOST_TEMPLATE);
                      entries.add(ModNetherItems.UPGRADE_TEMPLATE);

                    }).build());

        public static final ItemGroup BLOCKS = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(Survival.MOD_ID, "building_blocks"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModNetherBlocks.NETHER_EMERALD_BLOCK))
                        .displayName(Text.translatable("itemgroup.survival.building_blocks"))
                        .entries((displayContext, entries) -> {
                            entries.add(ModSpecialBlocks.MAGICBLOCK);
                            entries.add(ModSpecialBlocks.diamond_apple);
                            entries.add(ModSpecialBlocks.ender_dragon_altar);
                            entries.add(ModSpecialBlocks.evoker_fangs_altar);
                            entries.add(ModSpecialBlocks.fireball_altar);
                            entries.add(ModSpecialBlocks.lightning_bolt_altar);
                            entries.add(ModSpecialBlocks.wither_altar);

                            entries.add(ModSpecialBlocks.WEAPON_BLOCK);

                            entries.add(ModNetherBlocks.NETHER_EMERALD_BLOCK);
                            entries.add(ModNetherBlocks.RAW_NETHER_EMERALD_BLOCK);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_SLAB);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_BUTTON);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_PRESSURE_PLATE);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_FENCE);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_WALL);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_DOOR);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_TRAPDOOR);
                            entries.add(ModNetherBlocks.NETHER_EMERALD_ORE);

                            entries.add(ModOverworldBlocks.BEDROCK);
                            entries.add(ModOverworldBlocks.BEDROCK_SLAB);
                            entries.add(ModOverworldBlocks.BEDROCK_BUTTON);
                            entries.add(ModOverworldBlocks.BEDROCK_PRESSURE_PLATE);
                            entries.add(ModOverworldBlocks.BEDROCK_FENCE);
                            entries.add(ModOverworldBlocks.BEDROCK_FENCE_GATE);
                            entries.add(ModOverworldBlocks.BEDROCK_WALL);
                            entries.add(ModOverworldBlocks.BEDROCK_DOOR);
                            entries.add(ModOverworldBlocks.BEDROCK_TRAPDOOR);


                        }).build());
    public static final ItemGroup GHOST_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "ghost_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK))
                    .displayName(Text.translatable("itemgroup.survival.ghost_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK);
                        entries.add(ModGhostBlocks.NETHER_EMERALD_GHOST_SLAB);
                        entries.add(ModGhostBlocks.NETHER_EMERALD_GHOST_DOOR);
                        entries.add(ModGhostBlocks.NETHER_EMERALD_GHOST_TRAPDOOR);
                    }).build());

    public static final ItemGroup Spawn_Items = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "spawn_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModNetherItems.BLAZE_SPAWN))
                    .displayName(Text.translatable("itemgroup.survival.spawn_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModNetherItems.BLAZE_SPAWN);
                        entries.add(ModNetherItems.WITHER_SPAWN);
                        entries.add(ModNetherItems.FIER_CHARGE_SPAWN);

                        entries.add(ModEndItems.ENDER_DRAGON_SPAWN);

                        entries.add(ModOverworldItems.LIGHTNING_BOLT_SPAWN);
                        entries.add(ModOverworldItems.EVOKER_FANGS_SPAWN);
                    }).build());


    public static final ItemGroup TOOLS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModOverworldItems.CHISEL))
                    .displayName(Text.translatable("itemgroup.survival.tools"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModOverworldItems.CHISEL);
                        entries.add(ModOverworldItems.AIR_CHISEL);

                        entries.add(ModNetherItems.NETHER_EMERALD_SWORD);
                        entries.add(ModNetherItems.NETHER_EMERALD_SHOVEL);
                        entries.add(ModNetherItems.NETHER_EMERALD_HOE);
                        entries.add(ModNetherItems.NETHER_EMERALD_PICKAXE);
                        entries.add(ModNetherItems.NETHER_EMERALD_AXE);

                        entries.add(ModNetherItems.NETHER_EMERALD_HAMMER);

                        entries.add(ModEndItems.END_BOW);

                        entries.add(ModNetherItems.NETHER_EMERALD_BOOTS);
                        entries.add(ModNetherItems.NETHER_EMERALD_CHESTPLATE);
                        entries.add(ModNetherItems.NETHER_EMERALD_HELMET);
                        entries.add(ModNetherItems.NETHER_EMERALD_LEGGINGS);

                        entries.add(ModNetherItems.NETHER_EMERALD_HORSE_ARMOR);
                    }).build());


    public static final ItemGroup FOOD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "food"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModOverworldItems.Healthy_Snack))
                    .displayName(Text.translatable("itemgroup.survival.food"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModOverworldItems.Healthy_Snack);
                    }).build());

    public static final ItemGroup FUEL = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Survival.MOD_ID, "fuel"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModNetherItems.EMERALD_COAL))
                    .displayName(Text.translatable("itemgroup.survival.fuel"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModNetherItems.EMERALD_COAL);
                    }).build());


    public static void registerItemGroups() {
        Survival.LOGGER.info("Registering Item Groups for" + Survival.MOD_ID);
    }
}
