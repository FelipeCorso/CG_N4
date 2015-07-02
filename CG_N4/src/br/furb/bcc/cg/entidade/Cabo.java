package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

public class Cabo {

	private GL gl;

	private float xSuperior;
	private float xInferior;

	private float ySuperior;
	private float yInferior;

	private float zSuperior;
	private float zInferior;

	public Cabo(GL gl) {
		this.gl = gl;
	}

	public void desenha() {
		gl.glColor3f(0f, 1f, 0f);
		gl.glLineWidth(2f);
		gl.glBegin(GL.GL_LINES);
		{
			gl.glVertex3f(getXSuperior(), getySuperior(), getzSuperior());// Cria o ponto negativo
			gl.glVertex3f(getXInferior(), getyInferior(), getzInferior());// Cria o ponto positivo
		}
		gl.glEnd();
	}

	public float getXSuperior() {
		return xSuperior;
	}

	public float getySuperior() {
		return ySuperior;
	}

	public void setySuperior(float ySuperior) {
		this.ySuperior = ySuperior;
	}

	public float getyInferior() {
		return yInferior;
	}

	public void setyInferior(float yInferior) {
		this.yInferior = yInferior;
	}

	public float getzSuperior() {
		return zSuperior;
	}

	public void setzSuperior(float zSuperior) {
		this.zSuperior = zSuperior;
	}

	public float getzInferior() {
		return zInferior;
	}

	public void setzInferior(float zInferior) {
		this.zInferior = zInferior;
	}

	public void setXSuperior(float xSuperior) {
		this.xSuperior = xSuperior;
	}

	public float getXInferior() {
		return xInferior;
	}

	public void setXInferior(float xInferior) {
		this.xInferior = xInferior;
	}
}
