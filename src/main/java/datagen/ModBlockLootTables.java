package datagen;

import java.util.Set;

import block.ModBlocks;
import item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLootSubProvider{

	public ModBlockLootTables() {
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void generate() {
		dropSelf(ModBlocks.BLACK_OPAL_BLOCK_OBJECT.get());
		
		add(ModBlocks.COBALT_ORE.get(), (block) -> createOreDrop(ModBlocks.COBALT_ORE.get(), ModItems.RAW_BLACK_OPAL.get()) );
	}
	
	@Override
	protected Iterable<Block> getKnownBlocks(){
		return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
	}
	 

}
