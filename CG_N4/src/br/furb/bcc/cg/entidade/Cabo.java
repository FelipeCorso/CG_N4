package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

public class Cabo extends ObjetoGrafico {

	private GL gl;

	public Cabo(GL gl) {
		this.gl = gl;
	}

	public void desenha(float x, float yO, float yD, float zO, float zD) {
		gl.glColor3f(0f, 1f, 0f);
		gl.glLineWidth(2f);
		gl.glBegin(GL.GL_LINES);
		{
			gl.glVertex3f(x, yO, zO);
			gl.glVertex3f(x, yD, zD);
		}
		gl.glEnd();
	}
}
