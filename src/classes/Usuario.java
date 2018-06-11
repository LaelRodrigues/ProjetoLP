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
	
	private String id; // -> N�mero de identifica��o do usu�rio
	private String nome; // -> Nome do usu�rio
	private String senha; // -> Senha do usu�rio
	private boolean vip; // -> Status de acesso do usu�rio
	
	/**
     * Construtor padr�o
     */
	public Usuario() {
		
		this.id = new String();
		this.nome = new String();
		this.senha = new String();
		this.vip = false;
		
	}
	
	/**
     *  (Construtor parametrizado)
     * @param id	N�mero de identifica��o do usu�rio
     * @param nome 	Nome do usu�rio
     * @param senha	Senha do usu�rio
     * @param vip	Status do usu�rio
     */
	public Usuario(String id, String nome, String senha, boolean vip) {
		try{
			if( id == null) {
				throw new NullPointerException("vari�vel id est� nulo");
			}
			else {
				this.id = id;
			}	
			
			if( nome == null){
				throw new NullPointerException("vari�vel nome est� nulo");	
			}
			else{
				this.nome = nome;
			}
			
			if( senha == null) {
				throw new NullPointerException("vari�vel senha est� nulo");
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
     * M�todo get do atributo id
     * @return N�mero de identifica��o do usu�rio
     */
	public String getId() {
		return this.id;
	}
	
	/**
     * M�todo set do atributo id
     * @param id 	N�mero de identifica��o do usu�rio
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
     * M�todo get do atributo nome
     * @return nome do usu�rio
     */
	public String getNome() {
		return this.nome;
	}
	
	/**
     * M�todo set do atributo nome
     * @param nome Nome do usu�rio
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
     * M�todo get do atributo senha
     * @return senha Senha do usu�rio
     */
	public String getSenha() {
		return this.senha;
	}
	
	/**
     * M�todo set do atributo senha
     * @param senha Senha do usu�rio
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
     * M�todo get do atributo vip
     * @return Status do acesso do usu�rio
     */
	public boolean isVip() {
		return this.vip;
	}
	
	/**
     * M�todo set do atributo vip
     * @param vip Status do acesso do usu�rio
     */
	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	/**
	 * @brief   Compara dois objetos da classe Usuario
	 * @param   usuario   Objeto da classe Usuario usada na compara��o
	 * @return  -1 indica que o objeto atual � menor que o objeto usuario
	 *          0 indica que ambos objetos s�o iguais
	 *          1 indica que o objeto atual � maior que o objeto usuario
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
