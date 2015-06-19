package br.furb.bcc.cg;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.media.opengl.DebugGL;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import br.furb.bcc.cg.entidade.Pendulo;
import br.furb.bcc.cg.perifericos.Perifericos;

import com.sun.opengl.util.GLUT;

public class Mundo extends Perifericos implements GLEventListener {

	private float ortho2D_minX = -400.0f, ortho2D_maxX = 400.0f, ortho2D_minY = -400.0f, ortho2D_maxY = 400.0f;
	private GL gl;
	private GLU glu;
	private GLUT glut;
	private GLAutoDrawable glDrawable;
	private Pendulo pendulo;

	private int antigoX;
	private int antigoY;

	@Override
	public void init(GLAutoDrawable drawable) {
		glDrawable = drawable;
		gl = drawable.getGL();
		glu = new GLU();
		glut = new GLUT();
		glDrawable.setGL(new DebugGL(gl));

		gl.glClearColor(1f, 1f, 1f, 1.0f);
		xEye = 20.0f;
		yEye = 20.0f;
		zEye = 20.0f;
		xCenter = 0.0f;
		yCenter = 0.0f;
		zCenter = 0.0f;

		ligarLuz();

		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL.GL_CULL_FACE);

		pendulo = new Pendulo(gl, glut);

	}

	private void ligarLuz() {
		float posLight[] = { 5.0f, 5.0f, 10.0f, 0.0f };
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLight, 0);
		gl.glEnable(GL.GL_LIGHT0);
	}

	private double xEye, yEye, zEye;
	private double xCenter, yCenter, zCenter;

	@Override
	public void display(GLAutoDrawable arg0) {

		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		// glu.gluOrtho2D(0, 800, 800, 0);
		glu.gluLookAt(xEye, yEye, zEye, xCenter, yCenter, zCenter, 0.0f, 1.0f, 0.0f);

		// drawAxis();

		desenharPendulo();

		gl.glFlush();
	}

	public void drawAxis() {
		// eixo X - Red
		gl.glColor3f(1.0f, 0.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex3f(0.0f, 0.0f, 0.0f);
		gl.glVertex3f(10.0f, 0.0f, 0.0f);
		gl.glEnd();
		// eixo Y - Green
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex3f(0.0f, 0.0f, 0.0f);
		gl.glVertex3f(0.0f, 10.0f, 0.0f);
		gl.glEnd();
		// eixo Z - Blue
		gl.glColor3f(0.0f, 0.0f, 1.0f);
		gl.glBegin(GL.GL_LINES);
		gl.glVertex3f(0.0f, 0.0f, 0.0f);
		gl.glVertex3f(0.0f, 0.0f, 10.0f);
		gl.glEnd();
	}

	private void desenharPendulo() {
		pendulo.desenha();
	}

	@Override
	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int width, int height) {
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glViewport(0, 0, width, height);

		// glu.gluOrtho2D(-30.0f, 30.0f, -30.0f, 30.0f);
		glu.gluPerspective(60, width / height, 0.1, 100); // projecao Perpectiva 1 pto fuga 3D
		// gl.glFrustum (-5.0, 5.0, -5.0, 5.0, 10, 100); // projecao Perpectiva 1 pto fuga 3D
		// gl.glOrtho(-30.0f, 30.0f, -30.0f, 30.0f, -30.0f, 30.0f); // projecao Ortogonal 3D

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if ((arg0.getKeyCode() == KeyEvent.VK_R) && ((arg0.getModifiers() & KeyEvent.CTRL_MASK) != 0)) {
			glDrawable.display();
		}
		switch (arg0.getKeyCode()) {

		case KeyEvent.VK_ESCAPE:
			System.exit(1);
			break;
		case KeyEvent.VK_1:
			xEye = 20.0f;
			yEye = 20.0f;
			zEye = 20.0f;
			break;
		case KeyEvent.VK_2:
			xEye = 0.0f;
			yEye = 0.0f;
			zEye = 20.0f;
			break;
		case KeyEvent.VK_3:
			xEye = 0.0f;
			yEye = 0.0f;
			zEye = -20.0f;
			break;
		case KeyEvent.VK_4:
			xEye = 1.0f;
			yEye = 0.0f;
			zEye = 0.0f;
			break;

		case KeyEvent.VK_M:
			// eHMaterial = !eHMaterial;
			ligarLuz();
			break;
		}

		glDrawable.display();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int movtoX = e.getX() - antigoX;
		int movtoY = e.getY() - antigoY;

		// centroCirculoInterno.setX(centroCirculoInterno.getX() + movtoX);
		// centroCirculoInterno.setY(centroCirculoInterno.getY() - movtoY);

		antigoX = e.getX();
		antigoY = e.getY();

		glDrawable.display(); // redesenhar ...
	}

	@Override
	public void mousePressed(MouseEvent e) {
		antigoX = e.getX();
		antigoY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	};

}
