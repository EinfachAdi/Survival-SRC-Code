package de.einfachadi.survival.datagen;

import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.NETHERITE_INGOT);
        valueLookupBuilder(ModTags.Items.spawn_items.SPAWN_ITEMS)
                .add(ModNetherItems.UPGRADE_TEMPLATE);
        valueLookupBuilder(ModTags.Items.boss_spawn_items.BOSS_SPAWN_ITEMS)
                .add(Items.DRAGON_EGG);

        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModNetherItems.NETHER_EMERALD_SHOVEL);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModNetherItems.NETHER_EMERALD_AXE);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModNetherItems.NETHER_EMERALD_HOE);

        valueLookupBuilder(ModTags.Items.NETHER_EMERALD_REPAIR)
                .add(ModNetherItems.NETHER_EMERALD);


        valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModNetherItems.NETHER_EMERALD_HELMET)
                .add(ModNetherItems.NETHER_EMERALD_CHESTPLATE)
                .add(ModNetherItems.NETHER_EMERALD_LEGGINGS)
                .add(ModNetherItems.NETHER_EMERALD_BOOTS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR)
        .add(ModNetherItems.NETHER_EMERALD_BOOTS);

        valueLookupBuilder(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModNetherItems.NETHER_EMERALD_BOOTS);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModNetherItems.NETHER_EMERALD_SWORD);

        valueLookupBuilder(ItemTags.WEAPON_ENCHANTABLE)
                .add(ModNetherItems.NETHER_EMERALD_SWORD)
                .add(ModNetherItems.NETHER_EMERALD_AXE);

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
                .add(ModNetherItems.NETHER_EMERALD);

    }

}
