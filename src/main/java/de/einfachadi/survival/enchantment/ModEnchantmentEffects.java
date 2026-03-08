package de.einfachadi.survival.enchantment;

import com.mojang.serialization.MapCodec;
import de.einfachadi.survival.Survival;
import de.einfachadi.survival.enchantment.custom.*;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER =
            registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> GUARD =
            registerEntityEffect("guard", GuardEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> TNT =
            registerEntityEffect("tnt", TntEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> EXPERIENCE =
            registerEntityEffect("experience", ExperienceEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> NO_GRAVITY =
            registerEntityEffect("no_gravity", NoGravityEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> GRAVITY =
            registerEntityEffect("gravity", GravityEnchantmentEffect.CODEC);




    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name,
                                                                                    MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(Survival.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        Survival.LOGGER.info("Registering Mod Enchantment Effects for " + Survival.MOD_ID);
    }
}