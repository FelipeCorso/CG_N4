package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

public class Esfera {

	private Cabo cabo1;
	private Cabo cabo2;
	private GL gl;

	public Esfera(GL gl) {
		this.gl = gl;
		cabo1 = new Cabo(gl);
		cabo2 = new Cabo(gl);
	}

	public void desenha() {

		// cabo.desenha(x, y, z);
	}

}
