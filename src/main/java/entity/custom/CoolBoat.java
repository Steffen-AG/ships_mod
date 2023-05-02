package entity.custom;

import entity.ModEntities;
import item.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CoolBoat extends ChestBoat {
    public CoolBoat(EntityType<? extends ChestBoat> p_38290_, Level p_38291_) {
        super(p_38290_, p_38291_);
    }

    public CoolBoat(Level p_219872_, double p_219873_, double p_219874_, double p_219875_) {
        this(ModEntities.COOLBOAT.get(), p_219872_);
        this.setPos(p_219873_, p_219874_, p_219875_);
        this.xo = p_219873_;
        this.yo = p_219874_;
        this.zo = p_219875_;
    }

    @Override
    public Item getDropItem() {

        return ModItems.COBALT_BOAT.get();
    }
}
