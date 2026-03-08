package de.einfachadi.survival.world.gen;

import de.einfachadi.survival.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES,
                ModPlacedFeatures.NETHER_EMERALD_ORE_PLACED_KEY);

        // Example for individual Bioms
        // BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FOREST, BiomeKeys.PLAINS),
        // GenerationStep.Feature.UNDERGROUND_ORES,
        //         ModPlacedFeatures.PINK_GARNET_ORE_PLACED_KEY);


    }
}