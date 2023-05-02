package entity;

import com.steffen.testmod.testmod;
import entity.custom.CoolBoat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, testmod.MODID);

    public static final RegistryObject<EntityType<CoolBoat>> COOLBOAT =
            ENTITY_TYPES.register("cool_boat",
                    () -> EntityType.Builder.<CoolBoat>of(CoolBoat::new, MobCategory.MISC)
                            .sized(1.5f, 1.75f)
                            .build(new ResourceLocation(testmod.MODID, "cool_boat").toString()));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
