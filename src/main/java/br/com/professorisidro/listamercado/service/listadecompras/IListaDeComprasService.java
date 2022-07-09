package br.com.professorisidro.listamercado.service.listadecompras;

import java.util.List;

import br.com.professorisidro.listamercado.model.ListaDeCompras;

public interface IListaDeComprasService {
	public ListaDeCompras criarNovaLista(ListaDeCompras lista);
	public ListaDeCompras buscarPeloId(Integer id);
	public List<ListaDeCompras> listarTodas();
}
