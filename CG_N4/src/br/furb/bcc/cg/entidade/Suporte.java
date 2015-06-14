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

	private float corGreen[] = { 0.0f, 1.0f, 0.0f, 1.0f };

	public void desenha(float sX, float sY, float sZ, float tX, float tY, float tZ) {
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, corGreen, 0);
		gl.glEnable(GL.GL_LIGHTING);// TODO: aqui?

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
