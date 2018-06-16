package dadosDosArquivos;

public class FabricaArquivoPlaylist implements FabricaDeManipulacaoArquivo{

	@Override
	public TipoManipulacaoArquivo criaTipoManipulacaoArquivo() {
		return new ArquivoPlaylist();
	}

}
