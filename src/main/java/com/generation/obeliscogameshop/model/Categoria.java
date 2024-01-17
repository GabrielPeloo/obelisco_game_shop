package com.generation.obeliscogameshop.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

//modelar o atributo e a tabela postagens no banco de dados
@Entity
@Table(name="tb_categorias")
public class Categoria {
	
	@Id //tornar esse atributo uma chave primária do db
	@GeneratedValue(strategy=GenerationType.IDENTITY) // add id como auto increment
	private long id;
	
	//essa anotação valida o atributo tendo um valor máximo e minimo de caracteres
	@Size(min = 1, max = 100, message = "O genero deve ter no mínimo 1 caracteres e no máximo 100")
	@NotBlank(message = "Atributo genero é obrigatório")
	private String genero;
	
	
	@OneToMany(mappedBy = "genero")
    private List<Jogo> jogo;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}

	
	
}
