package com.generation.obeliscogameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.obeliscogameshop.model.Categoria;

// JPA da o poder da repository comunicar-se com o banco de dados
@Repository
public interface CategoriasRepository extends JpaRepository <Categoria, Long> {
/**
 * Buscar todos pelo genero
 * @param genero
 * @return lista de jogos
 */
	List<Categoria> findAllByGeneroContainingIgnoreCase(@Param("genero") String genero);
}
