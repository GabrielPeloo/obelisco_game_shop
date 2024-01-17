package com.generation.obeliscogameshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.obeliscogameshop.model.Categoria;
import com.generation.obeliscogameshop.repository.CategoriasRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*") //informa toda e qualquer origem que pode acessar essa rota
public class CategoriasController {

	//injeção de dependencias
	@Autowired
	private CategoriasRepository categoriasRepository;

	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		//respostas no formato http
		
		return ResponseEntity.ok(categoriasRepository.findAll());
	    
		//find all == select * from nomedatabela
		
		// código de retorno -- corpo de retorno
	
	}
	
	@GetMapping("/lista_categorias")
	public ResponseEntity<String> exemplo(){
		String cat = "Aventura\n"
				+ "RPG\n"
				+ "Corrida\n"
				+ "FPS\n"
				+ "Gacha\n"
				+ "MOBA\n"
				+ "Luta\n";
		return ResponseEntity.ok(cat);
		
		}
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id ){
		return categoriasRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/genero/{genero}")
	public ResponseEntity<List<Categoria>> getByGenero(@PathVariable String genero){
		return ResponseEntity.ok(categoriasRepository.findAllByGeneroContainingIgnoreCase(genero));
	}
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoriasRepository.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria){
		return categoriasRepository.findById(categoria.getId())
		.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(categoriasRepository.save(categoria)))
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriasRepository.findById(id);
		
		if (categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		categoriasRepository.deleteById(id);
	}
	
}
