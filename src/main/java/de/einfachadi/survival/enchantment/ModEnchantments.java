package de.einfachadi.survival.enchantment;

import de.einfachadi.survival.Survival;
import de.einfachadi.survival.enchantment.custom.*;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> LIGHTNING_STRIKER =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "lightning_striker"));

    public static final RegistryKey<Enchantment> GUARD =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "guard"));

    public static final RegistryKey<Enchantment> TNT =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "tnt"));

    public static final RegistryKey<Enchantment> EXPERIENCE =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "experience"));

    public static final RegistryKey<Enchantment> NO_GRAVITY =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "no_gravity"));

    public static final RegistryKey<Enchantment> GRAVITY =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Survival.MOD_ID, "gravity"));




    public static void bootstrap(Registerable<Enchantment> registerable) {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, LIGHTNING_STRIKER, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.SWORDS),
                        5,
                        2,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new LightningStrikerEnchantmentEffect()));

        register(registerable, GUARD, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.SWORDS),
                        5,
                        3,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new GuardEnchantmentEffect()));

        register(registerable, TNT, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.SWORDS),
                        5,
                        6,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER, EnchantmentEffectTarget.VICTIM,
                        new TntEnchantmentEffect()));

        register(registerable, EXPERIENCE, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.SWORDS),

                        5,
                        5,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.MAINHAND))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
                        EnchantmentEffectTarget.ATTACKER,
                        EnchantmentEffectTarget.VICTIM,
                        new ExperienceEnchantmentEffect()));



    register(registerable, NO_GRAVITY, Enchantment.builder(Enchantment.definition(
            items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),

                        5,
                                1,
                                Enchantment.leveledCost(5, 7),
                                Enchantment.leveledCost(25, 9),
                                2,
    AttributeModifierSlot.FEET))
            .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE_SET))
            .addEffect(EnchantmentEffectComponentTypes.TICK,
                        new NoGravityEnchantmentEffect()));


        register(registerable, GRAVITY, Enchantment.builder(Enchantment.definition(
                        items.getOrThrow(ItemTags.FOOT_ARMOR_ENCHANTABLE),

                        5,
                        1,
                        Enchantment.leveledCost(5, 7),
                        Enchantment.leveledCost(25, 9),
                        2,
                        AttributeModifierSlot.FEET))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.BOOTS_EXCLUSIVE_SET))
                .addEffect(EnchantmentEffectComponentTypes.TICK,
                        new GravityEnchantmentEffect()));



}


    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}