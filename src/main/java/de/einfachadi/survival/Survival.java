package de.einfachadi.survival;

import de.einfachadi.survival.Item.ModEndItems;
import de.einfachadi.survival.Item.ModItemGroups;
import de.einfachadi.survival.Item.ModNetherItems;
import de.einfachadi.survival.Item.ModOverworldItems;
import de.einfachadi.survival.block.ModGhostBlocks;
import de.einfachadi.survival.block.ModNetherBlocks;
import de.einfachadi.survival.block.ModOverworldBlocks;
import de.einfachadi.survival.block.ModSpecialBlocks;
import de.einfachadi.survival.component.ModDataComponentTypes;
import de.einfachadi.survival.enchantment.ModEnchantmentEffects;
import de.einfachadi.survival.util.HammerUsageEvent;
import de.einfachadi.survival.util.ModLootTableModifiers;
import de.einfachadi.survival.villager.ModVillagers;
import de.einfachadi.survival.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.*;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.Box;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.world.GameMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Survival implements ModInitializer {

	//bloodmoon


	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	// ===== BLUTMOND =====
	private static boolean BLOOD_MOON_ACTIVE = false;
	private static final int BLOOD_MOON_INTERVAL = 3; // alle 3 Tage
	private static void startBloodMoon(MinecraftServer server) {

		BLOOD_MOON_ACTIVE = true;

		server.getPlayerManager().broadcast(
				Text.literal("§4☾The Blood Moon rises☾"),
				false
		);




		// Sound für ALLE Spieler (1.21.x korrekt)
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
			player.playSound(
					SoundEvents.ENTITY_WITHER_SPAWN
			);
		}
	}
	private static void endBloodMoon(MinecraftServer server) {

		BLOOD_MOON_ACTIVE = false;

		server.getPlayerManager().broadcast(
				Text.literal("§aThe Blood moon ends."),
				false);




		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

			EntityAttributeInstance scale =
					player.getAttributeInstance(EntityAttributes.SCALE);

			if (scale != null) {
				scale.setBaseValue(1.0D); // 🔥 doppelte Größe
			}}
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

			EntityAttributeInstance scale =
					player.getAttributeInstance(EntityAttributes.SCALE);

			if (scale != null) {
				scale.setBaseValue(1.0D); // 🔥 doppelte Größe
			}}
		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

			EntityAttributeInstance mining =
					player.getAttributeInstance(EntityAttributes.MINING_EFFICIENCY);

			if (mining != null) {
				mining.setBaseValue(1.0D);
			}}

		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

			EntityAttributeInstance movement =
					player.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);

			if (movement != null) {
				movement.setBaseValue(0.1D); // 🔥 doppelte Größe
			}}

		for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {

			EntityAttributeInstance knockback =
					player.getAttributeInstance(EntityAttributes.ATTACK_KNOCKBACK);

			if (knockback != null) {
				knockback.setBaseValue(1.0D); // 🔥 doppelte Größe
			}}
	}

	//bossbar


	private static final ServerBossBar BOSS_BAR =
			new ServerBossBar(
					Text.literal("Enemy"),
					BossBar.Color.RED,
					BossBar.Style.PROGRESS
			);
	//bosses

	//public static final String MOD_ID = "bosses";

	private static final double Skeleton_BOSS_CHANCE = 0.01; // 1 %
	private static void makeBoss_skeleton(SkeletonEntity skeleton) {

		skeleton.getCommandTags().add("boss");

		// ❤️ Leben
		var health = skeleton.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(350.0D); // 175 Herzen
			skeleton.setHealth(skeleton.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = skeleton.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = skeleton.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = skeleton.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = skeleton.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);

		skeleton.setEquipmentDropChance(EquipmentSlot.FEET, 1.0f);
		skeleton.setEquipmentDropChance(EquipmentSlot.LEGS, 1.0f);
		skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 1.0f);
		skeleton.setEquipmentDropChance(EquipmentSlot.HEAD, 1.0f);
		skeleton.setEquipmentDropChance(EquipmentSlot.OFFHAND, 1.0f);
		skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1.0f);

		skeleton.setCustomName(Text.literal("§c☠Skeleton Boss ☠"));

		skeleton.setCustomNameVisible(true);
		skeleton.setGlowing(true);
	}
	private static final double Zombie_BOSS_CHANCE = 0.01; // 1 %
	private static void makeBoss_zombie(ZombieEntity zombie) {

		zombie.getCommandTags().add("boss");

		// ❤️ Leben
		var health = zombie.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(350.0D); // 175 Herzen
			zombie.setHealth(zombie.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = zombie.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = zombie.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = zombie.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = zombie.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);

		zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModNetherItems.NETHER_EMERALD_SWORD));
		zombie.setEquipmentDropChance(EquipmentSlot.FEET, 1.0f);
		zombie.setEquipmentDropChance(EquipmentSlot.LEGS, 1.0f);
		zombie.setEquipmentDropChance(EquipmentSlot.CHEST, 1.0f);
		zombie.setEquipmentDropChance(EquipmentSlot.HEAD, 1.0f);
		zombie.setEquipmentDropChance(EquipmentSlot.OFFHAND, 1.0f);
		zombie.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1.0f);

		zombie.setCustomName(Text.literal("§c☠Zombie Boss☠"));

		zombie.setCustomNameVisible(true);
		zombie.setGlowing(true);
	}

	private static final double Blaze_BOSS_CHANCE = 0.01; // 1 %
	private static void makeBoss_blaze(BlazeEntity blaze) {

		blaze.getCommandTags().add("boss");

		// ❤️ Leben
		var health = blaze.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(150); // 75 Herzen
			blaze.setHealth(blaze.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = blaze.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = blaze.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = blaze.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = blaze.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);

		blaze.setCustomName(Text.literal("§c☠Blaze Boss ☠"));

		blaze.setCustomNameVisible(true);
		blaze.setGlowing(true);
	}
	private static final double Iron_GOLEM_BOSS_CHANCE = 0.01; // 1 %
	private static void makeBoss_iron_golem (IronGolemEntity ironGolem) {

		ironGolem.getCommandTags().add("boss");

		// ❤️ Leben
		var health = ironGolem.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(800); // 400 Herzen
			ironGolem.setHealth(ironGolem.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = ironGolem.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = ironGolem.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = ironGolem.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = ironGolem.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);
		ironGolem.setCustomName(Text.literal("§c☠Iron Golem Boss☠"));

		ironGolem.setCustomNameVisible(true);
		ironGolem.setGlowing(true);
	}
	private static final double EnderMan_BOSS_CHANCE = 0.01; // 11 %
	private static void makeBoss_enderman (EndermanEntity enderman) {

		enderman.getCommandTags().add("boss");

		// ❤️ Leben
		var health = enderman.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(350.0D); // 175 Herzen
			enderman.setHealth(enderman.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = enderman.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = enderman.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = enderman.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = enderman.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);

		enderman.setCustomName(Text.literal("§c☠Enderman Boss ☠"));

		enderman.setCustomNameVisible(true);
		enderman.setGlowing(true);
	}
	private static final double Shulker_BOSS_CHANCE = 0.01; // 1 %
	private static void makeBoss_shulker (ShulkerEntity shulker) {

		shulker.getCommandTags().add("boss");

		// ❤️ Leben
		var health = shulker.getAttributeInstance(EntityAttributes.MAX_HEALTH);
		if (health != null) {
			health.setBaseValue(350.0D); // 175 Herzen
			shulker.setHealth(shulker.getMaxHealth());
		}
		// 🎯 Schaden
		var damage = shulker.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
		if (damage != null) damage.setBaseValue(45.0D);

		// 🏃 Geschwindigkeit
		var speed = shulker.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
		if (speed != null) speed.setBaseValue(0.35D);

		// 🛡 Rüstung
		var armor = shulker.getAttributeInstance(EntityAttributes.ARMOR);
		if (armor != null) armor.setBaseValue(0.0D);

		// 🛡 Rüstung
		var scale = shulker.getAttributeInstance(EntityAttributes.SCALE);
		if (scale != null) scale.setBaseValue(2.0D);

		shulker.setCustomName(Text.literal("§c☠Shulker Boss ☠"));

		shulker.setCustomNameVisible(true);
		shulker.setGlowing(true);
	}
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	//survival
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.



	public static final String MOD_ID = "survival";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {







		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		//bloodmoon

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ServerTickEvents.END_SERVER_TICK.register(server -> {

			ServerWorld world = server.getOverworld();
			if (world == null) return;

			long time = world.getTimeOfDay();
			long day = time / 24000;
			long dayTime = time % 24000;

			boolean isNight = dayTime >= 13000 && dayTime <= 23000;
			boolean isBloodMoonDay = day % BLOOD_MOON_INTERVAL == 0 && day != 0;

			if (isNight && isBloodMoonDay) {
				if (!BLOOD_MOON_ACTIVE) {
					startBloodMoon(server);
				}
			} else {
				if (BLOOD_MOON_ACTIVE) {
					endBloodMoon(server);
				}
			}
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (!BLOOD_MOON_ACTIVE) return;
			if (!(entity instanceof MobEntity mob)) return;

			var damage = mob.getAttributeInstance(EntityAttributes.ATTACK_DAMAGE);
			if (damage != null) {
				damage.setBaseValue(4);
			}
			var armor = mob.getAttributeInstance(EntityAttributes.ARMOR);
			if (armor != null) {
				armor.setBaseValue(10);
			}
			var knockbackresistance = mob.getAttributeInstance(EntityAttributes.KNOCKBACK_RESISTANCE);
			if (knockbackresistance != null) {
				knockbackresistance.setBaseValue(1);
			}
			var speed = mob.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
			if (speed != null) {
				speed.setBaseValue(0.5);
			}
			var watermovement = mob.getAttributeInstance(EntityAttributes.WATER_MOVEMENT_EFFICIENCY);
			if (watermovement != null) {
				watermovement.setBaseValue(1);
			}
			var scale = mob.getAttributeInstance(EntityAttributes.SCALE);
			if (scale != null) {
				scale.setBaseValue(1.5);
			}
		});
		ServerLivingEntityEvents.AFTER_DAMAGE.register((livingEntity, damageSource, v, v1, b) -> {
			if (!(BLOOD_MOON_ACTIVE)) return;
			if (!(livingEntity instanceof PlayerEntity player)) return;
			var scale1 = player.getAttributeInstance(EntityAttributes.SCALE);
			if (scale1 != null) {
				scale1.setBaseValue(1.2);
			}
			var speed1 = player.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED);
			if (speed1 != null) {
				speed1.setBaseValue(0.3);
			}
			var knockback = player.getAttributeInstance(EntityAttributes.ATTACK_KNOCKBACK);
			if (knockback != null) {
				knockback.setBaseValue(30);
			}
			var mining = player.getAttributeInstance(EntityAttributes.MINING_EFFICIENCY);
			if (mining != null) {
				mining.setBaseValue(5);
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 255));
				player.addStatusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 40, 255));

			}
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
			// Nur Spieler
			if (!(BLOOD_MOON_ACTIVE)) return;
			if (!(livingEntity instanceof ServerPlayerEntity player)) return;

			// Nachricht senden
			player.sendMessage(
					Text.literal("§cyou were hit"),
					true // Actionbar
			);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {
			if (!(BLOOD_MOON_ACTIVE)) return;
			if (!(entity instanceof ServerPlayerEntity player)) return;

			// Nachricht an Spieler
			player.sendMessage(
					Text.literal("§4☠you were die, you can spectate the world now."),
					false
			);
			ServerPlayConnectionEvents.JOIN.register((serverPlayNetworkHandler, packetSender, minecraftServer) -> {

				player.sendMessage(
						Text.literal("Join the discord my discord server to get special mod functions https://discord.gg/UZWeT8tTCJ (It`s a german server)")
				);
			});
			// Spectator Mode setzen
			player.changeGameMode(GameMode.SPECTATOR);
		});
		//bossbar
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerWorld world : server.getWorlds()) {
				for (ServerPlayerEntity player : world.getPlayers()) {

					// Suchradius (5 Blöcke)
					Box box = player.getBoundingBox().expand(5);

					var mobs = world.getEntitiesByClass(
							net.minecraft.entity.mob.MobEntity.class,
							box,
							mob -> mob instanceof ZombieEntity || mob instanceof SkeletonEntity
					);

					if (!mobs.isEmpty()) {
						var mob = mobs.get(0); // nächstes Mob

						BOSS_BAR.setName(mob.getName());
						BOSS_BAR.setPercent(mob.getHealth() / mob.getMaxHealth());

						if (!BOSS_BAR.getPlayers().contains(player)) {
							BOSS_BAR.addPlayer(player);
						}
					} else {
						BOSS_BAR.removePlayer(player);
					}
				}
			}
		});

		//bosses

		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof SkeletonEntity skeleton)) return;
			if (skeleton.age > 0) return; // nur echter Spawn
			if (serverWorld.random.nextDouble() > Skeleton_BOSS_CHANCE) return;

			makeBoss_skeleton(skeleton);
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof ZombieEntity zombie)) return;
			if (zombie.age > 0) return;
			if (serverWorld.random.nextDouble() > Zombie_BOSS_CHANCE) return;

			makeBoss_zombie(zombie);

		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof BlazeEntity blaze)) return;
			if (blaze.age > 0) return;
			if (serverWorld.random.nextDouble() > Blaze_BOSS_CHANCE) return;

			makeBoss_blaze(blaze);
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof IronGolemEntity ironGolem)) return;
			if (ironGolem.age > 0) return;
			if (serverWorld.random.nextDouble() > Iron_GOLEM_BOSS_CHANCE) return;

			makeBoss_iron_golem(ironGolem);
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof EndermanEntity enderman)) return;
			if (enderman.age > 0) return;
			if (serverWorld.random.nextDouble() > EnderMan_BOSS_CHANCE) return;

			makeBoss_enderman(enderman);
		});
		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (!(entity instanceof ShulkerEntity shulker)) return;
			if (shulker.age > 0) return;
			if (serverWorld.random.nextDouble() > Shulker_BOSS_CHANCE) return;

			makeBoss_shulker(shulker);
		});
//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof ZombieEntity zombie) {
				if (zombie.getCommandTags().contains("boss")) {
					makeBoss_zombie(zombie);
				}
			}
		});
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ServerEntityEvents.ENTITY_LOAD.register((entity, serverWorld) -> {
			if (entity instanceof ZombieEntity zombie)
				// Eisenrüstung ausrüsten

				zombie.equipStack(EquipmentSlot.HEAD, new ItemStack(ModNetherItems.NETHER_EMERALD_HELMET));
			if (entity instanceof ZombieEntity zombie)
				zombie.equipStack(EquipmentSlot.CHEST, new ItemStack(ModNetherItems.NETHER_EMERALD_CHESTPLATE));
			if (entity instanceof ZombieEntity zombie)
				zombie.equipStack(EquipmentSlot.LEGS, new ItemStack(ModNetherItems.NETHER_EMERALD_LEGGINGS));
			if (entity instanceof ZombieEntity zombie)
				zombie.equipStack(EquipmentSlot.FEET, new ItemStack(ModNetherItems.NETHER_EMERALD_BOOTS));
			if (entity instanceof ZombieEntity zombie)
				zombie.equipStack(EquipmentSlot.MAINHAND, new ItemStack(ModNetherItems.NETHER_EMERALD_SWORD));
			if (entity instanceof ZombieEntity zombie)
				zombie.equipStack(EquipmentSlot.OFFHAND, new ItemStack(ModOverworldItems.LIGHTNING_BOLT_SPAWN));
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.HEAD, 0.01f);
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.CHEST, 0.01f);
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.LEGS, 0.01f);
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.FEET, 0.01f);
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0.01f);
			if (entity instanceof ZombieEntity zombie)
				zombie.setEquipmentDropChance(EquipmentSlot.OFFHAND, 0.01f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.HEAD, new ItemStack(ModNetherItems.NETHER_EMERALD_HELMET));
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.CHEST, new ItemStack(ModNetherItems.NETHER_EMERALD_CHESTPLATE));
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.LEGS, new ItemStack(ModNetherItems.NETHER_EMERALD_LEGGINGS));
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.FEET, new ItemStack(ModNetherItems.NETHER_EMERALD_BOOTS));
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.equipStack(EquipmentSlot.OFFHAND, new ItemStack(ModOverworldItems.Healthy_Snack));
			//verhindert, dass die Rüstung gedroppt wird
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.HEAD, 0.01f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.CHEST, 0.01f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.LEGS, 0.01f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.FEET, 0.01f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1.00f);
			if (entity instanceof SkeletonEntity skeleton)
				skeleton.setEquipmentDropChance(EquipmentSlot.OFFHAND, 0.01f);
			if (entity instanceof PlayerEntity player)
				player.setHealth(20);

		});
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {


			ServerPlayerEntity player = handler.getPlayer();

			int duration = Integer.MAX_VALUE; // praktisch unendlich
			int level = 0; // Level 5 (0 = Level 1)

			player.addStatusEffect(new StatusEffectInstance(
					StatusEffects.WEAKNESS,
					duration,
					level,
					false,
					false
			));
			player.addStatusEffect(new StatusEffectInstance(
					StatusEffects.HUNGER,
					duration,
					level,
					false,
					false
			));
		});

		ServerLivingEntityEvents.AFTER_DEATH.register((entity, damageSource) -> {

			if (!(entity instanceof VillagerEntity villager)) return;
			if (!(villager.getEntityWorld() instanceof ServerWorld world)) return;

			ZombieEntity zombie = EntityType.ZOMBIE.create(world, SpawnReason.CONVERSION);
			if (zombie == null) return;

			zombie.refreshPositionAndAngles(
					villager.getX(),
					villager.getY(),
					villager.getZ(),
					villager.getYaw(),
					villager.getPitch()
			);

			world.spawnEntity(zombie);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {

			if (!(livingEntity instanceof ZombieEntity zombie)) return;
			if (!(zombie.getEntityWorld() instanceof ServerWorld world)) return;

			SkeletonEntity skeleton = EntityType.SKELETON.create(world, SpawnReason.CONVERSION);
			if (skeleton == null) return;

			skeleton.refreshPositionAndAngles(
					zombie.getX(),
					zombie.getY(),
					zombie.getZ(),
					zombie.getYaw(),
					zombie.getPitch()
			);

			world.spawnEntity(skeleton);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, DamageSource) -> {

			if (!(livingEntity instanceof IronGolemEntity ironGolem)) return;
			if (!(ironGolem.getEntityWorld() instanceof ServerWorld world)) return;

			VillagerEntity villager = EntityType.VILLAGER.create(world, SpawnReason.CONVERSION);
			if (villager == null) return;

			villager.refreshPositionAndAngles(
					ironGolem.getX(),
					ironGolem.getY(),
					ironGolem.getZ(),
					ironGolem.getYaw(),
					ironGolem.getPitch()
			);

			world.spawnEntity(villager);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
			if (!(livingEntity instanceof MagmaCubeEntity magmaCube)) return;
			if (!(magmaCube.getEntityWorld() instanceof ServerWorld world)) return;

			SlimeEntity slime = EntityType.SLIME.create(world, SpawnReason.CONVERSION);
			if (slime == null) return;

			slime.refreshPositionAndAngles(
					magmaCube.getX(),
					magmaCube.getY(),
					magmaCube.getZ(),
					magmaCube.getYaw(),
					magmaCube.getPitch()
			);

			world.spawnEntity(slime);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
			if (!(livingEntity instanceof RavagerEntity ravager)) return;
			if (!(ravager.getEntityWorld() instanceof ServerWorld world)) return;

			IronGolemEntity ironGolem = EntityType.IRON_GOLEM.create(world, SpawnReason.CONVERSION);
			if (ironGolem == null) return;

			ironGolem.refreshPositionAndAngles(
					ravager.getX(),
					ravager.getY(),
					ravager.getZ(),
					ravager.getYaw(),
					ravager.getPitch()
			);

			world.spawnEntity(ironGolem);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
			if (!(livingEntity instanceof WitherEntity wither)) return;
			if (!(wither.getEntityWorld() instanceof ServerWorld world)) return;

			WardenEntity warden = EntityType.WARDEN.create(world, SpawnReason.CONVERSION);
			if (warden == null) return;

			warden.refreshPositionAndAngles(
					wither.getX(),
					wither.getY(),
					wither.getZ(),
					wither.getYaw(),
					wither.getPitch()
			);

			world.spawnEntity(warden);
		});
		ServerLivingEntityEvents.AFTER_DEATH.register((livingEntity, damageSource) -> {
			if (!(livingEntity instanceof WardenEntity warden)) return;
			if (!(warden.getEntityWorld() instanceof ServerWorld world)) return;
			IronGolemEntity ironGolem = EntityType.IRON_GOLEM.create(world, SpawnReason.CONVERSION);

			if (ironGolem == null) return;

			ironGolem.refreshPositionAndAngles(
					warden.getX(),
					warden.getY(),
					warden.getZ(),
					warden.getYaw(),
					warden.getPitch()
			);

			world.spawnEntity(ironGolem);
		});

		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof ZombieEntity zombie) {
				if (zombie.getCommandTags().contains("boss")) {
					makeBoss_zombie(zombie);
				}
			}
		});
		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof SkeletonEntity skeleton) {
				if (skeleton.getCommandTags().contains("boss")) {
					makeBoss_skeleton(skeleton);
				}
			}
		});
		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof BlazeEntity blaze) {
				if (blaze.getCommandTags().contains("boss")) {
					makeBoss_blaze(blaze);
				}
			}
		});
		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof IronGolemEntity iron_golem) {
				if (iron_golem.getCommandTags().contains("boss")) {
					makeBoss_iron_golem(iron_golem);
				}
			}
		});
		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof EndermanEntity enderman) {
				if (enderman.getCommandTags().contains("boss")) {
					makeBoss_enderman(enderman);
				}
			}
		});

		//hardcore_plus
		ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
			if (entity instanceof ShulkerEntity shulker) {
				if (shulker.getCommandTags().contains("boss")) {
					makeBoss_shulker(shulker);
				}
			}
		});





		ModItemGroups.registerItemGroups();
		ModNetherItems.registerModItems();
		ModNetherBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		ModEnchantmentEffects.registerEnchantmentEffects();
		ModWorldGeneration.generateModWorldGen();
		ModVillagers.registerVillagers();
		ModLootTableModifiers.modifyLootTables();
		ModEndItems.registerModItems();
		ModOverworldItems.registerModItems();
		ModGhostBlocks.registerModBlocks();
		ModSpecialBlocks.registerModBlocks();
		ModOverworldBlocks.registerModBlocks();


		FuelRegistryEvents.BUILD.register(((builder, context) -> {
			builder.add(ModNetherItems.EMERALD_COAL, 24000);
		}));
		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());


		TradeOfferHelper.registerVillagerOffers(ModVillagers.Netheralder_POI, 1, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 3),
					new ItemStack(ModNetherItems.NETHER_EMERALD_SHARD, 1), 4, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 1),
					new ItemStack(ModNetherItems.NETHER_EMERALD_CLUMP, 3), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Netheralder_POI, 2, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModOverworldItems.CHISEL, 1), 4, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 9),
					new ItemStack(ModNetherBlocks.NETHER_EMERALD_BLOCK, 1), 64, 12, 0.09f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Netheralder_POI, 3, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 7),
					new ItemStack(ModNetherBlocks.NETHER_EMERALD_FENCE, 1), 64, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 8),
					new ItemStack(ModNetherBlocks.NETHER_EMERALD_FENCE_GATE, 1), 64, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 4),
					new ItemStack(ModNetherBlocks.NETHER_EMERALD_PRESSURE_PLATE, 1), 64, 12, 0.09f));

		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Netheralder_POI, 4, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 3),
					new ItemStack(ModNetherItems.NETHER_EMERALD_AXE, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 1),
					new ItemStack(ModNetherItems.NETHER_EMERALD_SHOVEL, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 2),
					new ItemStack(ModNetherItems.NETHER_EMERALD_HOE, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 2),
					new ItemStack(ModNetherItems.NETHER_EMERALD_SWORD, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 3),
					new ItemStack(ModNetherItems.NETHER_EMERALD_PICKAXE, 1), 3, 12, 0.09f));

		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Netheralder_POI, 5, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 8),
					new ItemStack(ModNetherItems.NETHER_EMERALD_HAMMER, 1), 1, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 3),
					new ItemStack(ModEndItems.END_BOW, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 2),
					new ItemStack(ModNetherItems.EMERALD_COAL, 1), 64, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(ModNetherItems.NETHER_EMERALD, 1),
					new ItemStack(ModOverworldItems.AIR_CHISEL, 1), 3, 12, 0.09f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.BEDROCK, 1),
					new ItemStack(ModOverworldItems.Healthy_Snack, 1), 64, 12, 0.09f));

		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Weapon_trader_POI, 1, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 3),
					new ItemStack(ModNetherItems.NETHER_EMERALD_SHOVEL, 1), 4, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.DIAMOND, 6),
					new ItemStack(ModNetherItems.NETHER_EMERALD_HOE, 1), 4, 7, 0.04f));
		});

		TradeOfferHelper.registerVillagerOffers(ModVillagers.Weapon_trader_POI, 2, factories -> {
			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModNetherItems.NETHER_EMERALD_AXE, 1), 4, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 10),
					new ItemStack(ModNetherItems.NETHER_EMERALD_PICKAXE, 1), 4, 7, 0.04f));

			factories.add((world, entity, random) -> new TradeOffer(
					new TradedItem(Items.EMERALD, 7),
					new ItemStack(ModNetherItems.NETHER_EMERALD_SWORD, 1), 4, 7, 0.04f));
		});


	}
}