package datagen;

import block.ModBlocks;
import com.steffen.testmod.testmod;

import item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, testmod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BLACK_OPAL);
        simpleItem(ModItems.RAW_COBALT);
        simpleItem(ModItems.COABLT_INGOT);

        handheldItem(ModItems.BLOCK_SWAPPER);
        handheldItem(ModItems.COBALT_AXE);
        handheldItem(ModItems.COBALT_PICKAXE);
        handheldItem(ModItems.COBALT_HOE);
        handheldItem(ModItems.COBALT_SHOVEL);
        handheldItem(ModItems.COBALT_SWORD);
        handheldItem(ModItems.TELEPORT_STAFF);
        handheldItem(ModItems.BAN_HAMMER);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(testmod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(testmod.MODID,"item/" + item.getId().getPath()));
    }

}