
package dadosDosArquivos;

// -> MANIPULAÇÃO DE ARQUIVO
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;

// -> CLASSE DE EXCEÇÃO (MANIPULAÇÃO DE ARQUIVO)
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Contêm os métodos de leitura e escrita de arquivo
 * @author  Samuel Lucas de Moura Ferino
 * @since   21.05.2018   
 * @version 0.0.6
 */
public abstract class TipoManipulacaoArquivo{

	protected String conteudoArquivo;
	
    protected void lerArquivo(String nomeDoArquivo) throws NullPointerException{
      
    	//String conteudo = new String("");
        
        try{

            BufferedReader buffReader = new BufferedReader(new FileReader( nomeDoArquivo ));
            String linha = new String();

            while( buffReader.ready() ){              // -> LENDO CADA LINHA  
                linha = buffReader.readLine();
                this.conteudoArquivo += linha + "\n";
            }
            
            buffReader.close();
          //  return conteudo;
        }
        catch(FileNotFoundException e){  // -> ARQUIVO NÃO EXISTE
            System.err.println( e.getMessage() );
            //return null;
        }  
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO

            System.err.println( e.getMessage() );
          //  return null;
        }

    }
    
    /**
     * Salva   
     * @param   nomeDoArquivo   Nome do arquivo no qual haverá a escrita
     * @return  True se a escrita for feita corretamente, senão false
     */
	protected boolean salvarArquivo(String nomeArquivo, String conteudoArquivo){
		
        try{

        	nomeArquivo += ".txt";
        	
		  FileWriter writer = new FileWriter(nomeArquivo);     
		
		  writer.write(this.conteudoArquivo);
		
		  writer.close();  
		
		  return true;

        }
        catch(FileNotFoundException e){   // -> ARQUIVO NÃO EXISTE
	        System.err.println( e.getMessage() );
	        return false;        
        }
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO
            System.err.println( e.getMessage() );
            return false;
        }
    
    }

    protected abstract void tratamentoStringLeitura();
    protected abstract String atributosConvertidosEmString();
    protected abstract boolean criaOuAtualiza();

}