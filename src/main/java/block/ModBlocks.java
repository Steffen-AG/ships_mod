package block;

import com.google.common.base.Supplier;
import com.steffen.testmod.testmod;

import item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = 
			DeferredRegister.create(ForgeRegistries.BLOCKS, testmod.MODID);
	
	public static final RegistryObject<Block> BLACK_OPAL_BLOCK_OBJECT = registerBlock("black_opal_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops() ));
	
	public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(),
					UniformInt.of(2, 10)));
	
	public static final RegistryObject<Block> DEEPSLATE_BLACK_OPAL_ORE = registerBlock("deepslate_black_opal_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(8f).requiresCorrectToolForDrops(),
					UniformInt.of(2, 10)));

	public static final RegistryObject<Block> NETHERRACK_BLACK_OPAL_ORE = registerBlock("netherrack_black_opal_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops(),
					UniformInt.of(2, 10)));
	
	public static final RegistryObject<Block> ENDSTONE_BLACK_OPAL_ORE = registerBlock("endstone_black_opal_ore",
			() -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(9f).requiresCorrectToolForDrops(),
					UniformInt.of(2, 10)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	
	public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
				new Item.Properties()));
		
	}
	
	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

}
