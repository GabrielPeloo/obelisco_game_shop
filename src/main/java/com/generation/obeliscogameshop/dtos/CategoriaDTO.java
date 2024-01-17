package com.generation.obeliscogameshop.dtos;

import com.generation.obeliscogameshop.model.Categoria;

public class CategoriaDTO {

	private String genero;

	public CategoriaDTO(Categoria categoria) {
		this.genero = categoria.getGenero();
	}

	public CategoriaDTO() {
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
