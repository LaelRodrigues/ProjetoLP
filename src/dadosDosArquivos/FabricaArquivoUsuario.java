package dadosDosArquivos;

public class FabricaArquivoUsuario implements FabricaDeManipulacaoArquivo{

	@Override
	public TipoManipulacaoArquivo criaTipoManipulacaoArquivo() {
		return new ArquivoUsuario();
	}

	
	
}
