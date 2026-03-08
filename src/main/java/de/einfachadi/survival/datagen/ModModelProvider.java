package de.einfachadi.survival.datagen;

import de.einfachadi.survival.Item.ModArmorMaterials;
import de.einfachadi.survival.Item.ModEndItems;
import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.Item.ModOverworldItems;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModOverworldBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool netherEmeraldPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModNetherBlocks.NETHER_EMERALD_BLOCK);
        BlockStateModelGenerator.BlockTexturePool BedrockPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModOverworldBlocks.BEDROCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModNetherBlocks.RAW_NETHER_EMERALD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModNetherBlocks.NETHER_EMERALD_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.WEAPON_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.diamond_apple);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.MAGICBLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.ender_dragon_altar);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.evoker_fangs_altar);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.fireball_altar);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.lightning_bolt_altar);
        blockStateModelGenerator.registerSimpleCubeAll(ModSpecialBlocks.wither_altar);

        //netherEmeraldPool.stairs(ModGhostBlocks.NETHER_EMERALD_GHOST_STAIRS);
        netherEmeraldPool.slab(ModGhostBlocks.NETHER_EMERALD_GHOST_SLAB);
        blockStateModelGenerator.registerDoor(ModGhostBlocks.NETHER_EMERALD_GHOST_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModGhostBlocks.NETHER_EMERALD_GHOST_TRAPDOOR);

        //netherEmeraldPool.stairs(ModNetherBlocks.NETHER_EMERALD_STAIRS);
        netherEmeraldPool.slab(ModNetherBlocks.NETHER_EMERALD_SLAB);
        netherEmeraldPool.button(ModNetherBlocks.NETHER_EMERALD_BUTTON);
        netherEmeraldPool.pressurePlate(ModNetherBlocks.NETHER_EMERALD_PRESSURE_PLATE);
        netherEmeraldPool.fence(ModNetherBlocks.NETHER_EMERALD_FENCE);
        netherEmeraldPool.fenceGate(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE);
        netherEmeraldPool.wall(ModNetherBlocks.NETHER_EMERALD_WALL);
        blockStateModelGenerator.registerDoor(ModNetherBlocks.NETHER_EMERALD_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModNetherBlocks.NETHER_EMERALD_TRAPDOOR);

        //BedrockPool.stairs(ModOverworldBlocks.BEDROCK_STAIRS);
        BedrockPool.slab(ModOverworldBlocks.BEDROCK_SLAB);
        BedrockPool.button(ModOverworldBlocks.BEDROCK_BUTTON);
        BedrockPool.pressurePlate(ModOverworldBlocks.BEDROCK_PRESSURE_PLATE);
        BedrockPool.fence(ModOverworldBlocks.BEDROCK_FENCE);
        BedrockPool.fenceGate(ModOverworldBlocks.BEDROCK_FENCE_GATE);
        BedrockPool.wall(ModOverworldBlocks.BEDROCK_WALL);
        blockStateModelGenerator.registerDoor(ModOverworldBlocks.BEDROCK_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModOverworldBlocks.BEDROCK_TRAPDOOR);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.RAW_NETHER_EMERALD, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.EMERALD_COAL, Models.GENERATED);
        itemModelGenerator.register(ModOverworldItems.Healthy_Snack, Models.GENERATED);
        itemModelGenerator.register(ModOverworldItems.CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModOverworldItems.AIR_CHISEL, Models.GENERATED);
        itemModelGenerator.register(ModOverworldItems.DIRT_EMERALD_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_CLUMP, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.UPGRADE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_HORSE_ARMOR, Models.GENERATED);

        itemModelGenerator.register(ModNetherItems.BLAZE_SPAWN, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.WITHER_SPAWN, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.FIER_CHARGE_SPAWN, Models.GENERATED);

        itemModelGenerator.register(ModEndItems.ENDER_DRAGON_SPAWN, Models.GENERATED);

        itemModelGenerator.register(ModOverworldItems.LIGHTNING_BOLT_SPAWN, Models.GENERATED);
        itemModelGenerator.register(ModOverworldItems.EVOKER_FANGS_SPAWN, Models.GENERATED);

        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModNetherItems.NETHER_EMERALD_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(ModNetherItems.GHOST_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.GHOST_FRAGMENT, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.FRAGMENT_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModNetherItems.FRAGMENT_TEMPLATE, Models.GENERATED);
        itemModelGenerator.upload(ModEndItems.END_BOW, Models.BOW);
        itemModelGenerator.registerBow(ModEndItems.END_BOW);

        itemModelGenerator.registerArmor(ModNetherItems.NETHER_EMERALD_HELMET, ModArmorMaterials.NETHER_EMERALD_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModNetherItems.NETHER_EMERALD_CHESTPLATE, ModArmorMaterials.NETHER_EMERALD_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModNetherItems.NETHER_EMERALD_LEGGINGS, ModArmorMaterials.NETHER_EMERALD_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModNetherItems.NETHER_EMERALD_BOOTS, ModArmorMaterials.NETHER_EMERALD_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }
}
