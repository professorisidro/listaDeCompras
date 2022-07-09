package br.com.professorisidro.listamercado.service.produto;

import java.util.List;

import br.com.professorisidro.listamercado.model.Produto;

public interface IProdutoService {
	public Produto criarNovoProduto(Produto p);
	public List<Produto> buscarTodos();
	public List<Produto> buscarPorPalavraChave(String palavra);
	public Produto buscarPeloId(Integer id);
	public Produto alterarDadosProduto(Produto p);
}
