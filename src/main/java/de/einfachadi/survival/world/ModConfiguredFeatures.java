package de.einfachadi.survival.world;

import de.einfachadi.survival.Survival;
import de.einfachadi.survival.block.ModNetherBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = registerKey("nether_emerald_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> netherNetherEmeraldOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModNetherBlocks.NETHER_EMERALD_ORE.getDefaultState()));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherNetherEmeraldOres, 9));



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Survival.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}