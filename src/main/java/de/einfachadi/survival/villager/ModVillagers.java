package de.einfachadi.survival.villager;


import com.google.common.collect.ImmutableSet;
import de.einfachadi.survival.Survival;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> Netheralder_POI_KEY = registerPoiKey("netherald_poi");
    public static final PointOfInterestType Netherald_POI = registerPOI("netherald_poi", ModGhostBlocks.NETHER_EMERALD_GHOST_BLOCK);

    public static final RegistryKey<VillagerProfession> Netheralder_POI =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(Survival.MOD_ID, "netheralder"));
    public static final VillagerProfession Netheralder = registerProfession("netheralder", Netheralder_POI_KEY);


    public static final RegistryKey<PointOfInterestType> Weapon_trader_POI_KEY = registerPoiKey("weapon_poi");
    public static final PointOfInterestType Weapon_POI = registerPOI("weapon_poi", ModSpecialBlocks.WEAPON_BLOCK);

    public static final RegistryKey<VillagerProfession> Weapon_trader_POI =
            RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(Survival.MOD_ID, "weapon_trader"));
    public static final VillagerProfession Weapon_trader = registerProfession("weapon_trader", Weapon_trader_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(Survival.MOD_ID, name),
                new VillagerProfession(Text.literal("weapon_trader"), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(Survival.MOD_ID, name),
                1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Survival.MOD_ID, name));
    }

    public static void registerVillagers() {
        Survival.LOGGER.info("Registering Villagers for " + Survival.MOD_ID);
    }
}