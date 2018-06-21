package classes;

import java.util.ArrayList;

/**
 * Representa uma plalist
 * @see 	Musica
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	12.06.2018
 * @version 0.0.1	
 */
public class Playlist {

	private String nomeDoAutor; // -> Nome do autor (Usuário) da playlist
	private ArrayList<Musica> musicas; // -> Lista de músicas

	/**
	 * Construtor padrão
	 */
	public Playlist(){
		this.nomeDoAutor = new String();
		this.musicas = new ArrayList<Musica>();
	}
	
	/**
	 * Método get do atributo nomeDoAutor
	 * @return	Nome do autor da playlist
	 */
	public String getNomeDoAutor(){
		return this.nomeDoAutor; 
	}

	/**
	 * Método get do atributo musicas
	 * @return	Array com as másicas contidas na playlist
	 */
	public ArrayList<Musica> getMusicas(){
		return this.musicas;
	}
	
}
