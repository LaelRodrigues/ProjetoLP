package classes;

/**
 * Representa uma m�sica
 * @author	Robson Lael
 * @author 	Samuel Lucas de Moura Ferino
 * @since   08.06.2018
 * @version 0.0.2
 */
public class Musica {
	
	private String nome;
	private String caminho;
	
	/**
     * Construtor padr�o
     */
	public Musica(){}
	
	/**
     * Construtor parametrizado
     * @param	nome Nome da m�sica
     * @param 	caminho Caminho do local onde a m�sica foi armazenada
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
     * M�todo get do atributo nome
     * @return Nome da m�sica
     */
	public String getNome() {
		return nome;
	}
	
	/**
     * M�todo set do atributo nome
     * @param nome 	Nome da m�sica
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
     * M�todo get do atributo caminho
     * @return Caminho da m�sica
     */
	public String getCaminho() {
		return caminho;
	}
	
	/**
     * M�todo set do atributo caminho
     * @param caminho Caminho da m�sica
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
