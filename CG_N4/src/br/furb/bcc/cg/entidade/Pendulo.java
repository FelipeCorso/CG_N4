package br.furb.bcc.cg.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;

public class Pendulo {

	private Suporte suporte;
	private List<Esfera> esferas = new ArrayList<Esfera>();
	private GL gl;

	public Pendulo(GL gl) {
		this.gl = gl;
		suporte = new Suporte(gl);
		int qtdEsferas = 5;
		criarEsferas(qtdEsferas);
	}

	private void criarEsferas(int qtdEsferas) {
		for (int i = 0; i < qtdEsferas; i++) {
			esferas.add(new Esfera(gl));
		}
	}

	public void desenha() {

		suporte.desenha();

		for (Esfera esfera : esferas) {
			esfera.desenha();
		}
	}

}
