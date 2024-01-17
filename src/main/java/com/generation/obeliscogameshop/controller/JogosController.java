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

import com.generation.obeliscogameshop.dtos.JogoDTO;
import com.generation.obeliscogameshop.model.Jogo;
import com.generation.obeliscogameshop.repository.JogosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JogosController {

	//injeção de dependencias
	@Autowired
	private JogosRepository jogosRepository;

	@GetMapping
	public ResponseEntity<List<Jogo>> getAll(){
		//respostas no formato http
		
		return ResponseEntity.ok(jogosRepository.findAll());
	    
		//find all == select * from nomedatabela
		
		// código de retorno -- corpo de retorno
	
	}
	
	@GetMapping("/exemplo")
	public ResponseEntity<String> exemplo(){
		String ola = "Olá mundo";
		return ResponseEntity.ok(ola);
		
		}
	@GetMapping("/{id}")
	public ResponseEntity<JogoDTO> getById(@PathVariable Long id ){
		return jogosRepository.findById(id)
				.map(resp -> ResponseEntity.ok(new JogoDTO( resp)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<Jogo>> getNome(@PathVariable String nome){
		return ResponseEntity.ok(jogosRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	@PostMapping
	public ResponseEntity<Jogo> post(@Valid @RequestBody Jogo jogo){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(jogosRepository.save(jogo));
	}
	
	@PutMapping
	public ResponseEntity<Jogo> put(@Valid @RequestBody Jogo jogo){
		return jogosRepository.findById(jogo.getId())
		.map(resposta -> ResponseEntity.status(HttpStatus.OK)
				.body(jogosRepository.save(jogo)))
		.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Jogo> jogo = jogosRepository.findById(id);
		
		if (jogo.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		jogosRepository.deleteById(id);
	}
	
}
