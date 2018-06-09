package arvoreBinariaDeBusca;

/**
 * Representa um n� de uma �rvore bin�ria
 * @see     Object
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.1
 */
public class No{
    
    // -> ATRIBUTOS
    
    private int chave;  // -> Chave do n�
    private No pai;   // -> Endere�o do n� pai
    private No filhoEsquerdo;   // -> Endere�o do n� filho � esquerda
    private No filhoDireito;   // -> Endere�o do n� filho � direita
    
    // -> M�TODOS
    
    /**
     * Construtor padr�o
     */
    public No(){
    
        this.chave = 0;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    
    }
    
    /**
     * Constr�i o n� a partir da chave dada (Construtor parametrizado)
     * @param chave Conte�do da chave
     */
    public No(int chave){
 
        this.chave = chave;
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
 
    }
    
    /**
     * Constr�i o n� com todos os atributos (Construtor parametrizado)
     * @param chave Conte�do da chave
     * @param pai   Endere�o do n� pai
     * @param filhoEsquerdo Endere�o/Ponteiro para o n� filho esquerdo
     * @param filhoDireito Endere�o/Ponteiro 
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
     * M�todo get do atributo chave
     * @return  Chave do n�
     */
    public int getChave(){ return this.chave; }
    
    /**
     * M�todo set do atributo chave
     * @param  chave Chave do n�
     */
    public void setChave(int chave){ this.chave = chave; }
   
    /**
     * M�todo get do atributo pai
     * @return  Endere�o pai do n�
     */
    public No getPai(){ return this.pai; }
    
    /**
     * M�todo set do atributo pai
     * @param   pai  Endere�o pai do n�
     */
    public void setPai(No pai){ this.pai = pai; }
    
    /**
     * M�todo get do atributo filhoEsquerdo
     * @return  Endere�o do filho esquerdo do n�
     */
    public No getFilhoEsquerdo(){ return this.filhoEsquerdo; }
    
    /**
     * M�todo set do atributo filhoEsquerdo
     * @param   filhoEsquerdo  Endere�o do filho esquerdo do n�
     */
    public void setFilhoEsquerdo(No filhoEsquerdo){ this.filhoEsquerdo = filhoEsquerdo; }
    
    /**
     * M�todo get do atributo filhoDireito
     * @return  Endere�o do filho direito do n�
     */
    public No getFilhoDireito(){ return this.filhoDireito; }
    
    /**
     * M�todo set do atributo filhoDireito
     * @param   filhoDireito  Endere�o do filho direito do n�
     */
    public void setFilhoDireito(No filhoDireito){ this.filhoDireito = filhoDireito; }
    
}
