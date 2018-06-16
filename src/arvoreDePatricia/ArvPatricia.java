package arvoreDePatricia;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Representa uma arvore de patricia
 * @see 	NoPatricia
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	16.06.2018
 * @version 0.0.1
 */
public class ArvPatricia {
	
	private HashSet<Character> letrasIniciaisAdicionadas;  // -> USANDO NA INSERCAO PARA GARANTIR QUE NAO SERA ADICIONADO DUAS VEZES O NO INCIAL COM A MESMA LETRA 
	private ArrayList<NoPatricia> raizLetrasIniciais;
	
	/**
	 * Construtor padrao
	 */
	public ArvPatricia() {
		letrasIniciaisAdicionadas = new HashSet<Character>();
		raizLetrasIniciais = new ArrayList<NoPatricia>();
	}
	
	/**
	 * Busca na arvore se o nome da musica existe verificando caractere por caractere
	 * @param nomeMusica	Nome da musica a ser buscada
	 * @return	True se for encontrada senao false
	 */
	public boolean busca(String nomeMusica) {
		
		if( !( letrasIniciaisAdicionadas.contains(nomeMusica.charAt(0) ) ) )  { // -> CASO EM QUE NAO EXISTE PALAVRA COM LETRA INICIAL CORRESPONDENTE
			return false;
		}
		
		NoPatricia nohAlvo = new NoPatricia();
		
		for( NoPatricia i: raizLetrasIniciais){   // -> ENCONTRANDO O NOH INICIAL NO VETOR/LISTA 
			if( i.getLetra() == nomeMusica.charAt(0)){
				nohAlvo = i;
			}
		}
		
		if( nomeMusica.length() == 1 ){
			
			if( nohAlvo.getFimDePalavra() == false ){
				return false;
					
			}
			
			return true; // -> O NOME DA MUSICA EH FORMADO POR UMA UNICA LETRA

		}
		
		
		
		
		
		return false;
	}
	
	public boolean insere(String nomeMusica){
	
		if( busca(nomeMusica) == true) {	// CASO EM QUE JA EXISTE A PALAVRA (NOME DA MUSICA)
			return false;
		}		
		
		
		
		return true;
	}
	
}
