package com.steffen.testmod;



import entity.ModEntities;
import entity.custom.CoolBoat;
import entity.render.CoolBoatRenderer;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import block.ModBlocks;
import item.ModCreativeModeTabs;
import item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


@Mod(testmod.MODID)

public class testmod {
	
	public static final String MODID = "testmod";
	private static final Logger LOGGER = LogUtils.getLogger();
	
	public testmod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ModItems.register(modEventBus);
		ModBlocks.register(modEventBus);
		ModEntities.register(modEventBus);
		
		modEventBus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::addCreative);
	}
	private void commonSetup(final FMLCommonSetupEvent event) {
		
	}
	private void addCreative(CreativeModeTabEvent.BuildContents event) {
		if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.COABLT_INGOT);
			event.accept(ModItems.RAW_COBALT);
		}
		if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(ModBlocks.COBALT_BLOCK);
			event.accept(ModBlocks.COBALT_ORE);

		}
		if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
			event.accept(ModBlocks.COBALT_ORE);

		}
		if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB) {
			event.accept(ModItems.COBALT_BOAT);
			event.accept(ModItems.BAN_HAMMER);
			event.accept(ModItems.COBALT_HOE);
			event.accept(ModItems.COBALT_AXE);
			event.accept(ModItems.COBALT_SHOVEL);
			event.accept(ModItems.COBALT_PICKAXE);
			event.accept(ModItems.COBALT_SWORD);
			event.accept(ModItems.TELEPORT_STAFF);
			event.accept(ModItems.COABLT_INGOT);
			event.accept(ModItems.BLOCK_SWAPPER);
			event.accept(ModItems.RAW_COBALT);
			event.accept(ModBlocks.COBALT_BLOCK);
			event.accept(ModBlocks.COBALT_ORE);
			event.accept(ModBlocks.DEEPSLATE_COBALT_ORE);
			event.accept(ModBlocks.NETHERRACK_COBALT_ORE);
		}
	}
	
	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			//EntityRenderers.register(ModEntities.COOLBOAT.get(), CoolBoatRenderer::new);
		}
	}
	
	
	

}


