package de.einfachadi.survival.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;


public record GravityEnchantmentEffect() implements EnchantmentEntityEffect {
    public static final MapCodec<GravityEnchantmentEffect> CODEC = MapCodec.unit(GravityEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context,Entity user, Vec3d pos) {
        if (level == 1) ;{

        user.setNoGravity(false);
            PlayerEntity.createPlayerAttributes().add(EntityAttributes.SAFE_FALL_DISTANCE,3);


        }
    }
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}