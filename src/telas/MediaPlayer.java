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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JScrollBar;

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
	 */
	public MediaPlayer() {
		initialize();
		botaoPlayPause();
		barraProgresso();
		separador();
		rotuloBotaoAddDiretorio();
		botaoAddDiretorio();
		rotuloBotaoAddArquivo();
		botaoAddArquivo();
		textAreaListaDeMusicas();
	}

	/**
     * Inicializa a tela da classe MediaPlayer
     */
	private void initialize() {
		frmPlayer = new JFrame();
		frmPlayer.getContentPane().setBackground(new Color(255, 140, 0));
		frmPlayer.setTitle("Reprodutor");
		frmPlayer.setBounds(100, 100, 900, 650);
		frmPlayer.setLocationRelativeTo(null);
		frmPlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlayer.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frmPlayer.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("Arquivo");
		mnFile.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		menuBar.add(mnFile);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		
		mntmSair.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
			
		mnFile.add(mntmSair);
		
		JMenu mnEditar = new JMenu("Editar");
		mnEditar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		menuBar.add(mnEditar);
		
		JMenu mnVer = new JMenu("Ver");
		mnVer.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
		menuBar.add(mnVer);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		menuBar.add(separator);
		
		JMenu mnNewMenu = new JMenu("Ajuda");
		mnNewMenu.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
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
		
		play.setBounds(58, 469, 43, 43);
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
	
	/**
     * Adiciona um separador na tela
     */
	private void separador() {
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 571, 884, 8);
		frmPlayer.getContentPane().add(separator);

	}

	/**
     * Adiciona um rótulo na tela para o botão addDiretório
     */
	private void rotuloBotaoAddDiretorio() {

		JLabel lblAddDiretrio = new JLabel("Add Diret\u00F3rio");
		lblAddDiretrio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddDiretrio.setBounds(36, 130, 113, 26);
		frmPlayer.getContentPane().add(lblAddDiretrio);

	}
	
	/**
     * Adiciona um botão na tela com a função de adicionar diretório
     */
	private void botaoAddDiretorio() {

		addDiretorio = new JButton("");
		addDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addDiretorio.setBackground(new Color(255, 255, 255));
		
		String caminhoImagem = "./imagensParaGui/mais.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			addDiretorio.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		
		addDiretorio.setBounds(26, 183, 113, 107);
		addDiretorio.setVisible(true);
		addDiretorio.setBorderPainted(false);
		addDiretorio.setOpaque(false);
		addDiretorio.setFocusPainted( false );

		frmPlayer.getContentPane().add(addDiretorio);

	}
	
	/**
     * Adiciona um rótulo na tela para o botão addArquivo
     */
	private void rotuloBotaoAddArquivo(){
	
		JLabel lblAddArquivo = new JLabel("Add Arquivo");
		lblAddArquivo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddArquivo.setBounds(47, 291, 92, 20);
		frmPlayer.getContentPane().add(lblAddArquivo);
		
	}
	
	/**
     * Adiciona um botão na tela com a função de adicionar um arquivo
     */
	private void botaoAddArquivo() {

		addArquivo = new JButton("");
		addArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addArquivo.setBackground(new Color(255, 255, 255));
		
		
		String caminhoImagem2 = "./imagensParaGui/mais.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem2);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			addArquivo.setIcon(new ImageIcon(caminhoImagem2));  
		
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		
		addArquivo.setBounds(26, 23, 113, 107);
		addArquivo.setVisible(true);
		addArquivo.setBorderPainted(false);
		addArquivo.setOpaque(false);
		addArquivo.setFocusPainted( false );

		frmPlayer.getContentPane().add(addArquivo);

	}
	
	/**
     * Adiciona na tela uma barra de progresso
     */
	private void barraProgresso() {
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBackground(Color.WHITE);
		progressBar.setForeground(new Color(0, 0, 0));
		progressBar.setBounds(161, 522, 555, 20);
		frmPlayer.getContentPane().add(progressBar);
		
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setBounds(448, 53, 225, 436);
		frmPlayer.getContentPane().add(textArea_1);
		
		JLabel lblMsicas = new JLabel("M\u00FAsicas");
		lblMsicas.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMsicas.setBounds(294, 28, 58, 14);
		frmPlayer.getContentPane().add(lblMsicas);
	
	}
	
	private void textAreaListaDeMusicas() {
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setBounds(206, 53, 225, 436);
		frmPlayer.getContentPane().add(textArea);
		
	}
	
	/**
     * @return A tela do reprodutor de musica
     */
	public JFrame getFrame() {
		return frmPlayer;
	}
}
