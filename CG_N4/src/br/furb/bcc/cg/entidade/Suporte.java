package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

public class Suporte {

	private GL gl;

	public Suporte(GL gl) {
		this.gl = gl;
	}

	public void desenha() {
		gl.glColor3f(0.0f, 1.0f, 0.0f);
		gl.glBegin(GL.GL_LINE_LOOP);
		gl.glVertex2d(-100, 100);
		gl.glVertex2d(100, 100);
		gl.glVertex2d(0, -100);
		gl.glEnd();
	}

}
