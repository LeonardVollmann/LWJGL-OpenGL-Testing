package nona.opengl3d;

import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_MODELVIEW;
import static org.lwjgl.opengl.GL11.GL_PROJECTION;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;

import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glMatrixMode;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.util.glu.GLU.gluPerspective;

public class Camera {
	
	private float x;
	private float y;
	private float z;
	
	private float rx;
	private float ry;
	private float rz;
	
	private float fov;
	private float ar;
	private float near;
	private float far;
	
	public Camera(float fov, float ar, float near, float far) {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.rx = 0;
		this.ry = 0;
		this.rz = 0;
		
		this.fov = fov;
		this.ar = ar;
		this.near = near;
		this.far = far;
		
		initProjection();
	}
	
	private void initProjection() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		gluPerspective(fov, ar, near, far);
		glMatrixMode(GL_MODELVIEW);
		
		glEnable(GL_DEPTH_TEST);
		glEnable(GL_TEXTURE_2D);
	}
	
	public void setView() {
		glRotatef(rx, 1, 0, 0);
		glRotatef(ry, 0, 1, 0);
		glRotatef(rz, 0, 0, 1);
		
		glTranslatef(x, y, z);
	}
	
	public void move(float direction, float amount) {
		z += Math.sin(Math.toRadians(ry + 90 * direction)) * amount;
		x += Math.cos(Math.toRadians(ry + 90 * direction)) * amount;
//		y += Math.sin(Math.toRadians(rx * direction)) * amount;
	}
	
	public void ascend(float amount) {
		y -= amount;
	}
	
	public void descend(float amount) {
		y += amount;
	}
	
	public void rotateY(float amount) {
		ry += amount;
	}
	
	public void rotateX(float amount) {
		rx += amount;
	}
	
	public void rotateZ(float amount) {
		rz += amount;
	}
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getRx() {
		return rx;
	}

	public void setRx(float rx) {
		this.rx = rx;
	}

	public float getRy() {
		return ry;
	}

	public void setRy(float ry) {
		this.ry = ry;
	}

	public float getRz() {
		return rz;
	}

	public void setRz(float rz) {
		this.rz = rz;
	}

	public float getFov() {
		return fov;
	}

	public void setFov(float fov) {
		this.fov = fov;
	}

	public float getAr() {
		return ar;
	}

	public void setAr(float ar) {
		this.ar = ar;
	}

	public float getNear() {
		return near;
	}

	public void setNear(float near) {
		this.near = near;
	}

	public float getFar() {
		return far;
	}

	public void setFar(float far) {
		this.far = far;
	}
	
}
