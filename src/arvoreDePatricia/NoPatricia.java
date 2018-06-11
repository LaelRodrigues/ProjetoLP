package arvoreDePatricia;

import no.No;

/**
 * Representa um n� da �rvore de Patr�cia
 * @see		No
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	09.06.2018
 * @version 0.0.3
 */
public class NoPatricia extends No{
	
	// -> ATRIBUTOS
		
	private char letra;
	private boolean fimDePalavra;
	
	// -> M�TODOS 
	
	/**
	 * Construtor padr�o
	 */
	public NoPatricia(){
		
		super();
		
		this.letra = 0;
		this.fimDePalavra = false;

	}

	/**
	 * Construtor parametrizado
	 * @param letra		Letra atual
	 * @param fimDePalavra	Indica se foi formada palavra v�lida
	 */
	public NoPatricia( char letra, boolean fimDePalavra){
		
		super();		
		this.letra = 0;
		this.fimDePalavra = fimDePalavra;
	
	}
		
	/**
	 * Construtor parametrizado
	 * @param pai 		N� pai
	 * @param esquerdo	N� filho � esquerda
	 * @param direito	N� filho � direita
	 * @param letra		Letra atual
	 * @param fimDePalavra	Indica se foi formada palavra v�lida
	 */
	public NoPatricia(NoPatricia pai, NoPatricia esquerdo, NoPatricia direito, char letra, boolean fimDePalavra){
		
		super(pai, esquerdo, direito);		
		this.letra = 0;
		this.fimDePalavra = fimDePalavra;
	
	}
	
	/**
	 * M�todo get do atributo letra
	 * @return	Caractere atual
	 */
	public char getLetra(){
		return this.letra;
	}
	
	/**
	 * M�todo get do atributo letra
	 * @param	letra Caractere atual
	 */
	public void setLetra(char letra){ 
		this.letra = letra; 
	}
	
	/**
	 * M�todo get do atributo fimDePalavra
	 * @param Indica se o caminho pela �rvore formou uma palavra v�lida 
	 */
	public boolean getFimDePalavra() {
		return this.fimDePalavra;
	}
	
	/**
	 * M�todo set do atributo fimDePalavra
	 * @param fimDePalavra 	Indica se o caminho pela �rvore formou uma palavra v�lida 
	 */
	public void setFimDePalavra(boolean fimDePalavra){
		this.fimDePalavra = fimDePalavra;
	}
	
	/**
	 * M�todo get do atributo pai da super classe
	 * @return	N� pai
	 */
	public NoPatricia getPai(){
		return (NoPatricia)getPai(); 
	}
	
	/**
	 * M�todo set do atributo pai da super classe
	 * @return	pai	N� pai
	 */
	public void setPai( NoPatricia pai){
		setPai(pai); 
	}	
	
	/**
	 * M�todo get do atributo esquerdo da super classe
	 * @return	N� filho � esquerda
	 */
	public NoPatricia getEsquerdo(){
		return (NoPatricia)getFilhoEsquerdo(); 
	}
	
	/**
	 * M�todo set do atributo esquerdo da super classe
	 * @return	esquerdo	N� filho � esquerda
	 */
	public void setEsquerdo( NoPatricia esquerdo){
		setFilhoEsquerdo(esquerdo); 
	}
	/**
	 * M�todo get do atributo direito da super classe
	 * @return	N� filho � direita
	 */
	public NoPatricia getDireito(){
		return (NoPatricia)getFilhoDireito(); 
	}
	
	/**
	 * M�todo set do atributo direito da super classe
	 * @return	esquerdo	N� filho � direita
	 */
	public void setDireito( NoPatricia direito){
		setFilhoDireito(direito); 
	}
}

