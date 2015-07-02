package br.furb.bcc.cg.acao;

import javax.media.opengl.GLAutoDrawable;

import br.furb.bcc.cg.entidade.Esfera;
import br.furb.bcc.cg.entidade.Pendulo;

public class MovimentaEsfera implements Runnable {

	private static final int TEMPO_TRANSICAO = 300;
	private GLAutoDrawable glDrawable;
	private boolean pause;
	private int tipoMovimento = 0;
	private Esfera esfera1;
	private Esfera esfera2;
	private Esfera esfera3;
	private Esfera esfera4;
	private Esfera esfera5;

	public MovimentaEsfera(GLAutoDrawable glDrawable, Pendulo pendulo) {
		this.glDrawable = glDrawable;

		esfera1 = pendulo.getEsferas().get(0);
		esfera2 = pendulo.getEsferas().get(1);
		esfera3 = pendulo.getEsferas().get(2);
		esfera4 = pendulo.getEsferas().get(3);
		esfera5 = pendulo.getEsferas().get(4);
	}

	@Override
	public void run() {

		switch (getTipoMovimento()) {
		case 1:
			movimentarEsferas1e5();
			break;
		case 2:
			movimentarEsferas12e45();
			break;
		case 3:
			movimentarTodas();
			break;

		default:
			break;
		}
	}

	private void movimentarEsferas1e5() {

		while (!isPause()) {
			movimentarRetornarEsfera(esfera1, -6f);
			movimentarRetornarEsfera(esfera5, 6f);
		}
	}

	private void movimentarEsferas12e45() {
		while (!isPause()) {

			movimentarEsfera(esfera1, -6f);
			movimentarEsfera(esfera2, -4f);

			retornarEsfera(esfera2);
			retornarEsfera(esfera1);

			movimentarEsfera(esfera5, 6f);
			movimentarEsfera(esfera4, 4f);

			retornarEsfera(esfera4);
			retornarEsfera(esfera5);
		}
	}

	private void movimentarTodas() {
		while (!isPause()) {

			movimentarEsfera(esfera1, -6f);
			movimentarEsfera(esfera2, -4f);
			movimentarEsfera(esfera3, -2f);

			retornarEsfera(esfera3);
			retornarEsfera(esfera2);
			retornarEsfera(esfera1);

			movimentarEsfera(esfera5, 6f);
			movimentarEsfera(esfera4, 4f);
			movimentarEsfera(esfera3, 2f);

			retornarEsfera(esfera3);
			retornarEsfera(esfera4);
			retornarEsfera(esfera5);
		}

	}

	private void movimentarRetornarEsfera(Esfera esfera, float vlrMovimento) {
		movimentarEsfera(esfera, vlrMovimento);
		retornarEsfera(esfera);
	}

	private void movimentarEsfera(Esfera esfera, float vlrMovimento) {
		try {
			esfera.settX(vlrMovimento);
			esfera.atualizarXInferior(vlrMovimento);
			glDrawable.display();
			Thread.sleep(TEMPO_TRANSICAO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna a posição original
	 * 
	 * @param esfera
	 * @throws InterruptedException
	 */
	private void retornarEsfera(Esfera esfera) {
		try {
			esfera.settX(esfera.getDefaultValueX());
			esfera.atualizarXInferior(esfera.getDefaultValueX());
			glDrawable.display();
			Thread.sleep(TEMPO_TRANSICAO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public int getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

}
