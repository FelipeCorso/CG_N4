package br.furb.bcc.cg.entidade;

import java.util.ArrayList;
import java.util.List;

public class Pendulo {

	private Suporte suporte;
	private List<Esfera> esferas = new ArrayList<Esfera>();

	public void desenha() {

		suporte.desenha();

		for (Esfera esfera : esferas) {
			esfera.desenha();
		}
	}

}
