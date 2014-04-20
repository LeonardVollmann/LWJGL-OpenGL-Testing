package nona.opengl3d;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;
import static org.lwjgl.util.glu.GLU.GLU_LINE;

import org.lwjgl.util.glu.Sphere;
import org.newdawn.slick.opengl.Texture;

public class Draw {

	public static void cube(float x, float y, float z, float rx, float ry, float rz, float s, Texture t) {
		s /= 2;
		
		glPushMatrix();
			{
			t.bind();
				
			glTranslatef(x, y, z);
			
			glRotatef(rx, 1, 0, 0);
			glRotatef(ry, 0, 1, 0);
			glRotatef(rz, 0, 0, 1);
			
			glBegin(GL_QUADS);
			{
				//FrontFace
				glColor3f(1, 0, 0);
				glTexCoord2f(0, 0); glVertex3f(-s,-s,s);
				glTexCoord2f(0, 1); glVertex3f(-s,s,s);
				glTexCoord2f(1, 1); glVertex3f(s,s,s);
				glTexCoord2f(1, 0); glVertex3f(s,-s,s);
	
				//BackFace
				glColor3f(0, 1, 0);
				glTexCoord2f(0, 0); glVertex3f(-s,-s,-s);
				glTexCoord2f(0, 1); glVertex3f(-s,s,-s);
				glTexCoord2f(1, 1); glVertex3f(s,s,-s);
				glTexCoord2f(1, 0); glVertex3f(s,-s,-s);
	
				//BottomFace
				glColor3f(0, 0, 1);
				glTexCoord2f(0, 0); glVertex3f(-s,-s,-s);
				glTexCoord2f(0, 1); glVertex3f(-s,-s,s);
				glTexCoord2f(1, 1); glVertex3f(-s,s,s);
				glTexCoord2f(1, 0); glVertex3f(-s,s,-s);
	
				//TopFace
				glColor3f(1, 1, 0);
				glTexCoord2f(0, 0); glVertex3f(s,-s,-s);
				glTexCoord2f(0, 1); glVertex3f(s,-s,s);
				glTexCoord2f(1, 1); glVertex3f(s,s,s);
				glTexCoord2f(1, 0); glVertex3f(s,s,-s);
	
				//LeftFace
				glColor3f(1, 0, 1);
				glTexCoord2f(0, 0); glVertex3f(-s,-s,-s);
				glTexCoord2f(0, 1); glVertex3f(s,-s,-s);
				glTexCoord2f(1, 1); glVertex3f(s,-s,s);
				glTexCoord2f(1, 0); glVertex3f(-s,-s,s);
	
				//Right Face
				glColor3f(0, 1, 1);
				glTexCoord2f(0, 0); glVertex3f(-s,s,-s);
				glTexCoord2f(0, 1); glVertex3f(s,s,-s);
				glTexCoord2f(1, 1); glVertex3f(s,s,s);
				glTexCoord2f(1, 0); glVertex3f(-s,s,s);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public static void cube(float x, float y, float z, float rx, float ry, float rz, float s) {
		s /= 2;
		
		glPushMatrix();
			{				
			glTranslatef(x, y, z);
			
			glRotatef(rx, 1, 0, 0);
			glRotatef(ry, 0, 1, 0);
			glRotatef(rz, 0, 0, 1);
			
			glBegin(GL_QUADS);
			{
				//FrontFace
				glColor3f(1, 0, 0);
				glVertex3f(-s,-s,s);
				glVertex3f(-s,s,s);
				glVertex3f(s,s,s);
				glVertex3f(s,-s,s);
	
				//BackFace
				glColor3f(0, 1, 0);
				glVertex3f(-s,-s,-s);
				glVertex3f(-s,s,-s);
				glVertex3f(s,s,-s);
				glVertex3f(s,-s,-s);
	
				//BottomFace
				glColor3f(0, 0, 1);
				glVertex3f(-s,-s,-s);
				glVertex3f(-s,-s,s);
				glVertex3f(-s,s,s);
				glVertex3f(-s,s,-s);
	
				//TopFace
				glColor3f(1, 1, 0);
				glVertex3f(s,-s,-s);
				glVertex3f(s,-s,s);
				glVertex3f(s,s,s);
				glVertex3f(s,s,-s);
	
				//LeftFace
				glColor3f(1, 0, 1);
				glVertex3f(-s,-s,-s);
				glVertex3f(s,-s,-s);
				glVertex3f(s,-s,s);
				glVertex3f(-s,-s,s);
	
				//Right Face
				glColor3f(0, 1, 1);
				glVertex3f(-s,s,-s);
				glVertex3f(s,s,-s);
				glVertex3f(s,s,s);
				glVertex3f(-s,s,s);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public static void sphere(float x, float y, float z, float rx, float ry, float rz, float radius, int slices, int stacks) {
		glPushMatrix();
		{			
			glTranslatef(x, y, z);
			
			glRotatef(rx, 1, 0, 0);
			glRotatef(ry, 0, 1, 0);
			glRotatef(rz, 0, 0, 1);
					
			glColor3f(1, 0, 1);
			
			Sphere s = new Sphere();
			s.setDrawStyle(GLU_LINE);
			s.draw(radius, slices, stacks);
		}
		glPopMatrix();
	}
	
	public static void plane(float x, float y, float z, float s, Texture t) {
		s /= 2;
		
		glPushMatrix();
		{
			t.bind();
			
			glTranslatef(x, y, z);
			
			glBegin(GL_QUADS);
			{			
				glColor3f(1, 1, 1);
				
				glTexCoord2f(0, 0); glVertex3f(-s,0,-s);
				glTexCoord2f(0, 1); glVertex3f(s,0,-s);
				glTexCoord2f(1, 1); glVertex3f(s, 0,s); 
				glTexCoord2f(1, 0); glVertex3f(-s, 0,s);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public static void plane(float x, float y, float z, float s) {
		s /= 2;
		
		glPushMatrix();
		{			
			glTranslatef(x, y, z);
			
			glBegin(GL_QUADS);
			{			
				glColor3f(1, 1, 1);
				
				glVertex3f(-s,0,-s);
				glVertex3f(s,0,-s);
				glVertex3f(s, 0,s); 
				glVertex3f(-s, 0,s);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
}
