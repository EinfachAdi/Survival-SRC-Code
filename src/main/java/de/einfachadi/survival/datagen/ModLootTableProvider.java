package de.einfachadi.survival.datagen;

import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModNetherBlocks.NETHER_EMERALD_BLOCK);
        addDrop(ModNetherBlocks.RAW_NETHER_EMERALD_BLOCK);
        addDrop(ModSpecialBlocks.MAGICBLOCK);
        addDrop(ModSpecialBlocks.diamond_apple);
        addDrop(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK);

        addDrop(ModNetherBlocks.NETHER_EMERALD_SLAB, slabDrops(ModNetherBlocks.NETHER_EMERALD_SLAB));

        addDrop(ModNetherBlocks.NETHER_EMERALD_BUTTON);
        addDrop(ModNetherBlocks.NETHER_EMERALD_PRESSURE_PLATE);

        addDrop(ModNetherBlocks.NETHER_EMERALD_FENCE);
        addDrop(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE);
        addDrop(ModNetherBlocks.NETHER_EMERALD_WALL);


        addDrop(ModNetherBlocks.NETHER_EMERALD_ORE, oreDrops(ModNetherBlocks.NETHER_EMERALD_ORE, ModNetherItems.NETHER_EMERALD_CLUMP));
    }
}
