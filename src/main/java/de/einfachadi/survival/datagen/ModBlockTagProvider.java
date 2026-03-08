package de.einfachadi.survival.datagen;

import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import de.einfachadi.survival.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Blocks.NEEDS_NETHER_EMERALD_TOOL)
                .add(ModNetherBlocks.NETHER_EMERALD_BLOCK)
                .add(ModNetherBlocks.NETHER_EMERALD_BUTTON)
                .add(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK)
                .add(ModSpecialBlocks.MAGICBLOCK)
                .add(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE)
                .add(ModNetherBlocks.NETHER_EMERALD_FENCE)
                .add(ModGhostBlocks.NETHER_EMERALD_GHOST_SLAB)
                .add(ModGhostBlocks.NETHER_EMERALD_GHOST_TRAPDOOR)
                .add(ModNetherBlocks.NETHER_EMERALD_PRESSURE_PLATE)
                .add(ModNetherBlocks.NETHER_EMERALD_TRAPDOOR)
                .add(ModNetherBlocks.NETHER_EMERALD_WALL)
                .add(ModSpecialBlocks.diamond_apple);

        valueLookupBuilder(BlockTags.FENCES).add(ModNetherBlocks.NETHER_EMERALD_FENCE);
        valueLookupBuilder(BlockTags.FENCE_GATES).add(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE);
        valueLookupBuilder(BlockTags.WALLS).add(ModNetherBlocks.NETHER_EMERALD_WALL);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModNetherBlocks.NETHER_EMERALD_ORE);

    }
}
