package br.furb.bcc.cg.entidade;

import java.util.ArrayList;
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
	private List<Esfera> esferas = new ArrayList<Esfera>();
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
		for (int i = 1; i <= qtdEsferas; i++) {
			esferas.add(new Esfera(gl, glut, i));
		}
	}

	private static final float deltaSuporte = 3f;
	private static final float deltaSuporteInvertido = deltaSuporte * -1;

	private static final float ySuporteSup = 1f;
	private static final float zSuporteSup = 1f;

	private static final float alturaSuporte = 10f;
	private static final float xSuportelat = 1f;
	private static final float zSuporteLat = 1f;

	public void desenha() {
		float compSuporteSup = Pendulo.RAIO * 4 * (qtdEsferas + 2);

		superior1.desenha(compSuporteSup, ySuporteSup, zSuporteSup, 0, alturaSuporte / 2, deltaSuporte);
		superior2.desenha(compSuporteSup, ySuporteSup, zSuporteSup, 0, alturaSuporte / 2, deltaSuporteInvertido);
		lateral1.desenha(xSuportelat, alturaSuporte, zSuporteLat, compSuporteSup / -2, 0f, deltaSuporte);
		lateral2.desenha(xSuportelat, alturaSuporte, zSuporteLat, compSuporteSup / -2, 0f, deltaSuporteInvertido);
		lateral3.desenha(xSuportelat, alturaSuporte, zSuporteLat, compSuporteSup / 2, 0f, deltaSuporte);
		lateral4.desenha(xSuportelat, alturaSuporte, zSuporteLat, compSuporteSup / 2, 0f, deltaSuporteInvertido);
		inferior.desenha(compSuporteSup, 1f, (float) (deltaSuporte * 2), 0, alturaSuporte / -2, 0f);
		int c = 0;
		for (int i = qtdEsferas / 2 * -1; i <= qtdEsferas / 2; i++) {
			esferas.get(c).desenha(RAIO * 2, RAIO * 2, RAIO * 2, (RAIO * i) * 4f, -1, deltaSuporte);
			c++;
		}
	}
}
