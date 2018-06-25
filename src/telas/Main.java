package telas;

import java.awt.EventQueue;

/**
 * Implementação da classe Main
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   18.06.2018
 * @version 0.0.3
 */
public class Main {
	
	/** 
	 * Metodo principal para executar a aplicacao(realiza
	 * uma chamada a tela de login)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
