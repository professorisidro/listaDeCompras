package br.com.professorisidro.listamercado.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.professorisidro.listamercado.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

	List<Produto> findByNomeContaining(String palavra);
}
