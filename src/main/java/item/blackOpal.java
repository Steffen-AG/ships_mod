package item;


import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class blackOpal extends Item {
	int currBlock;
	BlockState currBlockState;
	
	
	public blackOpal(Properties properties) {
		super(properties);
		currBlock = 0;
		currBlockState = null;
	}
	
	@Override
	public InteractionResultHolder<ItemStack> use(Level world,Player player,InteractionHand hand){
		Inventory inventory = player.getInventory();
		if(currBlock < player.getInventory().items.size()) {
			currBlock++;
			ItemStack currStack = inventory.getItem(currBlock);
			if(Block.byItem(currStack.getItem()) != null && Block.byItem(currStack.getItem()) != Blocks.AIR ){
				  currBlockState = Block.byItem(currStack.getItem()).defaultBlockState();
			  }
		}
		
		return super.use(world, player, hand);
	}
	@Override
	   public InteractionResult useOn(UseOnContext p_41427_) {
		  BlockPos repblock = p_41427_.getClickedPos();
		  Level world = p_41427_.getLevel();
		  BlockState state = world.getBlockState(repblock);
		  Block b = state.getBlock();
		  Inventory inventory = p_41427_.getPlayer().getInventory(); 
		  inventory.add(new ItemStack(b.asItem()));
		  world.setBlock(repblock, currBlockState, EAT_DURATION);
		  //world.destroyBlock(repblock, true);
	      return InteractionResult.PASS;
	   }

	  protected static BlockHitResult raytrace(Level p_41436_, Player p_41437_, ClipContext.Fluid p_41438_) {
		  double range = 15;
		  
	      float f = p_41437_.getXRot();
	      float f1 = p_41437_.getYRot();
	      Vec3 vec3 = p_41437_.getEyePosition(1.0F);
	      float f2 = Mth.cos(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
	      float f3 = Mth.sin(-f1 * ((float)Math.PI / 180F) - (float)Math.PI);
	      float f4 = -Mth.cos(-f * ((float)Math.PI / 180F));
	      float f5 = Mth.sin(-f * ((float)Math.PI / 180F));
	      float f6 = f3 * f4;
	      float f7 = f2 * f4;
	      Vec3 vec31 = vec3.add((double)f6 * range, (double)f5 * range, (double)f7 * range);
	      return p_41436_.clip(new ClipContext(vec3, vec31, ClipContext.Block.OUTLINE, p_41438_, p_41437_));
	   }

}
