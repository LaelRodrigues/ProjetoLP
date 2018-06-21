package arvoreTrie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testando os métodos da classe Trie com JUnit5")
public class TrieTest {
	
	private Trie trie;
	
	public TrieTest() {
		trie = new Trie(); 
	}
	
	@Test
	@DisplayName("Testando o método busca")
	public void buscaTest() {
		
		assertEquals( false, trie.busca("vamos"), "A busca pela string **vamos** deve dar false... Está correto?");
		assertEquals( false, trie.busca("the"), "A busca pela string **the** deve dar false... Está correto?");
		
		trie.insere("vamos");
		trie.insere("the");
		
		assertEquals( true, trie.busca("vamos"), "A busca pela string **vamos** deve dar true... Está correto?");
		assertEquals( true, trie.busca("the"), "A busca pela string **the** deve dar true... Está correto?");
		
		trie.remove("vamos");
		trie.remove("the");
		
		assertEquals( false, trie.busca("vamos"), "A busca pela string **vamos** deve dar false... Está correto?");
		assertEquals( false, trie.busca("the"), "A busca pela string **the** deve dar false... Está correto?");
		
		
	}
	
	@Test
	@DisplayName("Testando o método insere")
	public void insereTest() {
	
		assertEquals( true, trie.insere("vamos"), "A inserção da string **vamos** deve dar true... Está correto?");
		assertEquals( true, trie.insere("the"), "A inserção da string **the** deve dar true... Está correto?");
		assertEquals( false, trie.insere("vamos"), "A inserção da string **vamos** deve dar false... Está correto?");
		assertEquals( false, trie.insere("the"), "A inserção da string **the** deve dar false... Está correto?");
		
	}
	
	@Test
	@DisplayName("Testando o método remove")
	public void removeTest() {
		
		assertEquals( false, trie.remove("vamos"), "A remoção da string **vamos** deve dar false... Est� correto?");
		assertEquals( false, trie.remove("the"), "A remoção da string **the** deve dar false... Est� correto?");
	
		trie.insere("vamos");
		trie.insere("the");
	
		assertEquals( true, trie.remove("vamos"), "A remoção da string **vamos** deve dar true... Está correto?");
		assertEquals( true, trie.remove("the"), "A remoção da string **the** deve dar true... Está correto?");
	
	}
}
