package com.generation.obeliscogameshop.dtos;

import com.generation.obeliscogameshop.model.Jogo;

public class JogoDTO {
	
	private String nome;
	
	private String distribuidora;
	
	private Double preco;
	
	private int classificacao;
	
	private CategoriaDTO categoria;

	public JogoDTO() {
	}

	public JogoDTO(String nome, String distribuidora, Double preco, int classificacao, CategoriaDTO categoria) {
		this.nome = nome;
		this.distribuidora = distribuidora;
		this.preco = preco;
		this.classificacao = classificacao;
		this.categoria = categoria;
	}

	public JogoDTO(Jogo jogo) {
		this.nome = jogo.getNome();
		this.distribuidora = jogo.getDistribuidora();
		this.preco = jogo.getPreco();
		this.classificacao = jogo.getClassificacao();
		this.categoria = new CategoriaDTO (jogo.getGenero());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

}
