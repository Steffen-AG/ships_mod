package item;

import com.steffen.testmod.testmod;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = testmod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
	public static CreativeModeTab TUTORIAL_TAB;
	
	@SubscribeEvent
	public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
		TUTORIAL_TAB = event.registerCreativeModeTab(new ResourceLocation(testmod.MODID, "mod_tab"),
				builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
				.title(Component.translatable("Mod_tab")));
	}

}
