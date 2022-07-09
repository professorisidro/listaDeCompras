package br.com.professorisidro.listamercado.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.professorisidro.listamercado.model.Produto;
import br.com.professorisidro.listamercado.service.produto.IProdutoService;

@SpringBootTest
@ActiveProfiles("test")
public class CriadorDeProdutoTest {

	@Autowired
	private IProdutoService service;

	@Test
	public void shouldCreateProduto() {
		Produto p = new Produto();
		p.setNome("Produto de Teste em memoria");
		assertNotNull(service.criarNovoProduto(p));
	}

}
