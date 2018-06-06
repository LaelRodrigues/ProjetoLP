package arvoreBinariaDeBusca;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testando os métodos da classe ABB com JUnit5")
public class ABBTest{
	
	private ABB arvore;
	
	public ABBTest() {
		arvore = new ABB();
	}
	
	@Test
	@DisplayName("Testando o método insere")
	public void insereTest(){
		assertEquals( true, arvore.insere(3), "O resultado esperado da inserção do 3 é true... Está correto?" );
		assertEquals( true, arvore.insere(4), "O resultado esperado da inserção do 4 é true... Está correto?" );
		assertEquals( false, arvore.insere(3), "O resultado esperado da inserção do 3 é false... Está correto?" );
		assertEquals( false, arvore.insere(4), "O resultado esperado da inserção do 4 é false... Está correto?" );
	}

	@Test
	@DisplayName("Testando o método busca")
	public void buscaTest(){
		assertEquals( false, arvore.busca(3), "O resultado esperado da busca pelo 3 é false... Está correto?" );
		arvore.insere(3);
		assertEquals( true, arvore.busca(3), "O resultado esperado da busca pelo 3 é true... Está correto?" );
		assertEquals( false, arvore.busca(4), "O resultado esperado da busca pelo 4 é false... Está correto?" );
		
	}
	
	@Test
	@DisplayName("Testando o método remove")
	public void removeTest(){
		assertEquals( false, arvore.remove(3), "O resultado esperado da remoção do 3 é false... Está correto?" );
		arvore.insere(3);
		assertEquals( true, arvore.remove(3), "O resultado esperado da remoção do 3 é true... Está correto?" );
		assertEquals( false, arvore.remove(4), "O resultado esperado da remoção do 4 é false... Está correto?" );
		
	}
	
}
