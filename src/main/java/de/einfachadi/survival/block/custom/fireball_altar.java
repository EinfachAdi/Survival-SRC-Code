package de.einfachadi.survival.block.custom;

import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class fireball_altar extends Block {
    public fireball_altar(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player,
                                 BlockHitResult hit) {
        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }
    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof ItemEntity itemEntity) {
            if (isValidItem(itemEntity.getStack())) {
                itemEntity.setStack(new ItemStack(ModNetherItems.FIER_CHARGE_SPAWN, itemEntity.getStack().getCount()));
        }
    }
        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.spawn_items.SPAWN_ITEMS);
    }
}
