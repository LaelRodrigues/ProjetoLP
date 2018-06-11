package arvoreBinariaDeBusca;


import classes.Usuario;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testando os m�todos da classe ABB com JUnit5")
public class ABBTest{
	
	private ABB arvore;
	
	public ABBTest() {
		arvore = new ABB();
	}
	
	@Test
	@DisplayName("Testando o m�todo insere")
	public void insereTest(){
		assertEquals( true, arvore.insere( new Usuario("usuario1", "Lucas", "sa", false) ), "O resultado esperado da inser��o do 3 � true... Est� correto?" );
		assertEquals( true, arvore.insere( new Usuario("usuario2", "Moura", "fea", true) ), "O resultado esperado da inser��o do 4 � true... Est� correto?" );
		assertEquals( false, arvore.insere( new Usuario("usuario1", "Lucas", "sa", false)), "O resultado esperado da inser��o do 3 � false... Est� correto?" );
		assertEquals( false, arvore.insere( new Usuario("usuario2", "Moura", "fea", true) ), "O resultado esperado da inser��o do 4 � false... Est� correto?" );
	}

	@Test
	@DisplayName("Testando o m�todo busca")
	public void buscaTest(){
		assertEquals( false, arvore.busca(new Usuario("usuario1", "Lucas", "sa", false) ), "O resultado esperado da busca pelo 3 � false... Est� correto?" );
		arvore.insere(new Usuario("usuario1", "Lucas", "sa", false) );
		assertEquals( true, arvore.busca( new Usuario("usuario1", "Lucas", "sa", false) ), "O resultado esperado da busca pelo 3 � true... Est� correto?" );
		assertEquals( false, arvore.busca( new Usuario("usuario2", "Moura", "fea", true) ), "O resultado esperado da busca pelo 4 � false... Est� correto?" );
		
	}
	
	@Test
	@DisplayName("Testando o m�todo remove")
	public void removeTest(){
		assertEquals( false, arvore.remove( new Usuario("usuario1", "Lucas", "sa", false) ), "O resultado esperado da remo��o do 3 � false... Est� correto?" );
		arvore.insere( new Usuario("usuario1", "Lucas", "sa", false) );
		assertEquals( true, arvore.remove( new Usuario("usuario1", "Lucas", "sa", false) ), "O resultado esperado da remo��o do 3 � true... Est� correto?" );
		assertEquals( false, arvore.remove( new Usuario("usuario2", "Moura", "fea", true) ), "O resultado esperado da remo��o do 4 � false... Est� correto?" );
		
	}
	
}
