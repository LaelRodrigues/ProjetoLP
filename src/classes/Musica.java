package classes;

/**
 * Representa uma música
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   08.06.2018
 * @version 0.0.2
 */
public class Musica {
	
	private String nome;
	private String caminho;
	
	/**
     * Construtor padrão
     */
	public Musica(){}
	
	/**
     * Construtor parametrizado
     * @param	nome Nome da música
     * @param 	caminho Caminho do local onde a música foi armazenada
     */
	public Musica(String nome, String caminho) {
		
		super();
		
		try {
			this.nome = nome;
			this.caminho = caminho;
		}
		catch( NullPointerException e ){
			System.err.println(e.getMessage() );
		}
		catch( Exception e){
			System.err.println(e.getMessage() );
		}
		
	}
	
	/**
     * Método get do atributo nome
     * @return Nome da música
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * Método set do atributo nome
     * @param nome 	Nome da música
     */
	public void setNome(String nome) {
		
		try{
			this.nome = nome;
		}
		catch( NullPointerException e ){
			System.err.println(e.getMessage() );
		}
		catch( Exception e){
			System.err.println(e.getMessage() );
		}
		
	}
	
	/**
     * Método get do atributo caminho
     * @return Caminho da música
     */
	public String getCaminho() {
		return caminho;
	}
	
	/**
     * Método set do atributo caminho
     * @param caminho Caminho da música
     */
	public void setCaminho(String caminho) {
		try{
			this.caminho = caminho;
		}
		catch( NullPointerException e ){
			System.err.println(e.getMessage() );
		}
		catch( Exception e){
			System.err.println(e.getMessage() );
		}
	}
}
