package dadosDosArquivos;


import classes.Usuario;
import java.util.ArrayList;
import java.util.HashSet;

public class ArquivoUsuario extends TipoManipulacaoArquivo{

	private ArrayList<Usuario> listaUsuarios;
	private HashSet<Usuario> usuarios;  // -> PREVINE QUE NAO SEJAM ADICIONADO USUARIOS REPETIDOS
	
	public ArquivoUsuario() {
		super();
	}
	
	public ArquivoUsuario(String nomeArquivo) {
		
		super();
		
		this.listaUsuarios = new ArrayList<Usuario>();
		this.usuarios = new HashSet<Usuario>();
		
		this.conteudoArquivo = lerArquivo(nomeArquivo);
		tratamentoStringLeitura(conteudoArquivo);
	}
	
	/**
	 * Lembre-se que no arquivo estara assim:
	 * id:12;nome:Lucas;senha:vamosla;vip:false\n
	 * @param	strings	String a ser tratada
	 */
	@Override
	protected void tratamentoStringLeitura(String strings) {
		
		String id = new String();
		String nome = new String();
		String senha = new String();
		String vip = new String();
		
		
		String usuariosLinhaPorLinha[] = strings.split("\n");
		
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
	 * Metodo get do atributo listaUsuarios
	 * @return
	 */
	public ArrayList<Usuario> getListaUsuarios(){
		return this.listaUsuarios;
	}

	@Override
    protected void tratamentoStringEscrita(String strings){
		
	}

	
}	

