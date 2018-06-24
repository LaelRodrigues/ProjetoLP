package arvoreBinariaDeBusca;

import no.No;
import classes.Usuario;

/**
 * Representa um n� de uma �rvore bin�ria
 * @see     No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018 
 * @version 0.0.2
 */
public class NoABB extends No{

	// -> ATRIBUTOS
	
	private Usuario usuario;  // -> Chave do n�
	
	// -> M�TODOS

    /**
     * Construtor padr�o
     */
	public NoABB(){
		super();
		this.usuario = new Usuario();
	}

    /**
     * Constr�i o n� a partir de usuario dado (Construtor parametrizado)
     * @param usuario Conte�do da chave
     */
    public NoABB(Usuario usuario){
 
    	super();
    	
    	try{
    		if( !(usuario instanceof Usuario) ){  // -> O argumento est� errado
    			throw new IllegalArgumentException("O n� deve ter a chave do tipo usu�rio");
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
     * Constrói o nó a partir de usuário dado (Construtor parametrizado)
     * @param usuario Conteédo da chave
     * @param 
     */
    public NoABB(NoABB pai, NoABB esquerdo, NoABB direito, Usuario usuario){
 
    	super(pai, esquerdo, direito);
    	
    	try{
    		if( !(usuario instanceof Usuario) ){  // -> O argumento está errado
    			throw new IllegalArgumentException("O n� deve ter a chave do tipo usu�rio");
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
     * @return  Chave do n�
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
	 * M�todo get do atributo pai da super classe
	 * @return	N� pai
	 */
	public NoABB getPai(){
		return (NoABB)getPai(); 
	}
	
	/**
	 * M�todo set do atributo pai da super classe
	 * @return	pai	N� pai
	 */
	public void setPai( NoABB pai){
		setPai(pai); 
	}	
	
	/**
	 * M�todo get do atributo esquerdo da super classe
	 * @return	N� filho � esquerda
	 */
	public NoABB getEsquerdo(){
		return (NoABB)getFilhoEsquerdo(); 
	}
	
	/**
	 * M�todo set do atributo esquerdo da super classe
	 * @return	esquerdo	N� filho � esquerda
	 */
	public void setEsquerdo( NoABB esquerdo){
		setFilhoEsquerdo(esquerdo); 
	}
	
	/**
	 * M�todo get do atributo direito da super classe
	 * @return	N� filho � direita
	 */
	public NoABB getDireito(){
		return (NoABB)getFilhoDireito(); 
	}
	
	/**
	 * M�todo set do atributo direito da super classe
	 * @return	esquerdo	N� filho � direita
	 */
	public void setDireito( NoABB direito){
		setFilhoDireito(direito); 
	}
	
}
