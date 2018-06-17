package dadosDosArquivos;

import classes.Usuario;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Realiza a manipulacao de arquivo relacionada a classe usuario
 * @see		Usuario
 * @see 	TipoManipulacaoArquivo
 * @author 	Samuel Lucas de Moura Ferino
 * @since 	16.06.2018
 * @version 0.1.0
 */
public class ArquivoUsuario extends TipoManipulacaoArquivo{

	private ArrayList<Usuario> listaUsuarios; // -> CONTEM TODOS OS USUARIOS CADASTRADOS **ATUALMENTE**
	private HashSet<Usuario> usuarios;  // -> PREVINE QUE NAO SEJAM ADICIONADO USUARIOS REPETIDOS
	
	/**
	 * Construtor padrao
	 */
	public ArquivoUsuario() {
		
		super();
		
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuarios = new HashSet<Usuario>();
		
		lerArquivo("usuarios.txt");
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
			
			if( this.usuarios.add( new Usuario(id, nome, senha, Boolean.getBoolean(vip) ) ) ) {  // -> SE JA NAO TIVER SIDO ADICIONADO NO CONJUNTO, ADICIONA-O 
				listaUsuarios.add( new Usuario(id, nome, senha, Boolean.getBoolean(vip) ) );
			}
		}
	}
	/**
	 * Converte os atributos de todos os usuarios em uma string usando os seguintes separadores: ';', ':' e '\n' 
	 * @return 	String contendo todos os atributos de todos os usuarios cadastrados   
	 */
	protected String atributosConvertidosEmString() {
		
		String dadosDeTodosUsuarios = new String("");
		
		for(Usuario i: this.listaUsuarios) {
			
			dadosDeTodosUsuarios += "id:";
			dadosDeTodosUsuarios += i.getId();
			dadosDeTodosUsuarios += ";";
			dadosDeTodosUsuarios += "nome:"; 
			dadosDeTodosUsuarios += i.getNome(); 
			dadosDeTodosUsuarios += ";"; 
			dadosDeTodosUsuarios += "senha:";
			dadosDeTodosUsuarios += i.getSenha(); 
			dadosDeTodosUsuarios += ";";
			dadosDeTodosUsuarios += "vip:"; 
			dadosDeTodosUsuarios += i.isVip();
			dadosDeTodosUsuarios += "\n";
		
		}
		
		return dadosDeTodosUsuarios;
	}
	
	/**
	 * Atualiza o arquivo usuario.txt que contém os antigas usuarios cadastrados
	 * @return	True se o arquivo usuarios.txt foi atualizado corretamente senao false
	 */
	@Override
	public boolean criaOuAtualiza() {		
		return salvarArquivo("usuarios", atributosConvertidosEmString() );	
	} 
		
	/**
	 * Metodo get do atributo listaUsuarios
	 * @return Lista de todos os usuarios cadastrados
	 */
	public ArrayList<Usuario> getListaUsuarios(){
		return this.listaUsuarios;
	}
	
}	