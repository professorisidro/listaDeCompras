package br.com.professorisidro.listamercado.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.professorisidro.listamercado.model.Produto;
import br.com.professorisidro.listamercado.service.produto.ProdutoServiceImpl;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTests {
	
	// 3 testes -
	// teste 1 - para recuperar todos os produtos
	// teste 2 - para recuperar 1 produto que existe
	// teste 3 - para recuperar 1 produto que não existe
	private static ProdutoServiceImpl service;
	private static Produto p;
	
	@BeforeAll
	public static void setup() {
		System.out.println("Estou no setup do mock");
		Produto p = new Produto();
		p.setId(1);
		p.setNome("Bolacha");
		
		service = Mockito.mock(ProdutoServiceImpl.class);
		Mockito.when(service.buscarTodos()).thenReturn(new ArrayList<Produto>());
		Mockito.when(service.buscarPeloId(1)).thenReturn(p);
		Mockito.when(service.buscarPeloId(100)).thenReturn(null);
	}
	
	
	@Test
	public void shouldReturnListaDeProdutos() {
		List<Produto> lista = service.buscarTodos();
		System.out.println(lista);
		assertNotNull(service.buscarTodos());
	}
	
	@Test
	public void shouldReturndProdutoValido() {
		System.out.println(p);
		assertNotNull(service.buscarPeloId(1));
	}

	@Test
	public void shouldReturnProdutoQueNaoExiste() {
		assertNull(service.buscarPeloId(100));		
	}
}
