package item;



import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BanHammer extends Item{

	public BanHammer(Properties p_41383_) {
		super(p_41383_);

	}
	/*
	@Override
	public InteractionResult useOn(UseOnContext p_41427_) {
		
		
		Level world =  p_41427_.getLevel();
		if(!world.isClientSide) {
			BlockPos blockpos = p_41427_.getClickedPos();
			LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(world);
			bolt.moveTo(blockpos.getX(), blockpos.getY(), blockpos.getZ());
			world.addFreshEntity(bolt);
		}
		
	      return InteractionResult.PASS;
	   }
	**/
	@Override
	public InteractionResult interactLivingEntity(ItemStack p_41398_, Player p_41399_, LivingEntity p_41400_, InteractionHand p_41401_) {
		
		Level world = p_41400_.getLevel();
		if(!world.isClientSide) {
			BlockPos blockpos = new BlockPos(p_41400_.getX(), p_41400_.getY() + 10, p_41400_.getZ());
			LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(world);
			world.setRainLevel(1.0F);
			world.setThunderLevel(1.0F);
			/*
			double yVal = p_41400_.getY();
			double newY = yVal + 100;
			
			for(double i = yVal; i < newY; i += 0.000001) {
				p_41400_.moveTo(p_41400_.getX(), i, p_41400_.getZ());
				//p_41399_.sendSystemMessage(Component.literal(String.valueOf(i)));
				}
			**/
			p_41400_.moveTo(blockpos, 0.0F, 0.0F);
			bolt.moveTo(blockpos, 0.0F, 0.0F);
			world.addFreshEntity(bolt);
			world.playSound(p_41399_, p_41399_.getX(), p_41399_.getY(), p_41399_.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
			p_41399_.sendSystemMessage(Component.literal("BANNNNNNNED"));
			p_41400_.setHealth(0);
			/*
			p_41399_.getItemInHand(p_41401_).hurtAndBreak(1, p_41399_, (p_43276_) -> {
	            p_43276_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
	         });
	         **/
		}
	      return InteractionResult.PASS;
	   }
	

}
