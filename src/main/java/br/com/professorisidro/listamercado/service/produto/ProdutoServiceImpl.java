package br.com.professorisidro.listamercado.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.professorisidro.listamercado.dao.ProdutoDAO;
import br.com.professorisidro.listamercado.model.Produto;

@Component
public class ProdutoServiceImpl implements IProdutoService{

	@Autowired
	private ProdutoDAO pDao;
	
	@Override
	public Produto criarNovoProduto(Produto p) {
		// TODO Auto-generated method stub
		return pDao.save(p);
	}

	@Override
	public List<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return (List<Produto>)pDao.findAll();
	}

	@Override
	public List<Produto> buscarPorPalavraChave(String palavra) {
		// TODO Auto-generated method stub
		return pDao.findByNomeContaining(palavra);
	}

	@Override
	public Produto buscarPeloId(Integer id) {
		// TODO Auto-generated method stub
		return pDao.findById(id).orElse(null);
	}

	@Override
	public Produto alterarDadosProduto(Produto p) {
		// TODO Auto-generated method stub
		return pDao.save(p);
	}

}
