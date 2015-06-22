package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public class Esfera extends ObjetoGrafico {

	private Cabo cabo1 = null;
	private Cabo cabo2 = null;
	private GL gl;
	private Esfera direita = null;
	private Esfera esquerda = null;
	private GLUT glut;

	public Esfera(GL gl, GLUT glut, int i) {
		this.gl = gl;
		this.glut = glut;
		cabo1 = new Cabo(gl);
		cabo2 = new Cabo(gl);
	}

	private float corRed[] = { 1.0f, 0.0f, 0.0f, 1.0f };

	public void desenha(float sX, float sY, float sZ, float tX, float tY, float tZ) {
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT_AND_DIFFUSE, corRed, 0);
		gl.glEnable(GL.GL_LIGHTING);

		gl.glPushMatrix();
		{
			gl.glScalef(sX, sY, sZ);
			gl.glTranslated(tX, tY, 0);// Deixa esfera no centro, utiliza tz para os cabos
			glut.glutSolidSphere(1f, 25, 25);
		}
		gl.glPopMatrix();

		// TODO 5f = altura do suporte
		cabo1.desenha(tX, 5f, tY, tZ, 0);
		cabo2.desenha(tX, 5f, tY, tZ * -1f, 0);
	}

	public void desenha() {

	}

	public Esfera getDireita() {
		return direita;
	}

	public void setDireita(Esfera direita) {
		this.direita = direita;
	}

	public Esfera getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(Esfera esquerda) {
		this.esquerda = esquerda;
	}

}
