package arvoreTrie;

/**
 * Representa uma Trie (�rvore digital)
 * @author  Samuel Lucas de Moura Ferino
 * @since   21.06.2018
 * @version 0.0.1
 */
public class Trie {

    /**
     * Representa um n� da Trie
     */
    public static class NoTrie{

        // -> public char caractere;  N�o � necess�rio pois a posicao do vetor pode simbolizar o caractere
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

    private NoTrie raiz; // -> N� raiz  da ��rvore Trie

    /**
     * Instancia o n� (Construtor padrao)
     */
    public Trie(){
        raiz = new NoTrie();
    }

    /**
     * Busca uma palavra na Trie
     * @param   palavra     Palavra a ser busca na Trie
     * @return  {@code true} se for encontrada com sucesso sen�o {@code false} 
     */
    public boolean busca( String palavra ){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra min�scula
        
        NoTrie noAuxiliar = this.raiz;

        for(int i = 0; i < palavra.length(); ++i){

            if( noAuxiliar.filhos[ palavra.charAt(i) - 'a' ] == null ){  // -> N�o h� n� correspondente
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
     * @return  {@code true} se for adicionado com sucesso sen�o {@code false} 
     */
    public boolean insere( String palavra){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra min�scula
        
        if( busca(palavra) == true ) {  // -> Caso em que a palavra j� foi adicionada
            return false;
        }

        NoTrie noAuxiliar = this.raiz;

        for( int i = 0; i < palavra.length(); ++i ){

            if( noAuxiliar.filhos[ palavra.charAt(i) - 'a'] == null ){  // -> Caso em que o n� n�o existe, adiciona-o
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
     * @return  {@code true} se for removido com sucesso sen�o {@code false} 
     */
    public boolean remove( String palavra ){
        
        palavra = palavra.toLowerCase(); // -> Tornando a palavra min�scula
        
        if( busca( palavra ) == false ){ // -> A palavra n�o est� contida na Trie
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
       
        noAuxiliarTerminal.filhos[indiceDepoisDoTerminal] = null; // -> Posso fazer at� aqui j� que o java possui Garbage collection

        return true;
    }
    
    /**
     * Testando os m�todos
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