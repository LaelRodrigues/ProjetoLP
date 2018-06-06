package telas;


import javax.swing.JFrame;

import classes.Musica;
import javazoom.jl.player.Player;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class MediaPlayer {

	JFrame frame;
	Player tocar;
	JButton play, pause;
	Musica m;
	int contador;
	boolean aux = true;

	
	public MediaPlayer() {
		initialize();
		BotoesMusica();
		barraProgresso();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
	}
	
	private void BotoesMusica() {
		
		String path = "/home/lael/music";
		File mp3File = new File(path);
		
		contador = 0;
		play = new JButton("Play/Pause");
		play.setBounds(42, 214, 112, 25);
		play.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(aux) {
					Musica musica = new Musica();
					musica.tocar(mp3File);
			 		musica.start();
			 		aux = false;
			 		m = musica;
				}
				else {
					if(m.getPlayer().isComplete()) {
						m.getPlayer().close();
						aux = true;
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
	}
	
	
	private void barraProgresso() {
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(239, 214, 148, 25);
		frame.getContentPane().add(progressBar);
	}
	
	public JFrame getFrame() {
		return frame;
	}
}
