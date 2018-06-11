package classes;

/**
 * Implementacao da classe do Usuario 
 * @see     Usuario
 * @author	Robson Lael
 * @since   07.06.2018
 * @version 0.0.1
 */
public class Usuario implements Comparable<Usuario>{
	
	// -> ATRIBUTOS
	
	private String id; // -> Número de identificação do usuário
	private String nome; // -> Nome do usuário
	private String senha; // -> Senha do usuário
	private boolean vip; // -> Status de acesso do usuário
	
	/**
     * Construtor padrão
     */
	public Usuario() {
		
		this.id = new String();
		this.nome = new String();
		this.senha = new String();
		this.vip = false;
		
	}
	
	/**
     *  (Construtor parametrizado)
     * @param id	Número de identificação do usuário
     * @param nome 	Nome do usuário
     * @param senha	Senha do usuário
     * @param vip	Status do usuário
     */
	public Usuario(String id, String nome, String senha, boolean vip) {
		try{
			if( id == null) {
				throw new NullPointerException("variável id está nulo");
			}
			else {
				this.id = id;
			}	
			
			if( nome == null){
				throw new NullPointerException("variável nome está nulo");	
			}
			else{
				this.nome = nome;
			}
			
			if( senha == null) {
				throw new NullPointerException("variável senha está nulo");
			}
			else{
				this.senha = senha;
			}
			
			this.vip = vip;
			
		}
		catch( NullPointerException e){
			System.err.println( e.getMessage() );
		}
		catch( Exception e){
			System.err.println( e.getMessage() );
		}
		
	}
	
	/**
     * Método get do atributo id
     * @return Número de identificação do usuário
     */
	public String getId() {
		return this.id;
	}
	
	/**
     * Método set do atributo id
     * @param id 	Número de identificação do usuário
     */
	public void setId(String id) {
		try{
			this.id = id;
		}
		catch( NullPointerException e){
			System.err.println( e.getMessage() );
		}
		catch( Exception e){
			System.err.println( e.getMessage() );
		}
	}
	
	/**
     * Método get do atributo nome
     * @return nome do usuário
     */
	public String getNome() {
		return this.nome;
	}
	
	/**
     * Método set do atributo nome
     * @param nome Nome do usuário
     */
	public void setNome(String nome) {
		
		try {
			this.nome = nome;
		}
		catch( NullPointerException e){
			System.err.println( e.getMessage() );
		}
		catch( Exception e){
			System.err.println( e.getMessage() );
		}
	}
	
	/**
     * Método get do atributo senha
     * @return senha Senha do usuário
     */
	public String getSenha() {
		return this.senha;
	}
	
	/**
     * Método set do atributo senha
     * @param senha Senha do usuário
     */
	public void setSenha(String senha) {
		
		try{	
			this.senha = senha;
		}
		catch( NullPointerException e){
			System.err.println( e.getMessage() );
		}
		catch( Exception e){
			System.err.println( e.getMessage() );
		}
	}
	
	/**
     * Método get do atributo vip
     * @return Status do acesso do usuário
     */
	public boolean isVip() {
		return this.vip;
	}
	
	/**
     * Método set do atributo vip
     * @param vip Status do acesso do usuário
     */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	/**
	 * @brief   Compara dois objetos da classe Usuario
	 * @param   usuario   Objeto da classe Usuario usada na comparação
	 * @return  -1 indica que o objeto atual é menor que o objeto usuario
	 *          0 indica que ambos objetos são iguais
	 *          1 indica que o objeto atual é maior que o objeto usuario
	 */ 
	  public int compareTo( Usuario usuario ){
	    
	    if( this.id.compareTo(usuario.getId() ) == -1 ){
	    	return -1;
	    }
	    else if( this.id.compareTo(usuario.getId() ) == 0 ){
		     return 0;
		} 
	    else{
	    	return 1;
	    }
	 }	 
}
