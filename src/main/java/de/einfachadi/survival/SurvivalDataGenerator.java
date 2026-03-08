package de.einfachadi.survival;

import de.einfachadi.survival.datagen.*;
import de.einfachadi.survival.enchantment.ModEnchantments;
import de.einfachadi.survival.world.ModConfiguredFeatures;
import de.einfachadi.survival.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class SurvivalDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModBlockTagProvider::new);
		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModRegistryDataGenerator::new);
	}
		@Override
		public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);

			registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
			registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
	}}
