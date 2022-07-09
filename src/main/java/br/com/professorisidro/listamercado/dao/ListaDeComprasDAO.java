package br.com.professorisidro.listamercado.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.professorisidro.listamercado.model.ListaDeCompras;

public interface ListaDeComprasDAO extends CrudRepository<ListaDeCompras, Integer>{
	
	public List<ListaDeCompras> findByOrderByDataListaDesc();

} 
