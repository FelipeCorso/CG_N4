package br.furb.bcc.cg.entidade;

import java.util.LinkedList;
import java.util.List;

import javax.media.opengl.GL;

import com.sun.opengl.util.GLUT;

public class Pendulo {

	private Suporte superior1;
	private Suporte superior2;
	private Suporte lateral1;
	private Suporte lateral2;
	private Suporte lateral3;
	private Suporte lateral4;
	private Suporte inferior;
	private List<Esfera> esferas = new LinkedList<Esfera>();
	private GL gl;
	private GLUT glut;

	// constantes
	public static float RAIO = 0.5f;
	private int qtdEsferas;

	public Pendulo(GL gl, GLUT glut) {
		this.gl = gl;
		this.glut = glut;
		superior1 = new Suporte(gl, glut);
		superior2 = new Suporte(gl, glut);
		lateral1 = new Suporte(gl, glut);
		lateral2 = new Suporte(gl, glut);
		lateral3 = new Suporte(gl, glut);
		lateral4 = new Suporte(gl, glut);
		inferior = new Suporte(gl, glut);

		qtdEsferas = 5;
		criarEsferas(qtdEsferas);
	}

	private void criarEsferas(int qtdEsferas) {

		for (int i = qtdEsferas / 2 * -1; i <= qtdEsferas / 2; i++) {
			Esfera esfera = new Esfera(gl, glut);

			float x = (RAIO * i) * 4f;
			float raio_x_2 = RAIO * 2;

			esfera.setX(raio_x_2);
			esfera.setY(raio_x_2);
			esfera.setZ(raio_x_2);
			esfera.settX(x);
			esfera.settY(0);
			esfera.settZ(deltaSuporte);

			esfera.setDefaultValueX(x);

			esfera.setDefaultValueCabo1(x);
			esfera.setDefaultValueCabo2(x);
			esferas.add(esfera);
		}
	}

	private static final float deltaSuporte = 3f;
	private static final float deltaSuporteInvertido = deltaSuporte * -1;

	private static final float ySuporteSup = 1f;
	private static final float zSuporteSup = 1f;

	private static final float alturaSuporte = 10f;
	private static final float xSuportelat = 1f;
	private static final float zSuporteLat = 1f;

	private float corGray[] = { 0.7f, 0.7f, 0.7f, 0f };
	private float corBlack[] = { 0.0f, 0.0f, 0.0f, 0.0f };

	public void desenha() {
		float compSuporteSup = Pendulo.RAIO * 4 * (qtdEsferas + 2);

		superior1.desenha(compSuporteSup, ySuporteSup, zSuporteSup, 0, alturaSuporte / 2, deltaSuporte, corGray);
		superior2.desenha(compSuporteSup, ySuporteSup, zSuporteSup, 0, alturaSuporte / 2, deltaSuporteInvertido, corGray);
		lateral1.desenha(xSuportelat, alturaSuporte, zSuporteLat, (compSuporteSup / -2) + 0.5f, 0f, deltaSuporte, corGray);
		lateral2.desenha(xSuportelat, alturaSuporte, zSuporteLat, (compSuporteSup / -2) + 0.5f, 0f, deltaSuporteInvertido, corGray);
		lateral3.desenha(xSuportelat, alturaSuporte, zSuporteLat, (compSuporteSup / 2) - 0.5f, 0f, deltaSuporte, corGray);
		lateral4.desenha(xSuportelat, alturaSuporte, zSuporteLat, (compSuporteSup / 2) - 0.5f, 0f, deltaSuporteInvertido, corGray);
		inferior.desenha(compSuporteSup, 1.0f, (float) (deltaSuporte * 2) + 1f, 0, (alturaSuporte / -2) + 0.5f, 0f, corBlack);
		int c = 0;
		for (int i = qtdEsferas / 2 * -1; i <= qtdEsferas / 2; i++) {

			esferas.get(c).desenha();
			// esfera.desenha(RAIO * 2, RAIO * 2, RAIO * 2, (RAIO * i) * 4f, 0, deltaSuporte);
			c++;
		}
	}

	public List<Esfera> getEsferas() {
		return esferas;
	}
}
