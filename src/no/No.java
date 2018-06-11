package no;

/**
 * Representa um n� de uma �rvore bin�ria
 * @see     Object
 * @author  Samuel Lucas de Moura Ferino
 * @since   11.06.2018 
 * @version 0.0.3
 */
public class No{
    
    // -> ATRIBUTOS
    
    private No pai;   // -> Endere�o do n� pai
    private No filhoEsquerdo;   // -> Endere�o do n� filho � esquerda
    private No filhoDireito;   // -> Endere�o do n� filho � direita
    
    // -> M�TODOS
    
    /**
     * Construtor padr�o
     */
    protected No(){
    
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    
    }
    
       
    /**
     * Constr�i o n� com todos os atributos (Construtor parametrizado)
     * @param pai   Endere�o do n� pai
     * @param filhoEsquerdo Endere�o/Ponteiro para o n� filho esquerdo
     * @param filhoDireito Endere�o/Ponteiro 
     */
    protected No( No pai, No filhoEsquerdo, No filhoDireito){
    	try {
		
    		if( pai == null ) {
    			throw new NullPointerException("no pai est� nulo");
    		}
    		else {
    			this.pai = pai;
    		}
    		
    		if( filhoEsquerdo == null ) {
    			throw new NullPointerException("no filho esquerdo est� nulo");
    		}
    		else {
    			this.filhoEsquerdo = filhoEsquerdo;
    		}
    		
    		if( filhoDireito == null) {
    			throw new NullPointerException("no filho esquerdo est� nulo");
    		}
    		else {
    			this.filhoDireito = filhoDireito;
    		}	
    	}
    	catch( NullPointerException e) {
    		System.err.println( e.getMessage() );
    	}
    	catch( Exception e){
    		System.err.println( e.getMessage() );
    	}
	        
    }
    
    /**
     * M�todo get do atributo pai
     * @return  Endere�o pai do n�
     */
    protected No getPai(){ return this.pai; }
    
    /**
     * M�todo set do atributo pai
     * @param   pai  Endere�o pai do n�
     */
    protected void setPai(No pai){ this.pai = pai; }
    
    /**
     * M�todo get do atributo filhoEsquerdo
     * @return  Endere�o do filho esquerdo do n�
     */
    protected No getFilhoEsquerdo(){ return this.filhoEsquerdo; }
    
    /**
     * M�todo set do atributo filhoEsquerdo
     * @param   filhoEsquerdo  Endere�o do filho esquerdo do n�
     */
    protected void setFilhoEsquerdo(No filhoEsquerdo){ this.filhoEsquerdo = filhoEsquerdo; }
    
    /**
     * M�todo get do atributo filhoDireito
     * @return  Endere�o do filho direito do n�
     */
    protected No getFilhoDireito(){ return this.filhoDireito; }
    
    /**
     * M�todo set do atributo filhoDireito
     * @param   filhoDireito  Endere�o do filho direito do n�
     */
    protected void setFilhoDireito(No filhoDireito){ this.filhoDireito = filhoDireito; }
    
}
