package telas;

import javax.swing.JFrame;

import classes.Musica;
import classes.TocarMusica;
import classes.Usuario;
import javafx.scene.layout.Border;
import javazoom.jl.player.Player;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.awt.Image;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

import arvoreBinariaDeBusca.NoABB;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JToolBar;
import javax.swing.RepaintManager;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JScrollBar;

/**
 * Implementacão da tela onde as músicas seram reproduzidas
 * @see     MediaPlayer
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   06.06.2018
 * @version 0.0.3
 */
public class MediaPlayer{
	
	JFrame frmPlayer;
	Player tocar;
	TocarMusica m;
	int contador;
	boolean startMusica = true;
	String nomeMusicaLista, nomeTemporario;
	DefaultListModel<String> modeloLista;
	
	private Usuario usuarioLogadoAtual;
	
	JButton addDiretorio, addArquivo, novaPlaylist;
	JButton play, botaoAnterior, botaoProximo;
	JList<String> listaMusicas;
	
	ArrayList<Musica> musicas;
	/** 
	 * Construtor padrão 
	 */
	public MediaPlayer( Usuario usuarioLogadoAtual ) {
		
		this.usuarioLogadoAtual = usuarioLogadoAtual;
		initialize();
		botaoPlayPause();
		barraProgresso();
		separador();
		rotuloBotaoAddDiretorio();
		botaoAddDiretorio();
		rotuloBotaoAddArquivo();
		botaoAddArquivo();
		ListaDeMusicas();
		botaoAnteriorMusica();
		botaoProximaMusica();
		listaDePlaylists();
		botaoAddPlayLists();
		
	}

	/**
     * Inicializa a tela da classe MediaPlayer
     */
	private void initialize() {
		
		frmPlayer = new JFrame();
		frmPlayer.getContentPane().setBackground(new Color(0, 204, 255));
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
		
		JMenuItem mntmCadastrarUsuario = new JMenuItem("Cadastrar usuário");
		
		mntmCadastrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			  Cadastro cadastro = new Cadastro(usuarioLogadoAtual);
			  cadastro.getFrame().setVisible(true);
			  
			}
		});
		
		mnFile.add(mntmCadastrarUsuario);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		
		mntmSair.addActionListener(new ActionListener() {
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
     * Adiciona um bot�o com a fun��o de play/pause na tela
     */
	private void botaoPlayPause() {
		Musica m1 = new Musica("music","/home/lael/music");
		Musica m2 = new Musica("music2","/home/lael/music2");
		musicas = new ArrayList<>();
		musicas.add(m1);
		musicas.add(m2);
		
		nomeMusicaLista = musicas.get(0).getNome();
		
		contador = 0;
		play = new JButton("");
		play.setBackground(new Color(255, 255, 255));
		
		String caminhoImagem = "./imagensParaGui/imagensEditadas/play_pause2Branco.png";
		
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
		play.setBounds(66, 438, 64, 66);
		play.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tocarMusica();
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

		JLabel lblAddDiretrio = new JLabel("Adicionar Diretório");
		lblAddDiretrio.setForeground(new Color(255, 255, 255));
		lblAddDiretrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddDiretrio.setBounds(36, 113, 157, 26);
		frmPlayer.getContentPane().add(lblAddDiretrio);

	}
	
	private void botaoAddPlayLists(){
		JButton addPlayList = new JButton("");
		addPlayList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addPlayList.setBackground(new Color(255, 255, 255));
		
		String caminhoImagem = "./imagensParaGui/imagensEditadas/mais2Branco.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			addPlayList.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		
		addPlayList.setBounds(690, 423, 72, 66);
		addPlayList.setVisible(true);
		addPlayList.setBorderPainted(false);
		addPlayList.setOpaque(false);
		addPlayList.setFocusPainted( false );

		frmPlayer.getContentPane().add(addPlayList);
		
		JLabel lblAddPlaylist = new JLabel("Add Playlist");
		lblAddPlaylist.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddPlaylist.setForeground(new Color(255, 255, 255));
		lblAddPlaylist.setBounds(764, 446, 90, 26);
		frmPlayer.getContentPane().add(lblAddPlaylist);
		
	}
		
	/**
     * Adiciona um botao na tela com a função de adicionar diretório
     */
	private void botaoAddDiretorio() {

		addDiretorio = new JButton("");
		addDiretorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser diretorio = new JFileChooser();
				diretorio.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int retorneVal = diretorio.showSaveDialog(null);
				if(retorneVal == JFileChooser.APPROVE_OPTION) {
					String caminhoDiretorio = diretorio.getSelectedFile().getAbsolutePath();
				    File[] files = new File(caminhoDiretorio).listFiles();
				    for (File file : files) {
				        String nome = file.getName();
				        String caminho = file.getAbsolutePath();
				        modeloLista.addElement(nome);
						Musica m = new Musica(nome, caminho);
						musicas.add(m);
				    }
					System.out.println();
				}
				
				/*FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Arquivos com extensão mp3", "mp3");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(null);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					String nomeMusica = chooser.getSelectedFile().getName();
					String caminho = chooser.getSelectedFile().getAbsolutePath();
					modeloLista.addElement(chooser.getSelectedFile().getName());
					Musica m = new Musica(nomeMusica, caminho);
					musicas.add(m);
				}*/
			}
		});
		addDiretorio.setBackground(new Color(255, 255, 255));
		
		String caminhoImagem = "./imagensParaGui/imagensEditadas/mais2Branco.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			addDiretorio.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente n�o existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		
		addDiretorio.setBounds(46, 38, 113, 76);
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
	
		JLabel lblAddArquivo = new JLabel("Adicionar Arquivo");
		lblAddArquivo.setForeground(new Color(255, 255, 255));
		lblAddArquivo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddArquivo.setBounds(46, 268, 145, 20);
		frmPlayer.getContentPane().add(lblAddArquivo);
		
	}
	
	/**
     * Adiciona um botão na tela com a função de adicionar um arquivo
     */
	private void botaoAddArquivo() {

		addArquivo = new JButton("");
		addArquivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser arquivo = new JFileChooser();
				FileNameExtensionFilter filtrar = new FileNameExtensionFilter(
				"Arquivos com extensão mp3", "mp3");
				arquivo.setFileFilter(filtrar);
				int retorneVal = arquivo.showOpenDialog(null);
				if(retorneVal == JFileChooser.APPROVE_OPTION) {
					String nomeMusica = arquivo.getSelectedFile().getName();
					String caminho = arquivo.getSelectedFile().getAbsolutePath();
					modeloLista.addElement(nomeMusica);
					Musica m = new Musica(nomeMusica, caminho);
					musicas.add(m);
				}
			}
		});
		addArquivo.setBackground(new Color(255, 255, 255));
		
		
		String caminhoImagem2 = "./imagensParaGui/imagensEditadas/mais2Branco.png";
		
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
		
		addArquivo.setBounds(46, 202, 113, 74);
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
		
		
		JLabel lblMsicas = new JLabel("Músicas");
		lblMsicas.setForeground(new Color(255, 255, 255));
		lblMsicas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMsicas.setBounds(281, 28, 79, 14);
		frmPlayer.getContentPane().add(lblMsicas);
	
	}
	
	private void listaDePlaylists() {
		
	}
	
	private void rotuloListaDeMusicas() {
		
	}
	/**
     * @return A tela do reprodutor de musica
     */
	public JFrame getFrame() {
		return frmPlayer;
	}
	
	
	public void botaoAnteriorMusica() {
		
		botaoAnterior = new JButton("");
		botaoAnterior.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    anteriorMusica();
			}
		});
		
		botaoAnterior.setBounds(24, 450, 43, 43);
		botaoAnterior.setBackground(new Color(255, 255, 255));
		String caminhoImagem = "./imagensParaGui/imagensEditadas/anteriorBranco.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente n�o existe...");
			}
			
			botaoAnterior.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente n�o existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		frmPlayer.getContentPane().add(botaoAnterior);
		botaoAnterior.setBorderPainted(false);
		botaoAnterior.setOpaque(false);
		botaoAnterior.setFocusPainted( false );
		
	}
	
	public void botaoProximaMusica() {
		botaoProximo = new JButton("");
		botaoProximo.setBounds(130, 450, 43, 43);
				
		botaoProximo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				proximaMusica();
			}
		});
		
		botaoProximo.setBackground(new Color(255, 255, 255));
		String caminhoImagem = "./imagensParaGui/imagensEditadas/proximaBranco.png";
		
		try {
			File arquivoImagem = new File(caminhoImagem);
			
			if(!arquivoImagem.exists()) {
				throw new Exception("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
			}
			
			botaoProximo.setIcon(new ImageIcon(caminhoImagem));  
		}
		catch(NullPointerException e){
			System.err.println("Erro ao abrir o arquivo Imagem!\nProvavelmente não existe...");
		}
		catch(Exception e) {
			System.err.println( e.getMessage() );
		}
		frmPlayer.getContentPane().add(botaoProximo);
		botaoProximo.setBorderPainted(false);
		botaoProximo.setOpaque(false);
		botaoProximo.setFocusPainted( false );
	}
	
	public void proximaMusica() {
		try {
			int posicaoSelecao = listaMusicas.getSelectedIndex();
			if(posicaoSelecao == musicas.size()-1) {
				listaMusicas.setSelectedIndex(0);
				nomeMusicaLista = musicas.get(0).getNome();
			} else {	
				posicaoSelecao += 1;
				listaMusicas.setSelectedIndex(posicaoSelecao);
				nomeMusicaLista = musicas.get(posicaoSelecao).getNome();
			}
			if(nomeMusicaLista.equals(nomeTemporario) && contador % 2 == 0) {
				contador = 0;
			} else if(nomeMusicaLista.equals(nomeTemporario) && contador % 2 == 1) {
				contador = 1;
			}
		} catch(NullPointerException e) {
			System.out.println("selecione primeiro a musica!!!");
		}
	}
	
	@SuppressWarnings("deprecation")
	public void tocarMusica() {
	
		if(startMusica) {
			String caminho = PercorrerListaMusica(musicas);
			if(caminho == "") {
				return;
			}
			File arquivoMp3 = new File(caminho);
			TocarMusica musica = new TocarMusica();
			musica.tocar(arquivoMp3);
	 		musica.start();
	 		startMusica = false;
	 		m = musica;
		}
		else 
		{
			if(!nomeMusicaLista.equals(nomeTemporario)) {
				m.resume();
				m.getPlayer().close();
				String caminho = PercorrerListaMusica(musicas);
				if(caminho.equals("")) {
					return;
				}
				contador = 0;
				File arquivoMp3 = new File(caminho);
				TocarMusica musica = new TocarMusica();
				musica.tocar(arquivoMp3);
		 		musica.start();
		 		startMusica = false;
		 		m = musica;
			}
			else if(!m.isAlive()) {
				proximaMusica();
				String caminho = PercorrerListaMusica(musicas);
				if(caminho.equals("")) {
					return;
				}
				File arquivoMp3 = new File(caminho);
				TocarMusica musica = new TocarMusica();
				musica.tocar(arquivoMp3);
		 		musica.start();
		 		startMusica = false;
		 		m = musica;
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

	public void anteriorMusica() {

		try {
			if(listaMusicas.getSelectedIndex() == 0) {
				int ultimaMusica = musicas.size()-1;
				listaMusicas.setSelectedIndex(ultimaMusica);
				nomeMusicaLista = musicas.get(ultimaMusica).getNome();
				return;
			}else { 
				int posicaoSelecao = listaMusicas.getSelectedIndex();
				posicaoSelecao -= 1;
				listaMusicas.setSelectedIndex(posicaoSelecao);
				nomeMusicaLista = musicas.get(posicaoSelecao).getNome();
			}
			if(nomeMusicaLista.equals(nomeTemporario) && contador % 2 == 0) {
				contador = 0;
			} else if(nomeMusicaLista.equals(nomeTemporario) && contador % 2 == 1) {
				contador = 1;
			}
		} catch(NullPointerException e) {
			System.out.println("selecione primerio a musica!");
		}
	}
	private void ListaDeMusicas() {
		
		modeloLista = new DefaultListModel<>();
		modeloLista.addElement("music");
		modeloLista.addElement("music2");	
		
		listaMusicas = new JList<>(modeloLista);
		JScrollPane barraRolagem = new JScrollPane(listaMusicas, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		
		listaMusicas.setSelectedIndex(0); //setando o item padrao do JList para a primeira musica
		listaMusicas.setBounds(199, 53, 225, 436);
		barraRolagem.setBounds(199, 53, 225, 436);
		frmPlayer.getContentPane().add(barraRolagem);
		//frmPlayer.getContentPane().add(listaMusicas);
		
		listaMusicas.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DELETE) {
					int posicao = listaMusicas.getSelectedIndex();
					modeloLista.remove(posicao);
					musicas.remove(posicao);
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {}
			
		});
			
		
		listaMusicas.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				contador = 0;
				if(e.getClickCount() == 2 && m!= null) {
					nomeMusicaLista = (String)listaMusicas.getModel()
				    .getElementAt(listaMusicas.locationToIndex(e.getPoint()));
					startMusica = true;
					if(m.isAlive()) {
						m.resume();
						m.getPlayer().close();
					}
					tocarMusica();
					return;
				}
				nomeMusicaLista = (String)listaMusicas.getModel()
				.getElementAt(listaMusicas.locationToIndex(e.getPoint()));
			}
		});
	}

	public String PercorrerListaMusica(ArrayList<Musica> musicas) {
		String caminhoAtualizado="";
		for(int i = 0; i < musicas.size(); i++) {
			if(musicas.get(i).getNome().equals(nomeMusicaLista)) {
				caminhoAtualizado = musicas.get(i).getCaminho();
				nomeTemporario = nomeMusicaLista;
			}
		}
		return caminhoAtualizado;
	}
}