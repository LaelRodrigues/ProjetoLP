package arvoreDePatricia;

/**
 * Representa um nó da árvore de Patrícia
 * @see		No
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	09.06.2018
 * @version 0.0.3
 */
public class NoPatricia {
	
	// -> ATRIBUTOS
		
	private String palavra;
	private int avancar;
	private NoPatricia filhos[];
	
	// -> MÉTODOS 
	
	/**
	 * Construtor padrão
	 */
	public NoPatricia(){
		
		super();
		
		this.compararCom = ' ';
		this.avancar = 1;

	}

	/**
	 * Construtor parametrizado
	 * @param compararCom		
	 * @param avancar	
	 */
	public NoPatricia( char compararCom, int avancar){
		
		super();
		this.compararCom = comparaCom;	
		this.avancar = avancar;
	
	}
		
	/**
	 * Construtor parametrizado
	 * @param pai 		Nó pai
	 * @param esquerdo	Nó filho à esquerda
	 * @param direito	Nó filho à direita
	 * @param letra		Letra atual
	 * @param fimDePalavra	Indica se foi formada palavra válida
	 */
	public NoPatricia(NoPatricia pai, NoPatricia esquerdo, NoPatricia direito, char compararCom, int avancar){
		
		super(pai, esquerdo, direito);		
		this.compararCom = compararCom;
		this.avancar = avancar;
	
	}
	
	/**
	 * Método get do atributo 	 
	 * @return	Caractere atual
	 */
	public char getComparaCom(){
		return this.CompararCom;
	}
	
	/**
	 * Método get do atributo 
	 * @param	
	 */
	public void setCompararCom(char CompararCom){ 
		this.compararCom = compararCom; 
	}
	
	/**
	 * Método get do atributo 
	 * @return 
	 */
	public boolean getAvancar() {
		return this.avancar;
	}
	
	/**
	 * Método set do atributo 
	 * @param  
	 */
	public void setAvancar(int avancar){
		this.avancar = avancar;
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

