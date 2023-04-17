package com.steffen.testmod;



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
		
		modEventBus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.register(this);
		
		modEventBus.addListener(this::addCreative);
	}
	private void commonSetup(final FMLCommonSetupEvent event) {
		
	}
	private void addCreative(CreativeModeTabEvent.BuildContents event) {
		if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
			event.accept(ModItems.COABLT_INGOT);
			event.accept(ModItems.BLACK_OPAL);
			event.accept(ModItems.RAW_COBALT);
		}
		if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
			event.accept(ModBlocks.COBALT_BLOCK);
			event.accept(ModBlocks.COBALT_ORE);
			event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.ENDSTONE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.NETHERRACK_BLACK_OPAL_ORE);
		}
		if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
			event.accept(ModBlocks.COBALT_ORE);
			event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.ENDSTONE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.NETHERRACK_BLACK_OPAL_ORE);
		}
		if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB) {
			event.accept(ModItems.TELEPORT_STAFF);
			event.accept(ModItems.COABLT_INGOT);
			event.accept(ModItems.BLOCK_SWAPPER);
			event.accept(ModItems.BLACK_OPAL);
			event.accept(ModItems.RAW_COBALT);
			event.accept(ModBlocks.COBALT_BLOCK);
			event.accept(ModBlocks.COBALT_ORE);
			event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.ENDSTONE_BLACK_OPAL_ORE);
			event.accept(ModBlocks.NETHERRACK_BLACK_OPAL_ORE);
		}
	}
	
	@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientModEvents {
		@SubscribeEvent
		public static void onClientSetup(FMLClientSetupEvent event) {
			
		}
	}
	
	
	

}


