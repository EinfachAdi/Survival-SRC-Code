package de.einfachadi.survival.datagen;

import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModNetherItems.RAW_NETHER_EMERALD, ModNetherBlocks.NETHER_EMERALD_ORE);

                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModNetherItems.NETHER_EMERALD, 0.25f, 200, "nether_emerald");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModNetherItems.NETHER_EMERALD, 0.25f, 100, "nether_emerald");

                List<ItemConvertible> PINK_GARNET_SMELTABLES1 = List.of(ModNetherBlocks.RAW_NETHER_EMERALD_BLOCK);
                offerBlasting(PINK_GARNET_SMELTABLES1, RecipeCategory.MISC, ModNetherBlocks.NETHER_EMERALD_BLOCK, 3.25f, 725, "nether_emerald_block");

                List<ItemConvertible> PINK_GARNET_SMELTABLES2 = List.of(ModNetherItems.NETHER_EMERALD);
                offerBlasting(PINK_GARNET_SMELTABLES2, RecipeCategory.MISC, ModNetherItems.EMERALD_COAL, 0.25f, 100, "emerald_coal");

                List<ItemConvertible> PINK_GARNET_SMELTABLES3 = List.of(ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK);
                offerBlasting(PINK_GARNET_SMELTABLES3, RecipeCategory.MISC, Items.BEDROCK, 0.25f, 100, "bedrock");



            }
        };
    }

    @Override
    public String getName() {
        return "TutorialMod Recipes";
    }
}