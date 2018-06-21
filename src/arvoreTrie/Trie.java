package arvoreTrie;

/**
 * Representa uma Trie (árvore digital)
 * @author  Samuel Lucas de Moura Ferino
 * @since   21.06.2018
 * @version 0.0.1
 */
public class Trie {

    /**
     * Representa um nó da Trie
     */
    public static class NoTrie{

        // -> public char caractere;  Não é necessário pois a posicao do vetor pode simbolizar o caractere
        public boolean ehFimDePalavra; // -> Indica se o caminho formou uma palavra
        public NoTrie filhos[]; // -> Possiveis proximos caracteres

        /**
         * Inicializa o no raiz (Construtor padrao)
         */
        public NoTrie(){

            ehFimDePalavra = false;
            filhos = new NoTrie[26];

            for(int i = 0; i < 26; ++i){  // -> Setando para null
                filhos[i] = null;
            }

        }

    }

    private NoTrie raiz; // -> Nó raiz  da áárvore Trie

    /**
     * Instancia o nó (Construtor padrao)
     */
    public Trie(){
        raiz = new NoTrie();
    }

    /**
     * Busca uma palavra na Trie
     * @param   palavra     Palavra a ser busca na Trie
     * @return  {@code true} se for encontrada com sucesso senão {@code false} 
     */
    public boolean busca( String palavra ){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra minúscula
        
        NoTrie noAuxiliar = this.raiz;

        for(int i = 0; i < palavra.length(); ++i){

            if( noAuxiliar.filhos[ palavra.charAt(i) - 'a' ] == null ){  // -> Não há nó correspondente
                return false;
            }

            noAuxiliar = noAuxiliar.filhos[palavra.charAt(i) - 'a' ];

        }

        if( ( noAuxiliar != null ) && ( noAuxiliar.ehFimDePalavra == true ) ){  // -> Se o no existe e ele for um no com o atributo fim de palavra ativado, foi encontrado o no  
            return true;
        }

        return false;  // -> Ou noAuxiliar ficou nulo ou nao eh um no com o atributo fim de palavra ativado

    }

    /**
     * Insere uma palavra na Trie
     * @param   palavra     Palavra a ser inserida na Trie
     * @return  {@code true} se for adicionado com sucesso senão {@code false} 
     */
    public boolean insere( String palavra){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra minúscula
        
        if( busca(palavra) == true ) {  // -> Caso em que a palavra já foi adicionada
            return false;
        }

        NoTrie noAuxiliar = this.raiz;

        for( int i = 0; i < palavra.length(); ++i ){

            if( noAuxiliar.filhos[ palavra.charAt(i) - 'a'] == null ){  // -> Caso em que o nó não existe, adiciona-o
                noAuxiliar.filhos[ palavra.charAt(i) - 'a'] = new NoTrie();
            }
            
            noAuxiliar = noAuxiliar.filhos[ palavra.charAt(i) - 'a'];
        
        } 

        noAuxiliar.ehFimDePalavra = true;

        return true;

    }

    /**
     * Remove uma palavra na Trie
     * @param   palavra     Palavra a ser removida da Trie
     * @return  {@code true} se for removido com sucesso senão {@code false} 
     */
    public boolean remove( String palavra ){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra minúscula
        
        if( busca( palavra ) == false ){ // -> A palavra não está contida na Trie
            return false;
        }        

        NoTrie noAuxiliar = this.raiz;
        NoTrie noAuxiliarTerminal = noAuxiliar;
        int indiceDepoisDoTerminal = palavra.charAt(0) - 'a';
        
        for( int i = 0; i < palavra.length(); ++i ){

            if( noAuxiliar.ehFimDePalavra == true ){

                noAuxiliarTerminal = noAuxiliar;
                indiceDepoisDoTerminal = palavra.charAt(i) - 'a';
        
            }

            noAuxiliar = noAuxiliar.filhos[ palavra.charAt(i) - 'a' ];

        }
       
        noAuxiliarTerminal.filhos[indiceDepoisDoTerminal] = null; // -> Posso fazer até aqui já que o java possui Garbage collection

        return true;
    }
    
    /**
     * Testando os métodos
     */
    public void main(String[] args) {
        
        // Input keys (use only 'a' through 'z' and lower case)
          String chaves[] = {"The", "a", "there", "answer", "any", "by", "bye", "their"};
        
          String mensagemDeSaida[] = {"Nao esta presente na trie", "Esta presente trie"};
        
          for (int i = 0; i < chaves.length ; i++){
              insere(chaves[i]);
          }    
        
          remove("the");

          // -> Buscando por diferentes chaves
          if( busca("the") == true)
              System.out.println("the --- " + mensagemDeSaida[1]);
          else System.out.println("the --- " + mensagemDeSaida[0]);
           
          if( busca("these") == true)
              System.out.println("these --- " + mensagemDeSaida[1]);
          else System.out.println("these --- " + mensagemDeSaida[0]);
           
          if( busca("their") == true)
              System.out.println("their --- " + mensagemDeSaida[1]);
          else System.out.println("their --- " + mensagemDeSaida[0]);
           
          if( busca("thaw") == true)
              System.out.println("thaw --- " + mensagemDeSaida[1]);
          else System.out.println("thaw --- " + mensagemDeSaida[0]);

          if( busca("a") == true)
              System.out.println("a --- " + mensagemDeSaida[1]);
          else System.out.println("a --- " + mensagemDeSaida[0]);
  
      }
    
}    