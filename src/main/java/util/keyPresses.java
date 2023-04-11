package util;

import org.lwjgl.glfw.GLFW;

import com.mojang.blaze3d.platform.InputConstants;

import net.minecraft.client.Minecraft;

public class keyPresses {
	
	public static final long GAME = Minecraft.getInstance().getWindow().getWindow();
	
	public static boolean holdShift() {
		return InputConstants.isKeyDown(GAME, GLFW.GLFW_KEY_LEFT_SHIFT) || InputConstants.isKeyDown(GAME, GLFW.GLFW_KEY_RIGHT_SHIFT);
	}
	

}
