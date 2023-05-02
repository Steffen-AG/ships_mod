package item;

import com.steffen.testmod.testmod;

import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, testmod.MODID); 
	
	

	
	public static final RegistryObject<Item> BLOCK_SWAPPER = ITEMS.register("block_swapper", () -> new BockSwapper(new Item.Properties()));
	
	public static final RegistryObject<Item> TELEPORT_STAFF = ITEMS.register("teleport_staff", () -> new teleportStaff(new Item.Properties().stacksTo(1).defaultDurability(20)));
	
	public static final RegistryObject<Item> COABLT_INGOT = ITEMS.register("cobalt_ingot", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<Item> COBALT_SWORD = ITEMS.register("cobalt_sword", () -> new SwordItem(Tiers.NETHERITE, 5, -2.4F, (new Item.Properties().defaultDurability(300))));
	
	public static final RegistryObject<Item> COBALT_PICKAXE = ITEMS.register("cobalt_pickaxe", () -> new PickaxeItem(Tiers.NETHERITE, 1, -1.0F, (new Item.Properties())));
	
	public static final RegistryObject<Item> COBALT_SHOVEL = ITEMS.register("cobalt_shovel", () -> new ShovelItem(Tiers.NETHERITE, 1.5F, -3.0F, (new Item.Properties())));
	
	public static final RegistryObject<Item> COBALT_AXE = ITEMS.register("cobalt_axe", () -> new AxeItem(Tiers.NETHERITE, 5.0F, 3.0F, (new Item.Properties())));
	
	public static final RegistryObject<Item> COBALT_HOE = ITEMS.register("cobalt_hoe", () -> new HoeItem(Tiers.NETHERITE, -4, 0.0F, (new Item.Properties())));

	public static final RegistryObject<Item> BAN_HAMMER = ITEMS.register("ban_hammer", () -> new BanHammer(new Item.Properties().stacksTo(1).defaultDurability(100)));

	public static final  RegistryObject<Item> COBALT_BOAT = ITEMS.register("cobalt_boat",() -> new CoolBoatItem(true, Boat.Type.OAK, new Item.Properties().stacksTo(1)));

	//public static final RegistryObject<Item> COBALT_BOOTS = ITEMS.register("cobalt_boots", () -> new ArmorItem())

	
	public static void register(IEventBus eventBus) {
		ITEMS.register(eventBus);
	}

}
