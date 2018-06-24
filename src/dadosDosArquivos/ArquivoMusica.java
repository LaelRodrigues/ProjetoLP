package dadosDosArquivos;

import arvoreTrie.Trie;
import java.util.ArrayList;
import classes.Musica;

/**
 * Realiza a manipulacao de arquivo relacionada a classe musica
 * @see		Musica
 * @see 	TipoManipulacaoArquivo
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	24.06.2018
 * @version 0.1.0
 */
public class ArquivoMusica extends TipoManipulacaoArquivo {

	private Trie nomesMusicas;
	
	private ArrayList<Musica> listaMusicas;
	
	/**
	 * Construtor padrão
	 */
		public ArquivoMusica(){
		
		super();
		
		this.nomesMusicas = new Trie();
		this.listaMusicas = new ArrayList<Musica>();
		
		lerArquivo("./arquivos.txt/musicas.txt");
		tratamentoStringLeitura();
	}

	
	@Override
	protected void tratamentoStringLeitura() {

		String nome = new String();
		String caminho = new String();
		
		String musicasLinhaPorLinha[] = this.conteudoArquivo.split("\n");
		
		for(String i: musicasLinhaPorLinha){
			nome = i.split(";")[0].split(":")[1];
			caminho = i.split(";")[1].split(":")[1];
			
			listaMusicas.add( new Musica( nome, caminho ) );
			
		}
		
	}

	@Override
	protected String atributosConvertidosEmString() {
		
		String stringMusicas = new String();
		
		for(Musica musica: listaMusicas) {
			stringMusicas += musica.toString();
		}
		
		return stringMusicas;
	}
	
	/**
	 * Método get do atributo listaUsuarios
	 * @return Array contendo todas as músicas cadastradas
	 */
	public ArrayList<Musica> getListaMusicas(){
		return this.listaMusicas;
	}

	/**
	 * Método get do atributo nomesMusicas
	 * @return Trie contendo os nomes de todas as músicas cadastradas
	 */
	public Trie getNomesMusicas() {
		return nomesMusicas;
	}
	
	/**
	 * Adiciona música à lista de músicas cadastradas
	 * @param musica	Musica a ser cadastrada
	 * @return	{@code true} se foi adicionado com sucesso senão {@code false}
	 */
	public boolean add( Musica musica) {
		
		if ( nomesMusicas.insere( musica.getNome() ) == true ) {
			return	listaMusicas.add( musica  );
		}
		
		return false;
		
	}
	
	/**
	 * Atualiza o arquivo musicas.txt que contém as antigas musicas cadastradas
	 * @return	{@code true} se o arquivo musicas.txt foi atualizado corretamente senão {@code false}
	 */
	@Override
	public boolean criaOuAtualiza() {
		return salvarArquivo("./arquivos.txt/musicas", atributosConvertidosEmString() );	
	}
	

}
