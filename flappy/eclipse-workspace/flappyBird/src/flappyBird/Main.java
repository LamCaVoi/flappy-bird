
package flappyBird;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.glfw.GLFWVidMode;

import flappyBird.input.Input;

public class Main implements Runnable {

	private int width = 1280;
	private int height = 720;
	private String title = "Flappy Bird <(*)";
	private boolean running = false;
	private Thread thread;
	private long window;

	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	@Override
	public void run() {
		init();
		while (running) {
			update();
			render();

			if (glfwWindowShouldClose(window) == true) {
				glfwTerminate();
				running = false;
			}
		}
	}

	private void render() {
		glfwSwapBuffers(window);

	}

	private void update() {
		glfwPollEvents();

		if (Input.keys[GLFW_KEY_SPACE]) {
			System.out.println("FLapp!!!" + Input.num);
		}

	}

	public void init() {
		if (!glfwInit()) {
			throw new IllegalStateException("Failed to initilize GLFW");
		}

		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);

		window = glfwCreateWindow(width, height, title, NULL, NULL);
		if (window == 0) {
			throw new IllegalStateException("Failed to initilize the window");
		}

		GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		glfwSetWindowPos(window, (videoMode.width() - width) / 2, (videoMode.height() - height) / 2);

		glfwSetKeyCallback(window, new Input());

		glfwMakeContextCurrent(window);
		glfwShowWindow(window);

	}

	public static void main(String[] args) {
		new Main().start();

	}

}
