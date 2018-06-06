package arvoreBinariaDeBusca;

/**
 * Representa um nó de uma árvore binária
 * @see     Object
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.1
 */
public class No{
    
    // -> ATRIBUTOS
    
    private int chave;  // -> Chave do nó
    private No pai;   // -> Endereço do nó pai
    private No filhoEsquerdo;   // -> Endereço do nó filho à esquerda
    private No filhoDireito;   // -> Endereço do nó filho à direita
    
    // -> MÉTODOS
    
    /**
     * Construtor padrão
     */
    public No(){
    
        this.chave = 0;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    
    }
    
    /**
     * Constrói o nó a partir da chave dada (Construtor parametrizado)
     * @param chave Conteúdo da chave
     */
    public No(int chave){
 
        this.chave = chave;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
 
    }
    
    /**
     * Constrói o nó com todos os atributos (Construtor parametrizado)
     * @param chave Conteúdo da chave
     * @param pai   Endereço do nó pai
     * @param filhoEsquerdo Endereço/Ponteiro para o nó filho esquerdo
     * @param filhoDireito Endereço/Ponteiro 
     */
    public No(int chave, No pai, No filhoEsquerdo, No filhoDireito){
    	
    	try {
    		
	        this.chave = chave;
	        
	        if( this.pai instanceof No){
	        	this.pai = pai;
	        }
	        else{	
	        	throw new IllegalArgumentException( "O noh pai deve ser do tipo no" ); 
    		}
    			        
	        if(this.filhoEsquerdo instanceof No) {
	        	this.filhoEsquerdo = filhoEsquerdo;
	        }
	        else{	
	        	throw new IllegalArgumentException( "O noh filho esquerdo deve ser do tipo no" ); 
    		}

	        if(this.filhoDireito instanceof No) {
	        	this.filhoDireito = filhoDireito;
	        }
	        else{
	        	throw new IllegalArgumentException( "O noh filho direito deve ser do tipo no" ); 	
	        }
    	
    	}
    	catch( IllegalArgumentException e){
    		System.err.println(e.getMessage() );
    	}
    	catch( Exception e) {
    		System.err.println(e.getMessage() );
    	}
    	
    }
    
    /**
     * Método get do atributo chave
     * @return  Chave do nó
     */
    public int getChave(){ return this.chave; }
    
    /**
     * Método set do atributo chave
     * @param  chave Chave do nó
     */
    public void setChave(int chave){ this.chave = chave; }
   
    /**
     * Método get do atributo pai
     * @return  Endereço pai do nó
     */
    public No getPai(){ return this.pai; }
    
    /**
     * Método set do atributo pai
     * @param   pai  Endereço pai do nó
     */
    public void setPai(No pai){ this.pai = pai; }
    
    /**
     * Método get do atributo filhoEsquerdo
     * @return  Endereço do filho esquerdo do nó
     */
    public No getFilhoEsquerdo(){ return this.filhoEsquerdo; }
    
    /**
     * Método set do atributo filhoEsquerdo
     * @param   filhoEsquerdo  Endereço do filho esquerdo do nó
     */
    public void setFilhoEsquerdo(No filhoEsquerdo){ this.filhoEsquerdo = filhoEsquerdo; }
    
    /**
     * Método get do atributo filhoDireito
     * @return  Endereço do filho direito do nó
     */
    public No getFilhoDireito(){ return this.filhoDireito; }
    
    /**
     * Método set do atributo filhoDireito
     * @param   filhoDireito  Endereço do filho direito do nó
     */
    public void setFilhoDireito(No filhoDireito){ this.filhoDireito = filhoDireito; }
    
}
