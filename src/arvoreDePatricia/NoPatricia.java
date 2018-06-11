package arvoreDePatricia;

import no.No;

/**
 * Representa um nó da árvore de Patrícia
 * @see		No
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	09.06.2018
 * @version 0.0.3
 */
public class NoPatricia extends No{
	
	// -> ATRIBUTOS
		
	private char letra;
	private boolean fimDePalavra;
	
	// -> MÉTODOS 
	
	/**
	 * Construtor padrão
	 */
	public NoPatricia(){
		
		super();
		
		this.letra = 0;
		this.fimDePalavra = false;

	}

	/**
	 * Construtor parametrizado
	 * @param letra		Letra atual
	 * @param fimDePalavra	Indica se foi formada palavra válida
	 */
	public NoPatricia( char letra, boolean fimDePalavra){
		
		super();		
		this.letra = 0;
		this.fimDePalavra = fimDePalavra;
	
	}
		
	/**
	 * Construtor parametrizado
	 * @param pai 		Nó pai
	 * @param esquerdo	Nó filho à esquerda
	 * @param direito	Nó filho à direita
	 * @param letra		Letra atual
	 * @param fimDePalavra	Indica se foi formada palavra válida
	 */
	public NoPatricia(NoPatricia pai, NoPatricia esquerdo, NoPatricia direito, char letra, boolean fimDePalavra){
		
		super(pai, esquerdo, direito);		
		this.letra = 0;
		this.fimDePalavra = fimDePalavra;
	
	}
	
	/**
	 * Método get do atributo letra
	 * @return	Caractere atual
	 */
	public char getLetra(){
		return this.letra;
	}
	
	/**
	 * Método get do atributo letra
	 * @param	letra Caractere atual
	 */
	public void setLetra(char letra){ 
		this.letra = letra; 
	}
	
	/**
	 * Método get do atributo fimDePalavra
	 * @param Indica se o caminho pela árvore formou uma palavra válida 
	 */
	public boolean getFimDePalavra() {
		return this.fimDePalavra;
	}
	
	/**
	 * Método set do atributo fimDePalavra
	 * @param fimDePalavra 	Indica se o caminho pela árvore formou uma palavra válida 
	 */
	public void setFimDePalavra(boolean fimDePalavra){
		this.fimDePalavra = fimDePalavra;
	}
	
	/**
	 * Método get do atributo pai da super classe
	 * @return	Nó pai
	 */
	public NoPatricia getPai(){
		return (NoPatricia)getPai(); 
	}
	
	/**
	 * Método set do atributo pai da super classe
	 * @return	pai	Nó pai
	 */
	public void setPai( NoPatricia pai){
		setPai(pai); 
	}	
	
	/**
	 * Método get do atributo esquerdo da super classe
	 * @return	Nó filho à esquerda
	 */
	public NoPatricia getEsquerdo(){
		return (NoPatricia)getFilhoEsquerdo(); 
	}
	
	/**
	 * Método set do atributo esquerdo da super classe
	 * @return	esquerdo	Nó filho à esquerda
	 */
	public void setEsquerdo( NoPatricia esquerdo){
		setFilhoEsquerdo(esquerdo); 
	}
	/**
	 * Método get do atributo direito da super classe
	 * @return	Nó filho à direita
	 */
	public NoPatricia getDireito(){
		return (NoPatricia)getFilhoDireito(); 
	}
	
	/**
	 * Método set do atributo direito da super classe
	 * @return	esquerdo	Nó filho à direita
	 */
	public void setDireito( NoPatricia direito){
		setFilhoDireito(direito); 
	}
}

