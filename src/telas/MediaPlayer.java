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
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSlider;

/**
 * Implementacao da tela onde as musicas
 * seram reproduzidas
 * @see     MediaPlayer
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   06.06.2018
 * @version 0.0.3
 */
public class MediaPlayer {

	JFrame frmPlayer;
	Player tocar;
	JButton play, pause;
	Musica m;
	int contador;
	boolean startMusica = true;
	
	JButton addDiretorio;
	JButton addArquivo;
	JButton novaPlaylist;
	
	/** 
	 * Construtor padrão 
	 * */
	public MediaPlayer() {
		initialize();
		botaoPlayPause();
		barraProgresso();
	}

	/**
     * Inicializa a tela da classe MediaPlayer
     */
	private void initialize() {
		frmPlayer = new JFrame();
		frmPlayer.setTitle("Reprodutor");
		frmPlayer.setBounds(100, 100, 900, 650);
		frmPlayer.setLocationRelativeTo(null);
		frmPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayer.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmPlayer.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Arquivo");
		menuBar.add(mnFile);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		menuBar.add(separator);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		menuBar.add(mnNewMenu);
				
	}
	
	/**
     * Adiciona um botão com a função de play/pause na tela
     */
	private void botaoPlayPause() {
		
		String caminho = "/home/lael/music";
		File arquivoMp3 = new File(caminho);
		
		contador = 0;
		play = new JButton("");
		play.setBackground(new Color(255, 255, 255));
		
		String caminhoImagem = "./imagensParaGui/play_pause.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			play.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		
		play.setBounds(61, 446, 43, 43);
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
		frmPlayer.getContentPane().add(play);
		play.setBorderPainted(false);
		play.setOpaque(false);
		play.setFocusPainted( false );
	}
	
	
	private void barraProgresso() {
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(161, 522, 555, 20);
		frmPlayer.getContentPane().add(progressBar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 571, 884, 8);
		frmPlayer.getContentPane().add(separator);
	}
	
	/**
     * @return A tela do reprodutor de musica
     */
	public JFrame getFrame() {
		return frmPlayer;
	}
}
