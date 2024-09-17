package flappyBird.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallback;

public class Input extends GLFWKeyCallback{
	
	public static boolean[] keys = new boolean[65536];
	public static int num = 0;
	

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods) {
		num++;
		keys[key] = action != GLFW.GLFW_RELEASE;
	}

}
