package nona.opengl3d;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class Textures {
	
	public static Texture checkerboard;
	public static Texture checkerboard_large;
	
	public static void init() {
		checkerboard = loadTexture("png", "res/textures/checkerboard.png");
		checkerboard_large = loadTexture("png", "res/textures/checkerboard_large.png");
	}
	
	private static Texture loadTexture(String format, String path) {
		try {
			return TextureLoader.getTexture(format, new FileInputStream(new File(path)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
