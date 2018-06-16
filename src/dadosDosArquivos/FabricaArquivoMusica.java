package dadosDosArquivos;

public class FabricaArquivoMusica implements FabricaDeManipulacaoArquivo{

	@Override
	public TipoManipulacaoArquivo criaTipoManipulacaoArquivo() {
		return new ArquivoMusica();
	}

}
