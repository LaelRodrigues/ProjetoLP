package arvoreBinariaDeBusca;

/**
 * Representa um nó genérico de uma árvore binária 
 * @see     No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.2
 */
public class NoABB<T>{

	// -> ATRIBUTOS
	
	private T chave;  // -> Chave do nó
	private NoABB<T> pai;   // -> Endereço do nó pai
    private NoABB<T> filhoEsquerdo;  // -> Endereço do nó filho à esquerda
    private NoABB<T> filhoDireito;   // -> Enderereço do nó filho à direita
    
	// -> MÉTODOS

    /**
     * Constrói o nó a partir de um objeto dado (Construtor parametrizado)
     * @param chave Conteúdo da chave
     */
    public NoABB(T chave ){
 
    	super();
    	
    	try{
    		this.chave = chave;	
    
    	}
    	catch(NullPointerException e){
    		System.err.println( e.getMessage() );
    	}
    	catch( Exception e){
    		System.err.println( e.getMessage() );
    	}
    	
    }
    
    /**
     * Constrói o nó a partir de usuário dado (Construtor parametrizado)
     * @param usuario Conteédo da chave
     * @param 
     */
    public NoABB(NoABB<T> pai, NoABB<T> filhoEsquerdo, NoABB<T> filhoDireito, T chave ){
    	
    	try{
    		this.pai = pai;
    		this.filhoEsquerdo = filhoEsquerdo;
    		this.filhoDireito = filhoDireito;
    		this.chave = chave;   			
    		
    	}
    	catch(NullPointerException e){
    		System.err.println( e.getMessage() );
    	}
    	catch( Exception e){
    		System.err.println( e.getMessage() );
    	}
    	
    }
    	
    /**
     * Método get do atributo chave
     * @return  Chave do nó
     */
	public T getChave(){ return this.chave; }
	
	/**
     * Método set do atributo chave
     * @param  chave Chave do nó
     */
    public void setChave( T chave){ 
    	
    	try {
    		this.chave = chave; 
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
	public NoABB<T> getPai(){
		return this.pai; 
	}
	
	/**
	 * Método set do atributo pai
	 * @return	pai	Nó pai
	 */
	public void setPai( NoABB<T> pai){
		this.pai = pai; 
	}	
	
	/**
	 * Método get do atributo esquerdo
	 * @return	Filho esquerda
	 */
	public NoABB<T> getEsquerdo(){
		return this.filhoEsquerdo; 
	}
	
	/**
	 * Método set do atributo esquerdo
	 * @return	esquerdo	Nó filho é esquerda
	 */
	public void setEsquerdo( NoABB<T> filhoEsquerdo ){
		this.filhoEsquerdo = filhoEsquerdo; 
	}
	
	/**
	 * Método get do atributo direito
	 * @return	Nó filho é direita
	 */
	public NoABB<T> getDireito(){
		return this.filhoDireito; 
	}
	
	/**
	 * Método set do atributo direito
	 * @return	esquerdo	Nó filho à direita
	 */
	public void setDireito( NoABB<T> filhoDireito){
		this.filhoDireito = filhoDireito; 
	}
	
}
