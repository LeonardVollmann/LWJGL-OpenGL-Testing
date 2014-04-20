package nona.opengl3d;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glLoadIdentity;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;


public class Main {

	public static final int WIDTH = 960;
	public static final int HEIGHT = 640;
	
	public static void main(String[] args) {
		initDisplay();
		Textures.init();
		loop();
		cleanUp();
	}
	
	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setFullscreen(true);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}

		Display.setVSyncEnabled(true);
		Display.setTitle("OpenGL");
	}
	
	private static void loop() {
		Camera camera = new Camera(70, (float) Display.getWidth() / (float) Display.getHeight(), 0.3f, 1000);
		
		float cx = 0;
		
		while(!Display.isCloseRequested()) {
			if(Keyboard.isKeyDown(Keyboard.KEY_W)) camera.move(1, 0.2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_S)) camera.move(1, -0.2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_A)) camera.move(0, 0.2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_D)) camera.move(0, -0.2f);
			if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)) camera.rotateY(-2);
			if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) camera.rotateY(2);
			if(Keyboard.isKeyDown(Keyboard.KEY_UP)) camera.rotateX(-2);
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)) camera.rotateX(2);
			if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)) camera.ascend(0.25f);
			if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) camera.descend(0.25f);
			
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glLoadIdentity();
			
			camera.setView();
			
			Draw.plane(0, -5, 0, 300, Textures.checkerboard_large);
			
//			for(int x = 0; x < 10; x++) {
//				for(int y = 0; y < 10; y++) {
//					for(int z = 0; z < 10; z++) {
//						Draw.cube(x * 4, y * 4, -5 + z * -4, 0, cx, cx, 2, Textures.checkerboard);		
//					}
//				}
//			}
			
			Draw.cube(0, 2, -5, cx, 0, 0, 2, Textures.checkerboard);
						
			Draw.sphere(0, 2, -5, cx, 0, 0, 5, 100, 100);
			
			cx += 1f;
			
			Display.update();
		}
		cleanUp();
	}
	
	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}
	
}
