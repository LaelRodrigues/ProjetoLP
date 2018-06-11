package no;

/**
 * Representa um nó de uma árvore binária
 * @see     Object
 * @author  Samuel Lucas de Moura Ferino
 * @since   11.06.2018 
 * @version 0.0.3
 */
public class No{
    
    // -> ATRIBUTOS
    
    private No pai;   // -> Endereï¿½o do nï¿½ pai
    private No filhoEsquerdo;   // -> Endereï¿½o do nï¿½ filho ï¿½ esquerda
    private No filhoDireito;   // -> Endereï¿½o do nï¿½ filho ï¿½ direita
    
    // -> Mï¿½TODOS
    
    /**
     * Construtor padrï¿½o
     */
    protected No(){
    
        this.pai = null;
        this.filhoEsquerdo = null;
        this.filhoDireito = null;
    
    }
    
       
    /**
     * Constrï¿½i o nï¿½ com todos os atributos (Construtor parametrizado)
     * @param pai   Endereï¿½o do nï¿½ pai
     * @param filhoEsquerdo Endereï¿½o/Ponteiro para o nï¿½ filho esquerdo
     * @param filhoDireito Endereï¿½o/Ponteiro 
     */
    protected No( No pai, No filhoEsquerdo, No filhoDireito){
    	try {
		
    		if( pai == null ) {
    			throw new NullPointerException("no pai está nulo");
    		}
    		else {
    			this.pai = pai;
    		}
    		
    		if( filhoEsquerdo == null ) {
    			throw new NullPointerException("no filho esquerdo está nulo");
    		}
    		else {
    			this.filhoEsquerdo = filhoEsquerdo;
    		}
    		
    		if( filhoDireito == null) {
    			throw new NullPointerException("no filho esquerdo está nulo");
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
     * Mï¿½todo get do atributo pai
     * @return  Endereï¿½o pai do nï¿½
     */
    protected No getPai(){ return this.pai; }
    
    /**
     * Mï¿½todo set do atributo pai
     * @param   pai  Endereï¿½o pai do nï¿½
     */
    protected void setPai(No pai){ this.pai = pai; }
    
    /**
     * Mï¿½todo get do atributo filhoEsquerdo
     * @return  Endereï¿½o do filho esquerdo do nï¿½
     */
    protected No getFilhoEsquerdo(){ return this.filhoEsquerdo; }
    
    /**
     * Mï¿½todo set do atributo filhoEsquerdo
     * @param   filhoEsquerdo  Endereï¿½o do filho esquerdo do nï¿½
     */
    protected void setFilhoEsquerdo(No filhoEsquerdo){ this.filhoEsquerdo = filhoEsquerdo; }
    
    /**
     * Mï¿½todo get do atributo filhoDireito
     * @return  Endereï¿½o do filho direito do nï¿½
     */
    protected No getFilhoDireito(){ return this.filhoDireito; }
    
    /**
     * Mï¿½todo set do atributo filhoDireito
     * @param   filhoDireito  Endereï¿½o do filho direito do nï¿½
     */
    protected void setFilhoDireito(No filhoDireito){ this.filhoDireito = filhoDireito; }
    
}
