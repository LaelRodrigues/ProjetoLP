package arvoreBinariaDeBusca;

import classes.Usuario;

/**
 * Representa uma árvore de busca binária (ABB) 
 * @see     NodeABB
 * @see		No
 * @author  Samuel Lucas de Moura Ferino
 * @since   05.06.2018
 * @version 0.0.1
 */
public class ABB {

    // -> ATRIBUTOS
    
    private NoABB raiz;  // -> Nó raiz da ABB
    private int quantidadeDeNos;	// -> Quantidade de nó que compõem a ABB
    
    // -> MÉTODOS
    
    /**
     * Construtor padrão
     */
    public ABB(){
        this.raiz = new NoABB();
        this.quantidadeDeNos = 0;
    }
    
    /**
     * Método get do atributo raiz
     * @return Raiz da árvore
     */
    public NoABB getRaiz(){ 
    	return this.raiz; 
    }

    /**
     * Método get do atributo quantidadeDeNos
     * @return Quantidade de nós que compõem a árvore
     */
    public int getQuantidadeDeNos(){ 
    	return this.quantidadeDeNos; 
    }
    
    /**
     * Buscando o nó com a chave correspondente entrada - O(log n)
     * @param usuario Usuário a ser buscado na ABB
     * @return True caso tenha encontrado algum nó com a correspondente chave senão false
     */
    public boolean busca(Usuario usuario){
    	
    	if(this.quantidadeDeNos == 0) { // -> A árvore é vazia
    		return false;
    	}
    	
    	// -> Nós auxiliares usados na busca
    	NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null && aux.getUsuario().compareTo(usuario) != 0 ){     

            auxPai = aux;

            if( usuario.compareTo( aux.getUsuario() ) == 1 ){ 	// -> Procurando na subárvore direita
                aux = aux.getDireito();
            }
            else{							// -> Procurando na subárvore esquerda
                aux = aux.getEsquerdo();
            }    
            
        }
    	
    	if( aux != null) {
    		return true;
    	}

    	return false;
    	
    }
    
    /**
     * Buscando o nó com a chave correspondente entrada - O(log n)
     * @param usuario Usuário a ser buscado na ABB
     * @return Usuario se existir ou null senão
     */
    public Usuario buscaLocal(Usuario usuario) throws NullPointerException {
    	
    	if(this.quantidadeDeNos == 0) { // -> A árvore é vazia
    		return null;
    	}
    	
    	// -> Nós auxiliares usados na busca
    	NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null && aux.getUsuario().compareTo(usuario) != 0 ){     

            auxPai = aux;

            if( usuario.compareTo( aux.getUsuario() ) == 1 ){ 	// -> Procurando na subárvore direita
                aux = aux.getDireito();
            }
            else{							// -> Procurando na subárvore esquerda
                aux = aux.getEsquerdo();
            }    
            
        }
    	
    	if( aux != null) {
    		return aux.getUsuario();
    	}

    	return null;
    	
    }
    
    /**
     * Insere um nó na ABB caso ele não exista previamente 
     * @param usuario Usuário a ser adicionado à ABB
     * @return True caso seja inserido com sucesso senão false
     */
    public boolean insere(Usuario usuario){
    	
    	if(this.quantidadeDeNos == 0) { // -> Primeira inserção na ABB
    	
    		if( this.raiz == null) {
    			this.raiz = new NoABB();
    		}
    		
    		this.raiz.setUsuario(usuario);
    		++this.quantidadeDeNos;
    		return true;
    	}
    	
        if( busca(usuario) == true ){	// -> Nó já existe na ABB
        	return false;
        }
        
        NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( aux != null ){     // -> BUSCANDO LOCAL ONDE O NÓ SERÁ INSERIDO E ARMAZENANDO NA VARIÁVEL "auxPai"
        	
        	auxPai = aux;
        	
            if( usuario.compareTo(aux.getUsuario()) == 1 ){
                aux = aux.getDireito();
            }
            else{
                aux = aux.getEsquerdo();
            }    

        }
        
        NoABB novoNo = new NoABB(usuario);
        
        if( usuario.compareTo(auxPai.getUsuario() ) == 1){   // -> É o filho direito de "auxPai" 
        	auxPai.setDireito(novoNo);
        }
        else{   						// -> É o filho esquerdo de "auxPai"
        	auxPai.setEsquerdo(novoNo);
        }    
        
        ++this.quantidadeDeNos;
        return true;
    
    }
    
    /**
     * Remove um nó na ABB caso ele exista previamente 
     * @param usuario	Usuário a ser excluído
     * @return True caso seja removido com sucesso senão false
     */
	public boolean remove(Usuario usuario){
		
		if(this.quantidadeDeNos == 0 ){  // -> ABB vazia	
			return false;
		}
		if( busca(usuario) == false ){  // -> Nó com chave correspondente não encontrado
			return false;
		}

        NoABB aux = this.raiz;
        NoABB auxPai = null;
        
        while( usuario.compareTo(aux.getUsuario()) != 0 ){     // -> BUSCANDO LOCAL ONDE DO NÓ QUE SERÁ  E ARMAZENANDO NA VARIÁVEL "auxPai"
        	
        	auxPai = aux;
        	
            if( usuario.compareTo(aux.getUsuario()) == 1 ){
                aux = aux.getDireito();
            }
            else{
                aux = aux.getEsquerdo();
            }    

        }
		
        if( aux.getEsquerdo() == null ){	// -> O nó a ser removido, "aux", não tem filho à esquerda
        	transplant(aux, aux.getDireito() );
        }
        else if( aux.getDireito() == null ){	// -> O nó a ser removido, "aux", não tem filho à direita
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
	
	// ->     **MÉTODOS PRIVADOS**
	
	/**
	 * Percorre as subárvores de x em InOrdem
	 * @param x	Nó que a partir do qual será feito o percorrimento
	 */
	private void inOrdem(NoABB x){
		
		if(x != null) {
			
			inOrdem( x.getEsquerdo() );
			System.out.println( x.getUsuario().getId() + " " + x.getUsuario().getNome() );
			inOrdem( x.getDireito() );
			
		}
		
	}
	
	/**
     * Substitui uma subárvore como um filho de seu pai por outra subárvore
     * @param   u 	Nó que será substituído pelo nó v
     * @param   v 	Nó que substituirá o nó u
     */
	private void transplant(NoABB u, NoABB v) {
		if( u.getPai() == null ){ // -> Caso em que será removida a raiz por isso "v" será a nova raiz 		
				this.raiz = v;
	    }
        else if( u == u.getPai().getEsquerdo() ){ /// "u" é o filho à esquerda
          u.getPai().setEsquerdo(v);
        }
        else{ /// "u" é o filho à direita
          u.getPai().setDireito(v);
        }
        if(v != null){ /// Já que foi movido um filho não nulo, falta dizer quem é o pai dele
          v.setPai( u.getPai() );
        }
	}
			
}



