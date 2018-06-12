package arvoreBinariaDeBusca;

import classes.Usuario;

/**
 * Representa uma �rvore de busca bin�ria (ABB) 
 * @see     NodeABB
 * @see		No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018
 * @version 0.0.1
 */
public class ABB {

    // -> ATRIBUTOS
    
    private NoABB raiz;  // -> N� raiz da ABB
    private int quantidadeDeNos;	// -> Quantidade de n� que comp�em a ABB
    
    // -> M�TODOS
    
    /**
     * Construtor padr�o
     */
    public ABB(){
        this.raiz = new NoABB();
        this.quantidadeDeNos = 0;
    }
    
    /**
     * M�todo get do atributo raiz
     * @return Raiz da �rvore
     */
    public NoABB getRaiz(){ 
    	return this.raiz; 
    }

    /**
     * M�todo get do atributo quantidadeDeNos
     * @return Quantidade de n�s que comp�em a �rvore
     */
    public int getQuantidadeDeNos(){ 
    	return this.quantidadeDeNos; 
    }
    
    /**
     * Buscando o n� com a chave correspondente entrada - O(log n)
     * @param usuario Usu�rio a ser buscado na ABB
     * @return True caso tenha encontrado algum n� com a correspondente chave sen�o false
     */
    public boolean busca(Usuario usuario){
    	
    	if(this.quantidadeDeNos == 0) { // -> A �rvore � vazia
    		return false;
    	}
    	
    	// -> N�s auxiliares usados na busca
    	NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null && aux.getUsuario().compareTo(usuario) != 0 ){     

            auxPai = aux;

            if( usuario.compareTo( aux.getUsuario() ) == 1 ){ 	// -> Procurando na sub�rvore direita
                aux = aux.getDireito();
            }
            else{							// -> Procurando na sub�rvore esquerda
                aux = aux.getEsquerdo();
            }    
            
        }
    	
    	if( aux != null) {
    		return true;
    	}

    	return false;
    	
    }
    
    /**
     * Buscando o n� com a chave correspondente entrada - O(log n)
     * @param usuario Usu�rio a ser buscado na ABB
     * @return Usuario se existir ou null sen�o
     */
    public Usuario buscaLocal(Usuario usuario) throws NullPointerException {
    	
    	if(this.quantidadeDeNos == 0) { // -> A �rvore � vazia
    		return null;
    	}
    	
    	// -> N�s auxiliares usados na busca
    	NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null && aux.getUsuario().compareTo(usuario) != 0 ){     

            auxPai = aux;

            if( usuario.compareTo( aux.getUsuario() ) == 1 ){ 	// -> Procurando na sub�rvore direita
                aux = aux.getDireito();
            }
            else{							// -> Procurando na sub�rvore esquerda
                aux = aux.getEsquerdo();
            }    
            
        }
    	
    	if( aux != null) {
    		return aux.getUsuario();
    	}

    	return null;
    	
    }
    
    /**
     * Insere um n� na ABB caso ele n�o exista previamente 
     * @param usuario Usu�rio a ser adicionado � ABB
     * @return True caso seja inserido com sucesso sen�o false
     */
    public boolean insere(Usuario usuario){
    	
    	if(this.quantidadeDeNos == 0) { // -> Primeira inser��o na ABB
    	
    		if( this.raiz == null) {
    			this.raiz = new NoABB();
    		}
    		
    		this.raiz.setUsuario(usuario);
    		++this.quantidadeDeNos;
    		return true;
    	}
    	
        if( busca(usuario) == true ){	// -> N� j� existe na ABB
        	return false;
        }
        
        NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null ){     // -> BUSCANDO LOCAL ONDE O N� SER� INSERIDO E ARMAZENANDO NA VARI�VEL "auxPai"
        	
        	auxPai = aux;
        	
            if( usuario.compareTo(aux.getUsuario()) == 1 ){
                aux = aux.getDireito();
            }
            else{
                aux = aux.getEsquerdo();
            }    

        }
        
        NoABB novoNo = new NoABB(usuario);
        
        if( usuario.compareTo(auxPai.getUsuario() ) == 1){   // -> � o filho direito de "auxPai" 
        	auxPai.setDireito(novoNo);
        }
        else{   						// -> � o filho esquerdo de "auxPai"
        	auxPai.setEsquerdo(novoNo);
        }    
        
        ++this.quantidadeDeNos;
        return true;
    
    }
    
    /**
     * Remove um n� na ABB caso ele exista previamente 
     * @param usuario	Usu�rio a ser exclu�do
     * @return True caso seja removido com sucesso sen�o false
     */
	public boolean remove(Usuario usuario){
		
		if(this.quantidadeDeNos == 0 ){  // -> ABB vazia	
			return false;
		}
		if( busca(usuario) == false ){  // -> N� com chave correspondente n�o encontrado
			return false;
		}

        NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( usuario.compareTo(aux.getUsuario()) != 0 ){     // -> BUSCANDO LOCAL ONDE DO N� QUE SER�  E ARMAZENANDO NA VARI�VEL "auxPai"
        	
        	auxPai = aux;
        	
            if( usuario.compareTo(aux.getUsuario()) == 1 ){
                aux = aux.getDireito();
            }
            else{
                aux = aux.getEsquerdo();
            }    

        }
		
        if( aux.getEsquerdo() == null ){	// -> O n� a ser removido, "aux", n�o tem filho � esquerda
        	transplant(aux, aux.getDireito() );
        }
        else if( aux.getDireito() == null ){	// -> O n� a ser removido, "aux", n�o tem filho � direita
        	transplant(aux, aux.getEsquerdo() );
        }
        else{
        	
        	NoABB temporario = aux;
        	
        	while( temporario.getEsquerdo() != null ){
        		temporario = temporario.getEsquerdo();
        	}
        	
        	if(temporario.getPai() != aux) {
        		transplant(temporario, temporario.getDireito() );
        		temporario.setDireito( aux.getDireito() );
        		temporario.getPai().setDireito(temporario);
        	}
        	
        	transplant(aux, temporario);
        	temporario.setEsquerdo(aux.getEsquerdo() );
        	temporario.getPai().setEsquerdo(temporario);
        	
        }
        
		--this.quantidadeDeNos;
		return true;
	}
	
	/**
	 * Percorre a ABB em InOrdem
	 */
	public void percorre(){
		
		inOrdem(this.raiz);
	    System.out.println();
	    
	}	
	
	// ->     **M�TODOS PRIVADOS**
	
	/**
	 * Percorre as sub�rvores de x em InOrdem
	 * @param x	N� que a partir do qual ser� feito o percorrimento
	 */
	private void inOrdem(NoABB x){
		
		if(x != null) {
			
			inOrdem( x.getEsquerdo() );
			System.out.println( x.getUsuario().getId() + " " + x.getUsuario().getNome() );
			inOrdem( x.getDireito() );
			
		}
		
	}
	
	/**
     * Substitui uma sub�rvore como um filho de seu pai por outra sub�rvore
     * @param   u 	N� que ser� substitu�do pelo n� v
     * @param   v 	N� que substituir� o n� u
     */
	private void transplant(NoABB u, NoABB v) {
		if( u.getPai() == null ){ // -> Caso em que ser� removida a raiz por isso "v" ser� a nova raiz 		
				this.raiz = v;
	    }
        else if( u == u.getPai().getEsquerdo() ){ /// "u" � o filho � esquerda
          u.getPai().setEsquerdo(v);
        }
        else{ /// "u" � o filho � direita
          u.getPai().setDireito(v);
        }
        if(v != null){ /// J� que foi movido um filho n�o nulo, falta dizer quem � o pai dele
          v.setPai( u.getPai() );
        }
	}
			
}



