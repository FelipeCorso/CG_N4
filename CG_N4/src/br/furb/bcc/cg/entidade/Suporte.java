package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public class Suporte extends ObjetoGrafico {

	private GL gl;
	private GLUT glut;

	public Suporte(GL gl, GLUT glut) {
		this.gl = gl;
		this.glut = glut;
	}

	public void desenha(float sX, float sY, float sZ, float tX, float tY, float tZ, float[] color) {
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, color, 0);
		gl.glEnable(GL.GL_LIGHTING);

		gl.glPushMatrix();
		{
			gl.glScalef(sX, sY, sZ);
			gl.glTranslated(tX, tY, tZ);
			glut.glutSolidCube(1f);
		}
		gl.glPopMatrix();
	}

	public void desenha() {

	}

}
