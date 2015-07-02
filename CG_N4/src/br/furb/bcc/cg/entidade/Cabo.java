package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

public class Cabo extends ObjetoGrafico {

	private GL gl;

	/**
	 * Liga os dois cabos
	 */

	private float xSuperior;
	private float xInferior;

	private float ySuperior;
	private float yInferior;

	private float zSuperior;
	private float zInferior;

	private float x;
	private float y;
	private float z;
	private float yOrigem;
	private float yDestino;
	private float zOrigem;
	private float zDestino;

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

	/**
	 * Recebe a coordenada x(+|-) y(+) e z(+) da origem do ponto o cabo.
	 */
	public void coordenadasCabo(float f, float g, float h) {
		setX(f);
		setY(g);
		setZ(h);
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

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getyOrigem() {
		return yOrigem;
	}

	public void setyOrigem(float yOrigem) {
		this.yOrigem = yOrigem;
	}

	public float getyDestino() {
		return yDestino;
	}

	public void setyDestino(float yDestino) {
		this.yDestino = yDestino;
	}

	public float getzOrigem() {
		return zOrigem;
	}

	public void setzOrigem(float zOrigem) {
		this.zOrigem = zOrigem;
	}

	public float getzDestino() {
		return zDestino;
	}

	public void setzDestino(float zDestino) {
		this.zDestino = zDestino;
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
