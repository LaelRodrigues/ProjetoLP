package classes;


/**
 * Implementacao da classe do Usuario 
 * @see     Usuario
 * @author	Robson Lael
 * @since   07.06.2018
 * @version 0.0.1
 */

public class Usuario {
	
	private String id;
	private String nome;
	private String senha;
	private boolean vip; 
	
	/**
     * Construtor padrao
     */
	public Usuario() {
	}
	
	/**
     * Construtor parametrizado
     */
	public Usuario(String id, String nome, String senha, boolean vip) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.vip = vip;
	}
	
	/**
     * 
     * @return
     */
	public String getId() {
		return id;
	}
	
	/**
     * Funcao para a alterar o identificador do usuario
     * @param id do usuario
     */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * Funcao que retorna o nome do usuario
     * @return nome do usuario
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * Funcao para a alterar o nome do usuario
     * @param nome do usuario
     */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
     * Funcao que retorna a senha do usuario
     * @return senha do usuario
     */
	public String getSenha() {
		return senha;
	}
	
	/**
     * Funcao para alterar a senha do usuario
     * @param senha do usuario
     */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/**
     * Funcao que define se o tipo de usuario e vip ou comum
     * @return se o usuario e vip ou comum
     */
	public boolean isVip() {
		return vip;
	}
	
	/**
     * Funcao que altera o tipo do usuario
     * @param true se e vip ou false se e usuairo comum
     */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
}
