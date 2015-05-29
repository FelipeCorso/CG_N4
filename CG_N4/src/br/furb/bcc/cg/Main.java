package br.furb.bcc.cg;

import java.awt.BorderLayout;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main extends JFrame {

	private static final long serialVersionUID = 1851620023081166356L;

	private int janelaLargura = 400, janelaAltura = 400;

	public Main() {
		super("CG-N4");
		setBounds(300, 250, janelaLargura, janelaAltura + 22); // 500 + 22 da borda do t’tulo da janela
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		Mundo mundo = new Mundo();
		/*
		 * Cria um objeto GLCapabilities para especificar o numero de bits por pixel para RGBA
		 */
		GLCapabilities glCaps = new GLCapabilities();
		glCaps.setRedBits(8);
		glCaps.setBlueBits(8);
		glCaps.setGreenBits(8);
		glCaps.setAlphaBits(8);

		/*
		 * Cria um canvas, adiciona ao frame e objeto "ouvinte" para os eventos Gl, de mouse e teclado
		 */
		GLCanvas canvas = new GLCanvas(glCaps);
		add(canvas, BorderLayout.CENTER);
		canvas.addGLEventListener(mundo);
		canvas.addKeyListener(mundo);
		canvas.requestFocus();

	}

	public static void main(String[] args) {
		new Main().setVisible(true);
	}

}
