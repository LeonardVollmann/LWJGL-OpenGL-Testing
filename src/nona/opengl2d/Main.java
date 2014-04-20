package nona.opengl2d;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {

	public static final int WIDTH = 960;
	public static final int HEIGHT = 640;
	
	public static void main(String[] args) {
		initDisplay();
		initOpenGL();
		loop();
		cleanUp();
	}
	
	private static void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		Display.setTitle("OpenGL");
		Display.setVSyncEnabled(true);
	}
	
	private static void initOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, 0, HEIGHT, 1, -1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	private static void loop() {
		while(!Display.isCloseRequested()) {
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			glBegin(GL_QUADS);
			{
				
			}
			glEnd();
		}
		
		Display.update();
		Display.sync(60);
	}
	
	private static void cleanUp() {
		Display.destroy();
		Keyboard.destroy();
	}
	
}
