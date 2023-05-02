package entity.render;

import com.steffen.testmod.testmod;
import entity.custom.CoolBoat;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.vehicle.Boat;

public class CoolBoatRenderer<T extends CoolBoat> extends EntityRenderer {

    public static final ResourceLocation BOAT_TEXTURE =
            new ResourceLocation(testmod.MODID, "assets/entity/boat/cobalt.png");

    public CoolBoatRenderer(EntityRendererProvider.Context p_234563_, boolean p_234564_) {
        super(p_234563_);
    }
    /*
    @Override
    public ResourceLocation getTextureLocation(Boat p_113927_) {
        return BOAT_TEXTURE;
    }
    */
    @Override
    public ResourceLocation getTextureLocation(Entity p_114482_) {
        return BOAT_TEXTURE;
    }
}
