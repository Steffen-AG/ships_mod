package com.steffen.testmod;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;


@Mod(testmod.MODID)

public class testmod {
	
	public static final String MODID = "testmod";
	public static Block TestBlock;
	
	public static void init() {
		TestBlock = new Block(BlockBehaviour.Properties.of(Material.STONE).color(MaterialColor.COLOR_BLACK));
	}
	public void buildContents(CreativeModeTabEvent.BuildContents event) {
		if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
			event.accept(TestBlock);
		}
	}
	
	public testmod() {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(TestBlock);
	}

}
