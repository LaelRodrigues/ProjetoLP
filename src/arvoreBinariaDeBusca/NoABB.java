package arvoreBinariaDeBusca;


import classes.Usuario;

/**
 * Representa um nó de uma árvore binária
 * @see     No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.4
 */
public class NoABB{

	// -> ATRIBUTOS
	
	private Usuario usuario;  // -> Chave do nó
	private NoABB pai;   // -> Endereço do nó pai
	private NoABB esquerdo;   // -> Endereço do nó filho à esquerda
	private NoABB direito;   // -> Endereço do nó filho à direita
	   
	// -> MÉTODOS

    /**
     * Construtor padrão
     */
	public NoABB(){
		super();
		this.usuario = new Usuario();
	}

    /**
     * Constrói o nó a partir de usuário dado (Construtor parametrizado)
     * @param usuario Conteúdo da chave
     */
    public NoABB(Usuario usuario){
 
    	super();
    	
    	try{
    		if( !(usuario instanceof Usuario) ){  // -> O argumento está errado
    			throw new IllegalArgumentException("O nó deve ter a chave do tipo usuário");
    		}
    		else{
    			this.usuario = usuario;	
    		}
    	}
    	catch(IllegalArgumentException e){
    		System.err.println( e.getMessage() );
        }
    	catch(NullPointerException e){
    		System.err.println( e.getMessage() );
    	}
    	catch( Exception e ) {
    		System.err.println( e.getMessage() );
    	}
    	
    }
    
    /**
     * Constrói o nó a partir de usuário dado (Construtor parametrizado)
     * @param usuario Conteédo da chave
     * @param 
     */
    public NoABB(NoABB pai, NoABB esquerdo, NoABB direito, Usuario usuario){
 
    	try{
    	
    		this.pai = pai;
    		this.esquerdo = esquerdo;
    		this.direito = direito;
    		
    		if( !(usuario instanceof Usuario) ){  // -> O argumento está errado
    			throw new IllegalArgumentException("O nó deve ter a chave do tipo usuário");
    		}
    		else{
    			this.usuario = usuario;	
    		}
    	}
    	catch(IllegalArgumentException e){
    		System.err.println( e.getMessage() );
        }
    	catch(NullPointerException e){
    		System.err.println( e.getMessage() );
    	}
    	
    }
    	
    /**
     * M�todo get do atributo usuario
     * @return  Chave do nó
     */
	public Usuario getUsuario(){ return this.usuario; }
	
	/**
     * M�todo set do atributo chave
     * @param  chave Chave do n�
     */
    public void setUsuario(Usuario usuario){ 
    	
    	try {
    		this.usuario = usuario;
    	}
		catch( NullPointerException e){
			System.err.println( e.getMessage() );
		}
		catch( Exception e){
			System.err.println( e.getMessage() );
		}
	
    }
   
	/**
	 * Método get do atributo pai
	 * @return	Nó pai
	 */
	public NoABB getPai(){
		return this.pai; 
	}
	
	/**
	 * Método set do atributo pai
	 * @param	pai	Nó pai
	 */
	public void setPai( NoABB pai){
		this.pai = pai;
	}	
	
	/**
	 * Método get do atributo esquerdo
	 * @return	Nó filho à esquerda
	 */
	public NoABB getEsquerdo(){
		return this.esquerdo; 
	}
	
	/**
	 * Método set do atributo esquerdo 
	 * @param	esquerdo	Nó filho à esquerda
	 */
	public void setEsquerdo( NoABB esquerdo){
		this.esquerdo = esquerdo; 
	}
	
	/**
	 * Método get do atributo direito
	 * @return	Nó filho à direita
	 */
	public NoABB getDireito(){
		return this.direito; 
	}
	
	/**
	 * Método set do atributo direito
	 * @return	esquerdo	Nó filho à direita
	 */
	public void setDireito( NoABB direito){
		this.direito = direito; 
	}
	
}
