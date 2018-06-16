package arvoreDePatricia;

import java.util.HashSet;

/**
 * Representa uma arvore de patricia
 * @see 	NoPatricia
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	16.06.2018
 * @version 0.0.1
 */
public class ArvPatricia {
	
	private HashSet<NoPatricia> raizLetrasIniciais;
	
	/**
	 * Construtor padrao
	 */
	public ArvPatricia() {
		raizLetrasIniciais = new HashSet<NoPatricia>();
	}
	
	/**
	 * Busca na arvore se o nome da musica existe
	 * @param nomeMusica	Nome da musica a ser buscada
	 * @return	True se for encontrada senao false
	 */
	public boolean busca(String nomeMusica) {
		if( ! raizLetrasIniciais.contains(new NoPatricia(nomeMusica.charAt(0), true) ) || 
				!raizLetrasIniciais.contains(new NoPatricia(nomeMusica.charAt(0), false) )) { // -> CASO EM QUE NAO EXISTE NO COM LETRA
			return false;
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
