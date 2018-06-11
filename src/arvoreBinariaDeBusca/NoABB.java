package arvoreBinariaDeBusca;

import no.No;
import classes.Usuario;

/**
 * Representa um nó de uma árvore binária
 * @see     No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.2
 */
public class NoABB extends No{

	// -> ATRIBUTOS
	
	private Usuario usuario;  // -> Chave do nó
	
	// -> MÉTODOS

    /**
     * Construtor padrão
     */
	public NoABB(){
		super();
		this.usuario = new Usuario();
	}

    /**
     * Constrói o nó a partir de usuario dado (Construtor parametrizado)
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
    	
    }
    
    /**
     * Constrói o nó a partir de usuario dado (Construtor parametrizado)
     * @param usuario Conteúdo da chave
     * @param 
     */
    public NoABB(NoABB pai, NoABB esquerdo, NoABB direito, Usuario usuario){
 
    	super(pai, esquerdo, direito);
    	
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
    	
    }
    	
    /**
     * Método get do atributo usuario
     * @return  Chave do nó
     */
	public Usuario getUsuario(){ return this.usuario; }
	
	/**
     * Método set do atributo chave
     * @param  chave Chave do nó
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
	 * Método get do atributo pai da super classe
	 * @return	Nó pai
	 */
	public NoABB getPai(){
		return (NoABB)getPai(); 
	}
	
	/**
	 * Método set do atributo pai da super classe
	 * @return	pai	Nó pai
	 */
	public void setPai( NoABB pai){
		setPai(pai); 
	}	
	
	/**
	 * Método get do atributo esquerdo da super classe
	 * @return	Nó filho à esquerda
	 */
	public NoABB getEsquerdo(){
		return (NoABB)getFilhoEsquerdo(); 
	}
	
	/**
	 * Método set do atributo esquerdo da super classe
	 * @return	esquerdo	Nó filho à esquerda
	 */
	public void setEsquerdo( NoABB esquerdo){
		setFilhoEsquerdo(esquerdo); 
	}
	
	/**
	 * Método get do atributo direito da super classe
	 * @return	Nó filho à direita
	 */
	public NoABB getDireito(){
		return (NoABB)getFilhoDireito(); 
	}
	
	/**
	 * Método set do atributo direito da super classe
	 * @return	esquerdo	Nó filho à direita
	 */
	public void setDireito( NoABB direito){
		setFilhoDireito(direito); 
	}
	
}
