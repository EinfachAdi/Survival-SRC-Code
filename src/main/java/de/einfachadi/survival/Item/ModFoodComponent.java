package de.einfachadi.survival.Item;

import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModFoodComponent {
    public static final FoodComponent HealthySnack = new FoodComponent.Builder().nutrition(20).saturationModifier(20).build();


public static final ConsumableComponent HealthySnack_EFFECT = ConsumableComponents.food()
        .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 2000),0.75f)).build();
}