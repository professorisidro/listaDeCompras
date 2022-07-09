package br.com.professorisidro.listamercado.service.listadecompras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.professorisidro.listamercado.dao.ListaDeComprasDAO;
import br.com.professorisidro.listamercado.model.ItemLista;
import br.com.professorisidro.listamercado.model.ListaDeCompras;

@Component
public class ListaDeComprasServiceImpl implements IListaDeComprasService{

	@Autowired
	private ListaDeComprasDAO dao;
	
	@Override
	public ListaDeCompras criarNovaLista(ListaDeCompras lista) {
		// TODO Auto-generated method stub
		for (ItemLista item: lista.getItens()) {
			item.setLista(lista);   // preciso vincular o "filho" ao "pai"
		}
		return dao.save(lista);
	}

	@Override
	public ListaDeCompras buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<ListaDeCompras> listarTodas() {
		// TODO Auto-generated method stub
		return dao.findByOrderByDataListaDesc();
	}
	
	

}
