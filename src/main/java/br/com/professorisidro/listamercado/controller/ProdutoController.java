package br.com.professorisidro.listamercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.listamercado.dto.StatusMessage;
import br.com.professorisidro.listamercado.model.Produto;
import br.com.professorisidro.listamercado.service.produto.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	@GetMapping("/produtos")
	public List<Produto> getAll(){
		return service.buscarTodos();
	}
	
	@GetMapping("/produtos/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		Produto res = service.buscarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.status(404).body(new StatusMessage("Nao encontrei produto de id:"+id));		
	}
	
	@GetMapping("/produtos/search")
	public List<Produto> getByKeyword(@RequestParam(name = "k") String k){
		return service.buscarPorPalavraChave(k);
	}
	
	@PostMapping("/produtos")
	public ResponseEntity<Produto> addNew(@RequestBody Produto p){
		try {
			Produto res = service.criarNovoProduto(p);
			if (res != null) {
				return ResponseEntity.status(201).body(res);
			}
			return ResponseEntity.badRequest().build();
		}
		catch(Exception ex) {
			return ResponseEntity.status(500).build();
		}
	}
	
	@PutMapping("/produtos/{id}")
	public ResponseEntity<Produto> updateProduct(@RequestBody Produto p, @PathVariable Integer id){
		try {
			p.setId(id);
			Produto res = service.alterarDadosProduto(p);
			if (res != null) {
				return ResponseEntity.ok(res);
			}
			return ResponseEntity.badRequest().build();
		}
		catch(Exception ex) {
			return ResponseEntity.status(500).build();
		}
	}
}
