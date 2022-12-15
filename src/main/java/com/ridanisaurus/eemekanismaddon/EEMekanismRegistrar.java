package com.ridanisaurus.eemekanismaddon;

import com.ridanisaurus.emendatusenigmatica.items.BasicBurnableItem;
import com.ridanisaurus.emendatusenigmatica.items.BasicItem;
import com.ridanisaurus.emendatusenigmatica.loader.parser.model.MaterialModel;
import com.ridanisaurus.emendatusenigmatica.util.Reference;
import mekanism.api.MekanismAPI;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class EEMekanismRegistrar {
	public static final DeferredRegister<Slurry> SLURRIES = DeferredRegister.create(MekanismAPI.slurryRegistryName(), Reference.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

	// Mekanism Compat
	public static Map<String, RegistryObject<Slurry>> dirtySlurryMap = new HashMap<>();
	public static Map<String, RegistryObject<Slurry>> cleanSlurryMap = new HashMap<>();
	public static Map<String, RegistryObject<Item>> crystalMap = new HashMap<>();
	public static Map<String, RegistryObject<Item>> shardMap = new HashMap<>();
	public static Map<String, RegistryObject<Item>> clumpMap = new HashMap<>();
	public static Map<String, RegistryObject<Item>> dirtyDustMap = new HashMap<>();

	public static void registerSlurries(MaterialModel material) {
		String itemNameDirty = "dirty_" + material.getId();
		String itemNameClean = "clean_" + material.getId();

		ResourceLocation ore = new ResourceLocation(Reference.FORGE, "ores/" + material.getId());

		dirtySlurryMap.put(material.getId(), SLURRIES.register(itemNameDirty, () -> new Slurry(SlurryBuilder.dirty().ore(ore).color(material.getColors().getFluidColor()))));
		cleanSlurryMap.put(material.getId(), SLURRIES.register(itemNameClean, () -> new Slurry(SlurryBuilder.clean().ore(ore).color(material.getColors().getFluidColor()))));
	}

	public static void registerCrystals(MaterialModel material) {
		String itemName = material.getId() + "_crystal";
		if (material.getProperties().isBurnable()) {
			crystalMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicBurnableItem(
					material.getProperties().getBurnTime(),
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		} else {
			crystalMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicItem(
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		}
	}

	public static void registerShards(MaterialModel material) {
		String itemName = material.getId() + "_shard";
		if (material.getProperties().isBurnable()) {
			shardMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicBurnableItem(
					material.getProperties().getBurnTime(),
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		} else {
			shardMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicItem(
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		}
	}

	public static void registerClumps(MaterialModel material) {
		String itemName = material.getId() + "_clump";
		if (material.getProperties().isBurnable()) {
			clumpMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicBurnableItem(
					material.getProperties().getBurnTime(),
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		} else {
			clumpMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicItem(
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		}
	}

	public static void registerDirtyDusts(MaterialModel material) {
		String itemName = material.getId() + "_dirty_dust";
		if (material.getProperties().isBurnable()) {
			dirtyDustMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicBurnableItem(
					material.getProperties().getBurnTime(),
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		} else {
			dirtyDustMap.put(material.getId(), ITEMS.register(itemName, () -> new BasicItem(
					material.getColors().getHighlightColor(3),
					material.getColors().getHighlightColor(1),
					material.getColors().getMaterialColor(),
					material.getColors().getShadowColor(1),
					material.getColors().getShadowColor(2)
			)));
		}
	}

	public static void finalize(IEventBus eventBus) {
		SLURRIES.register(eventBus);
		ITEMS.register(eventBus);
	}
}