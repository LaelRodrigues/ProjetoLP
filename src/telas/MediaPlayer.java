package telas;

import javax.swing.JFrame;

import classes.Musica;
import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

import arvoreBinariaDeBusca.No;

/**
 * Implementacao da tela onde as musicas
 * seram reproduzidas
 * @see     MediaPlayer
 * @author	Robson Lael
 * @since   06.06.2018
 * @version 0.0.1
 */

public class MediaPlayer {

	JFrame frame;
	Player tocar;
	JButton play, pause;
	Musica m;
	int contador;
	boolean startMusica = true;
	
	
	/** Construtor padrao */
	public MediaPlayer() {
		initialize();
		botaoPlayPause();
		barraProgresso();
	}

	/**
     * Inicializar a tela da classe MediaPlayer
     */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
	}
	
	/**
     * Adicionar um botao com a funcao de play/pause 
     * na tela
     */
	private void botaoPlayPause() {
		
		String caminho = "/home/lael/music";
		File arquivoMp3 = new File(caminho);
		
		contador = 0;
		play = new JButton("");
		
		String caminhoImagem = "./imagensParaGui/play_pause.png";
		File arquivoImagem = new File(caminhoImagem);
		if(arquivoImagem.exists()) {
			play.setIcon(new ImageIcon(caminhoImagem));  
		}
		else {
			System.out.println("Erro ao abrir o arquivo Imagem!!!");
		}
		
		play.setBounds(76, 189, 43, 43);
		play.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(startMusica) {
					Musica musica = new Musica();
					musica.tocar(arquivoMp3);
			 		musica.start();
			 		startMusica = false;
			 		m = musica;
				}
				else {
					if(m.getPlayer().isComplete()) {
						m.getPlayer().close();
						startMusica = true;
					}
					else if(contador % 2 == 1) {
						m.resume();
						contador++;
					}
					else {
						m.suspend();
						contador++;
					}
				}
			}
			 
		});
		frame.getContentPane().add(play);
		play.setBorderPainted(false);
		play.setOpaque(false);
		play.setFocusPainted( false );
	}
	
	
	private void barraProgresso() {
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(222, 240, 148, 25);
		frame.getContentPane().add(progressBar);
	}
	/**
     * retorna a tela do reprodutor de musica
     */
	public JFrame getFrame() {
		return frame;
	}
}
