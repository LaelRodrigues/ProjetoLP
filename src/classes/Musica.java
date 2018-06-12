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
     * @param	nome Nome da m�sica
     * @param 	caminhao Caminho do local onde a m�sica foi armazenada
     */
	public Musica(String nome, String caminho) {
		super();
		this.nome = nome;
		this.caminho = caminho;
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
		
		this.nome = nome;
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
