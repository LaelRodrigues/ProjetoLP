package dadosDosArquivos;

import classes.Usuario;
import java.util.ArrayList;
import java.util.HashSet;
import arvoreBinariaDeBusca.ABB;

/**
 * Realiza a manipulacao de arquivo relacionada a classe usuario
 * @see		Usuario
 * @see 	TipoManipulacaoArquivo
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	16.06.2018
 * @version 0.1.0
 */
public class ArquivoUsuario extends TipoManipulacaoArquivo{

	private ABB listaUsuarios; // -> CONTEM TODOS OS USUARIOS CADASTRADOS **ATUALMENTE**
	
	/**
	 * Construtor padrao
	 */
	public ArquivoUsuario() {
		
		super();
		
		this.listaUsuarios = new ABB();
		
		lerArquivo("./arquivos.txt/usuarios.txt");
		tratamentoStringLeitura();
	}
	
	/**
	 * Trata a string que eh o conteudo do arquivo usuarios.txt e salva no vetor interno listaUsuarios
	 * Lembre-se que no arquivo estara assim: id:12;nome:Lucas;senha:vamosla;vip:false\n
	 * @param	strings	String a ser tratada
	 */
	@Override
	protected void tratamentoStringLeitura() {
		
		String id = new String();
		String nome = new String();
		String senha = new String();
		String vip = new String();
		
		
		String usuariosLinhaPorLinha[] = this.conteudoArquivo.split("\n");
		
		for(String i: usuariosLinhaPorLinha){
			id = i.split(";")[0].split(":")[1];
			nome = i.split(";")[1].split(":")[1];
			senha = i.split(";")[2].split(":")[1];
			vip = i.split(";")[3].split(":")[1];
			
			
			//vip = vip.substring(0, vip.length()-2); // -> RETIRANDO O "\n"
			
			listaUsuarios.insere( new Usuario(id, nome, senha,  Boolean.valueOf(vip) ) );
			
		}
	}
	/**
	 * Converte os atributos de todos os usuarios em uma string usando os seguintes separadores: ';', ':' e '\n' 
	 * @return 	String contendo todos os atributos de todos os usuarios cadastrados   
	 */
	protected String atributosConvertidosEmString() {
						
		return listaUsuarios.percorre();
	}
	
	/**
	 * Atualiza o arquivo usuario.txt que contém os antigas usuarios cadastrados
	 * @return	{@code true} se o arquivo usuarios.txt foi atualizado corretamente senao {@code false}
	 */
	@Override
	public boolean criaOuAtualiza() {	
		
		return salvarArquivo("./arquivos.txt/usuarios", atributosConvertidosEmString() );	
	} 
		
	/**
	 * Metodo get do atributo listaUsuarios
	 * @return Lista de todos os usuarios cadastrados
	 */
	public ABB getListaUsuarios(){
		return this.listaUsuarios;
	}
	
	/**
	 * Adiciona usuario a lista de usuarios cadastrados
	 * @param usuario	Usuario a ser cadastrado
	 * @return	True se for adiiconado com sucesso senao false
	 */
	public boolean add( Usuario usuario) {
		
		return	listaUsuarios.insere( usuario  );
		
	}
	
	public static void main(String[] args) {
		
		ABB teste = new ABB();
		
		teste.insere(  new Usuario("usuario2", "Moura", "fea", true) );
		teste.insere(  new Usuario("usuario1", "Lucas", "sa", false) );
		
		System.out.println( teste.percorre() );
	
	}
	
}	