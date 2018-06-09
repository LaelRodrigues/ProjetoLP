package classes;

/**
 * Implementacao da classe Musica
 * @see     Musica
 * @author	Robson Lael
 * @since   08.06.2018
 * @version 0.0.1
 */

public class Musica {
	
	private String nome;
	private String caminho;
	
	/**
     * Construtor padrao
     */
	public Musica() {}
	
	/**
     * Construtor parametrizado
     */
	public Musica(String nome, String caminho) {
		super();
		this.nome = nome;
		this.caminho = caminho;
	}
	
	/**
     * Funcao que retorna o nome da musica
     * @return nome da musica
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * Funcao para alterar o nome da musica
     * @param nome da musica
     */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
     * Funcao que retorna o caminho da musica
     * @return caminho da musica
     */
	public String getCaminho() {
		return caminho;
	}
	
	/**
     * Funcao para alterar o nome da musica
     * @param caminho da musica
     */
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
}
