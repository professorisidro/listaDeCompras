package br.com.professorisidro.listamercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.listamercado.dto.StatusMessage;
import br.com.professorisidro.listamercado.model.ListaDeCompras;
import br.com.professorisidro.listamercado.service.listadecompras.IListaDeComprasService;

@RestController
public class ListaDeComprasController {
	
	@Autowired
	private IListaDeComprasService service;
	
	@GetMapping("/listas")
	public List<ListaDeCompras> getAll(){
		return service.listarTodas();
	}
	
	@GetMapping("/listas/{id}")
	public ResponseEntity<ListaDeCompras> getById(@PathVariable Integer id){
		ListaDeCompras res = service.buscarPeloId(id);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping("/listas")
	public ResponseEntity<?> createNew(@RequestBody ListaDeCompras l){
		try {
			ListaDeCompras lista = service.criarNovaLista(l);
			if (lista != null) {
				return ResponseEntity.status(201).body(lista);
			}
			return ResponseEntity.badRequest().build();
		}
		catch(Exception ex) {
			return ResponseEntity.status(500).body(new StatusMessage(ex.getMessage()));
		}
	}

}
