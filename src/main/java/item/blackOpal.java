package item;


import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateHolder;
import util.keyPresses;

public class blackOpal extends Item {
	int currBlock;
	BlockState currBlockState;
	ItemStack currBlockStack;


	public blackOpal(Properties properties) {
		super(properties);
		currBlock = 0;
		currBlockStack = new ItemStack(Blocks.DIRT);
		currBlockState = Blocks.DIRT.defaultBlockState();
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world,Player player,InteractionHand hand){
		if(!world.isClientSide() && hand == InteractionHand.MAIN_HAND) {

			
			if(keyPresses.holdShift()) {
				currBlockState = getNextBlock(player);
				//player.sendSystemMessage(Component.literal("current block is " + currBlockStack.getDisplayName().toString()));
			}

		}

		return super.use(world, player, hand);
	}

	public BlockState getNextBlock(Player player) {

		Inventory inventory = player.getInventory();
		currBlock = currBlock + 1;
		ItemStack currStack = inventory.getItem(currBlock);

		while(Block.byItem(currStack.getItem()) == null || Block.byItem(currStack.getItem()) == Blocks.AIR) {
			currBlock++;
			if(currBlock >= player.getInventory().items.size()) {
				currBlock = 0;
			}
			currStack = inventory.getItem(currBlock);
		}
		currBlockStack = currStack;
		return Block.byItem(currStack.getItem()).defaultBlockState();
	}


	@Override
	public InteractionResult useOn(UseOnContext p_41427_) {
		if(!p_41427_.getLevel().isClientSide() && p_41427_.getHand() == InteractionHand.MAIN_HAND) {
			Inventory inventory = p_41427_.getPlayer().getInventory(); 
			if(currBlockStack.getCount() > 0) {
				currBlockStack.setCount(currBlockStack.getCount()-1);
				BlockPos repblock = p_41427_.getClickedPos();
				Level world = p_41427_.getLevel();
				Block getBlock = world.getBlockState(repblock).getBlock();
				inventory.add(new ItemStack(getBlock.asItem()));
				world.playLocalSound(repblock, currBlockState.getSoundType().getBreakSound(), null, 100, 100, true);
				world.setBlock(repblock, currBlockState, EAT_DURATION);
			}
		}
		return InteractionResult.PASS;
	}

	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
		tooltip.add(Component.literal(currBlockStack.getDisplayName().getString() + " " + currBlock + " " + currBlockStack.getCount()));

		super.appendHoverText(stack, worldIn, tooltip, flagIn);
	}


}
