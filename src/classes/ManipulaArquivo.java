package classes;

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
public class ManipulaArquivo {
	
    /**
     * Lê o arquivo entrado com o nome  
     * @param   nomeDoArquivo   Nome do arquivo a ser lido
     * @return  String com o conteudo do arquivo se a leitura for feita corretamente, senão string nula
     */
    public static String lerArquivo( String nomeDoArquivo ){

        String conteudo = new String("");
        
        try{

            BufferedReader buffReader = new BufferedReader(new FileReader( nomeDoArquivo ));
            String linha = new String();

            while( buffReader.ready() ){              // -> LENDO CADA LINHA  
                linha = buffReader.readLine();
                conteudo += linha + "\n";
            }
            
            buffReader.close();
            return conteudo;

        }
        catch(FileNotFoundException e){  // -> ARQUIVO NÃO EXISTE

            System.err.println( e.getMessage() );   
            return "";
        }  
        catch(IOException e){  // -> OCORREU OUTRO ERRO, SENDO ESSE DESCONHECIDO

            System.err.println( e.getMessage() );
            return "";
        
        }

    }
    
    /**
     * Lê o arquivo entrado com o nome  
     * @param   nomeDoArquivo   Nome do arquivo a ser lido
     * @param   conteudo        Conteúdo 
     * @return  True se a leitura for feita corretamente, senão false
     */
    public static boolean salvarArquivo(String nomeDoArquivo, String conteudo){
        
        try{

          FileWriter writer = new FileWriter(nomeDoArquivo);     

          writer.write(conteudo);

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

}
