package arvoreBinariaDeBusca;


/**
 * Representa uma árvore de busca binária (ABB) 
 * @see     Node
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018
 * @version 0.0.1
 */
public class ABB {

    // -> ATRIBUTOS
    
    private No raiz;  // -> Nó raiz da ABB
    private int quantidadeDeNos;	// -> Quantidade de nó que compõem a ABB
    
    // -> MÉTODOS
    
    /**
     * Construtor padrão
     */
    public ABB(){
        this.raiz = new No();
        this.quantidadeDeNos = 0;
    }
    
    /**
     * Método get do atributo raiz
     * @return Raiz da árvore
     */
    public No getRaiz(){ return this.raiz; }

    /**
     * Método get do atributo quantidadeDeNos
     * @return Quantidade de nós que compõem a árvore
     */
    public int getQuantidadeDeNos(){ return this.quantidadeDeNos; }
    
    /**
     * Buscando o nó com a chave correspondente entrada - O(log n)
     * @param value Chave a ser buscada na ABB
     * @return True caso tenha encontrado algum nó com a correspondente chave senão false
     */
    public boolean busca(int value) {
    	
    	if(this.quantidadeDeNos == 0) { // -> A árvore é vazia
    		return false;
    	}
    	
    	// -> Nós auxiliares usados na busca
    	No aux = this.raiz;
        No auxPai = null;
        
        while( aux != null && aux.getChave() != value ){     

            auxPai = aux;

            if( value > aux.getChave() ){ 	// -> Procurando na subárvore direita
                aux = aux.getFilhoDireito();
            }
            else{							// -> Procurando na subárvore esquerda
                aux = aux.getFilhoEsquerdo();
            }    
            
        }
    	
    	if( aux != null) {
    		return true;
    	}

    	return false;
    	
    }
    
    /**
     * Insere um nó na ABB caso ele não exista previamente 
     * @param value Conteúdo da chave do nó a ser adicionado
     * @return True caso seja inserido com sucesso senão false
     */
    public boolean insere(int value){
    	
    	if(this.quantidadeDeNos == 0) { // -> Primeira inserção na ABB
    	
    		if( this.raiz == null) {
    			this.raiz = new No();
    		}
    		
    		this.raiz.setChave(value);
    		++this.quantidadeDeNos;
    		return true;
    	}
    	
        if( busca(value) == true ){	// -> Nó já existe na ABB
        	return false;
        }
        
        No aux = this.raiz;
        No auxPai = null;
        
        while( aux != null ){     // -> BUSCANDO LOCAL ONDE O NÓ SERÁ INSERIDO E ARMAZENANDO NA VARIÁVEL "auxPai"
        	
        	auxPai = aux;
        	
            if( value > aux.getChave() ){
                aux = aux.getFilhoDireito();
            }
            else{
                aux = aux.getFilhoEsquerdo();
            }    

        }
        
        No novoNo = new No(value);
        
        if( value > auxPai.getChave() ){   // -> É o filho direito de "auxPai" 
        	auxPai.setFilhoDireito(novoNo);
        }
        else{   						// -> É o filho esquerdo de "auxPai"
        	auxPai.setFilhoEsquerdo(novoNo);
        }    
        
        ++this.quantidadeDeNos;
        return true;
    
    }
    
    /**
     * Remove um nó na ABB caso ele exista previamente 
     * @param value	Chave a ser excluída
     * @return True caso seja removido com sucesso senão false
     */
	public boolean remove(int value){
		
		if(this.quantidadeDeNos == 0 ){  // -> ABB vazia	
			return false;
		}
		if( busca(value) == false ){  // -> Nó com chave correspondente não encontrado
			return false;
		}

        No aux = this.raiz;
        No auxPai = null;
        
        while( aux.getChave() != value ){     // -> BUSCANDO LOCAL ONDE DO NÓ QUE SERÁ  E ARMAZENANDO NA VARIÁVEL "auxPai"
        	
        	auxPai = aux;
        	
            if( value > aux.getChave() ){
                aux = aux.getFilhoDireito();
            }
            else{
                aux = aux.getFilhoEsquerdo();
            }    

        }
		
        if( aux.getFilhoEsquerdo() == null ){	// -> O nó a ser removido, "aux", não tem filho à esquerda
        	transplant(aux, aux.getFilhoDireito() );
        }
        else if( aux.getFilhoDireito() == null ){	// -> O nó a ser removido, "aux", não tem filho à direita
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
	
	// ->     **MÉTODOS PRIVADOS**
	
	/**
	 * Percorre as subárvores de x em InOrdem
	 * @param x	Nó que a partir do qual será feito o percorrimento
	 */
	private void inOrdem(No x){
		
		if(x != null) {
			
			inOrdem( x.getFilhoEsquerdo() );
			System.out.print( x.getChave() + " " );
			inOrdem( x.getFilhoDireito() );
			
		}
		
	}
	
	/**
     * Substitui uma subárvore como um filho de seu pai por outra subárvore
     * @param   u 	Nó que será substituído pelo nó v
     * @param   v 	Nó que substituirá o nó u
     */
	private void transplant(No u, No v) {
		if( u.getPai() == null ){ // -> Caso em que será removida a raiz por isso "v" será a nova raiz 		
				this.raiz = v;
	    }
        else if( u == u.getPai().getFilhoEsquerdo() ){ /// "u" é o filho à esquerda
          u.getPai().setFilhoEsquerdo(v);
        }
        else{ /// "u" é o filho à direita
          u.getPai().setFilhoDireito(v);
        }
        if(v != null){ /// Já que foi movido um filho não nulo, falta dizer quem é o pai dele
          v.setPai( u.getPai() );
        }
	}
			
}



