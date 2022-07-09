package br.com.professorisidro.listamercado.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_itemlista")
public class ItemLista {
	
	@Id
	@Column(name = "id_item")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "quantidade")
	private Double  quantidade;
	
	@Column(name = "preco_unit")
	private Double  precoUnitario;
	
	@Column(name = "preco_total")
	private Double  precoTotal;
	
	@ManyToOne
	@JoinColumn(name = "tbl_produto_id_produto")
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "tbl_lista_id_lista")
	private ListaDeCompras lista;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ListaDeCompras getLista() {
		return lista;
	}

	public void setLista(ListaDeCompras lista) {
		this.lista = lista;
	}

}
