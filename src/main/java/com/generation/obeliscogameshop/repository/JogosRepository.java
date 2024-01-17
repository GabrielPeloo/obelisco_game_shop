package com.generation.obeliscogameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.obeliscogameshop.model.Jogo;

public interface JogosRepository extends JpaRepository <Jogo, Long> {

	List<Jogo> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
