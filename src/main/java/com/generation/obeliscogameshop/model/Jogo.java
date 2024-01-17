package com.generation.obeliscogameshop.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_jogos")
public class Jogo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O Atributo nome é obrigatório")
	@Size(min = 1, max = 100, message = "O nome deve ter no mínimo 1 caracteres e no máximo 100")
	private String nome;
	
	@NotBlank(message = "O Atributo distribuidora é obrigatório")
	@Size(min = 1, max = 100, message = "A distribuidora deve ter no mínimo 1 caracteres e no máximo 100")
	private String distribuidora;
	
	@NotNull(message = "O atributo preço é obrigatório")
	@DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que 0.0")
	private Double preco;
	
	@Min(value = 0, message = "A classificacao deve ser no mínimo 0")
	private int classificacao;

	@ManyToOne
	private Categoria genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Categoria getGenero() {
		return genero;
	}

	public void setGenero(Categoria genero) {
		this.genero = genero;
	}



	

	


	
	
}