package br.com.professorisidro.listamercado.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tbl_lista")
public class ListaDeCompras {

	@Id
	@Column(name = "id_lista")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome_lista", length = 45)
	private String nome;

	@Column(name = "data_lista")
	private LocalDate dataLista;
	
	@OneToMany (mappedBy = "lista", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("lista")
	private List<ItemLista> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataLista() {
		return dataLista;
	}

	public void setDataLista(LocalDate dataLista) {
		this.dataLista = dataLista;
	}

	public List<ItemLista> getItens() {
		return itens;
	}

	public void setItens(List<ItemLista> itens) {
		this.itens = itens;
	}

}
