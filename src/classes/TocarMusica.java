package classes;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * Representa o ato de tocar música
 * @see     Musica
 * @author	Robson Lael
 * @since 	10.06.2018
 * @version 0.0.2
 */
public class TocarMusica extends Thread {
	
	private File mp3;
	public Player player;
	
	/**
     * Funcao que informa o caminho da musica que sera tocada
     * @param caminho da musica
     */
	public void tocar(File mp3) {
		this.mp3 = mp3;
	}
	
	public void run() {
		try {	
			FileInputStream fis = new FileInputStream(mp3);
			BufferedInputStream bis = new BufferedInputStream(fis);
			this.player = new Player(bis);
			this.player.play(); 
			
		} catch (Exception e) {
			System.out.println("Problema ao tocar Musica" + mp3);
		e.printStackTrace();
		}
	}
	
	public Player getPlayer() {
		return player;
	}
}
