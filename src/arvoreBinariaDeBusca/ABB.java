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
     * @param value Chave a ser buscada na ABB
     * @return True caso tenha encontrado algum n� com a correspondente chave sen�o false
     */
    public boolean busca(Usuario usuario) {
    	
    	if(this.quantidadeDeNos == 0) { // -> A �rvore � vazia
    		return false;
    	}
    	
    	// -> N�s auxiliares usados na busca
    	NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null && aux.getUsuario().compareTo(usuario) != 0 ){     

            auxPai = aux;

            if( aux.getUsuario().compareTo(usuario) == 1 ){ 	// -> Procurando na sub�rvore direita
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
     * Insere um n� na ABB caso ele n�o exista previamente 
     * @param value Conte�do da chave do n� a ser adicionado
     * @return True caso seja inserido com sucesso sen�o false
     */
    public boolean insere(Usuario value){
    	
    	if(this.quantidadeDeNos == 0) { // -> Primeira inser��o na ABB
    	
    		if( this.raiz == null) {
    			this.raiz = new NoABB();
    		}
    		
    		this.raiz.setChave(value);
    		++this.quantidadeDeNos;
    		return true;
    	}
    	
        if( busca(value) == true ){	// -> N� j� existe na ABB
        	return false;
        }
        
        NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null ){     // -> BUSCANDO LOCAL ONDE O N� SER� INSERIDO E ARMAZENANDO NA VARI�VEL "auxPai"
        	
        	auxPai = aux;
        	
            if( value > aux.getChave() ){
                aux = aux.getFilhoDireito();
            }
            else{
                aux = aux.getFilhoEsquerdo();
            }    

        }
        
        NoABB novoNo = new NoABB(value);
        
        if( value > auxPai.getChave() ){   // -> � o filho direito de "auxPai" 
        	auxPai.setFilhoDireito(novoNo);
        }
        else{   						// -> � o filho esquerdo de "auxPai"
        	auxPai.setFilhoEsquerdo(novoNo);
        }    
        
        ++this.quantidadeDeNos;
        return true;
    
    }
    
    /**
     * Remove um n� na ABB caso ele exista previamente 
     * @param value	Chave a ser exclu�da
     * @return True caso seja removido com sucesso sen�o false
     */
	public boolean remove(int value){
		
		if(this.quantidadeDeNos == 0 ){  // -> ABB vazia	
			return false;
		}
		if( busca(value) == false ){  // -> N� com chave correspondente n�o encontrado
			return false;
		}

        No aux = this.raiz;
        No auxPai = null;
        
        while( aux.getChave() != value ){     // -> BUSCANDO LOCAL ONDE DO N� QUE SER�  E ARMAZENANDO NA VARI�VEL "auxPai"
        	
        	auxPai = aux;
        	
            if( value > aux.getChave() ){
                aux = aux.getFilhoDireito();
            }
            else{
                aux = aux.getFilhoEsquerdo();
            }    

        }
		
        if( aux.getFilhoEsquerdo() == null ){	// -> O n� a ser removido, "aux", n�o tem filho � esquerda
        	transplant(aux, aux.getFilhoDireito() );
        }
        else if( aux.getFilhoDireito() == null ){	// -> O n� a ser removido, "aux", n�o tem filho � direita
        	transplant(aux, aux.getFilhoEsquerdo() );
        }
        else{
        	
        	No temporario = aux;
        	
        	while( temporario.getFilhoEsquerdo() != null ){
        		temporario = temporario.getFilhoEsquerdo();
        	}
        	
        	if(temporario.getPai() != aux) {
        		transplant(temporario, temporario.getFilhoDireito() );
        		temporario.setFilhoDireito( aux.getFilhoDireito() );
        		temporario.getPai().setFilhoDireito(temporario);
        	}
        	
        	transplant(aux, temporario);
        	temporario.setFilhoEsquerdo(aux.getFilhoEsquerdo() );
        	temporario.getPai().setFilhoEsquerdo(temporario);
        	
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
	private void inOrdem(No x){
		
		if(x != null) {
			
			inOrdem( x.getFilhoEsquerdo() );
			System.out.print( x.getChave() + " " );
			inOrdem( x.getFilhoDireito() );
			
		}
		
	}
	
	/**
     * Substitui uma sub�rvore como um filho de seu pai por outra sub�rvore
     * @param   u 	N� que ser� substitu�do pelo n� v
     * @param   v 	N� que substituir� o n� u
     */
	private void transplant(No u, No v) {
		if( u.getPai() == null ){ // -> Caso em que ser� removida a raiz por isso "v" ser� a nova raiz 		
				this.raiz = v;
	    }
        else if( u == u.getPai().getFilhoEsquerdo() ){ /// "u" � o filho � esquerda
          u.getPai().setFilhoEsquerdo(v);
        }
        else{ /// "u" � o filho � direita
          u.getPai().setFilhoDireito(v);
        }
        if(v != null){ /// J� que foi movido um filho n�o nulo, falta dizer quem � o pai dele
          v.setPai( u.getPai() );
        }
	}
			
}



