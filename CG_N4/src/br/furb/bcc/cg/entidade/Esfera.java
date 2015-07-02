package br.furb.bcc.cg.entidade;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public class Esfera {

	public static final float DEFAULT_VALUE = 0;

	private static final float DEFAULT_VALUE_Y_SUPERIOR = 5;
	private static final float DEFAULT_VALUE_Y_INFERIOR = 1;

	private static final float DEFAULT_VALUE_Z_SUPERIOR_POSITIVO = 3;
	private static final float DEFAULT_VALUE_Z_SUPERIOR_NEGATIVO = -3;

	private static final float DEFAULT_VALUE_Z_INFERIOR = 0;

	private float defaultValueX;

	private float x;
	private float y;
	private float z;
	private float tX;
	private float tY;
	private float tZ;

	/**
	 * Cabo1 = o cabo que fica escondido (z negativo)
	 */
	private Cabo cabo1 = null;
	/**
	 * Cabo2 = o cabo que fica visível (z positivo)
	 */
	private Cabo cabo2 = null;
	private GL gl;
	private Esfera direita = null;
	private Esfera esquerda = null;
	private GLUT glut;

	public Esfera(GL gl, GLUT glut) {
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
			gl.glTranslated(tX, tY, 0);// Deixa esfera no centro, utiliza tz para os cabos
			gl.glScalef(sX, sY, sZ);
			glut.glutSolidSphere(1f, 25, 25);
		}
		gl.glPopMatrix();

		cabo1.desenha();
		cabo2.desenha();
		// TODO 5f = altura do suporte
		// cabo1.desenha(tX, 5f, tY, tZ, 0);
		// cabo2.desenha(tX, 5f, tY, tZ * -1f, 0);
	}

	public void desenha() {
		desenha(getX(), getY(), getZ(), gettX(), gettY(), gettZ());
	}

	/**
	 * Atualiza o valor de x inferior dos dois cabos.
	 * 
	 * @param xInferior
	 *            nova coordenada para o xInferior
	 */
	public void atualizarXInferior(float xInferior) {
		getCabo1().setXInferior(xInferior);
		getCabo2().setXInferior(xInferior);
	}

	/**
	 * Cabo1 = o cabo que fica escondido (z negativo)
	 */
	public void setDefaultValueCabo1(float x) {
		getCabo1().setXSuperior(x);
		getCabo1().setXInferior(x);

		getCabo1().setySuperior(Esfera.DEFAULT_VALUE_Y_SUPERIOR);
		getCabo1().setyInferior(Esfera.DEFAULT_VALUE_Y_INFERIOR);

		getCabo1().setzSuperior(Esfera.DEFAULT_VALUE_Z_SUPERIOR_NEGATIVO);
		getCabo1().setzInferior(Esfera.DEFAULT_VALUE_Z_INFERIOR);
	}

	/**
	 * Cabo2 = o cabo que fica visível (z positivo)
	 */
	public void setDefaultValueCabo2(float x) {
		getCabo2().setXSuperior(x);
		getCabo2().setXInferior(x);

		getCabo2().setySuperior(Esfera.DEFAULT_VALUE_Y_SUPERIOR);
		getCabo2().setyInferior(Esfera.DEFAULT_VALUE_Y_INFERIOR);

		getCabo2().setzSuperior(Esfera.DEFAULT_VALUE_Z_SUPERIOR_POSITIVO);
		getCabo2().setzInferior(Esfera.DEFAULT_VALUE_Z_INFERIOR);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
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

	public float gettX() {
		return tX;
	}

	public void settX(float tX) {
		this.tX = tX;
	}

	public float gettY() {
		return tY;
	}

	public void settY(float tY) {
		this.tY = tY;
	}

	public float gettZ() {
		return tZ;
	}

	public void settZ(float tZ) {
		this.tZ = tZ;
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

	public Cabo getCabo1() {
		return cabo1;
	}

	public void setCabo1(Cabo cabo1) {
		this.cabo1 = cabo1;
	}

	public Cabo getCabo2() {
		return cabo2;
	}

	public void setCabo2(Cabo cabo2) {
		this.cabo2 = cabo2;
	}

	public float getDefaultValueX() {
		return defaultValueX;
	}

	public void setDefaultValueX(float defaultValueX) {
		this.defaultValueX = defaultValueX;
	}

}
