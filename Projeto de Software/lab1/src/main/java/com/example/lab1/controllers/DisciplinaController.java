package com.example.lab1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab1.entities.Disciplina;
import com.example.lab1.services.DisciplinaService;

@RequestMapping({ "/v1/api/disciplinas" })
@RestController
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@PostMapping
	public Disciplina inserir(@RequestBody Disciplina disciplina) {
		return this.disciplinaService.inserir(disciplina);
	}

	@GetMapping
	public List<Disciplina> listar() {
		return this.disciplinaService.exibir();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> buscar(@PathVariable int id) {
		Disciplina disciplina = disciplinaService.buscar(id);

		if (disciplina == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(disciplina);
	}

	@PutMapping("/{id}/nome")
	public ResponseEntity<Disciplina> atualizarNome(@PathVariable int id, @RequestBody Disciplina disciplina) {
		
		Disciplina existente = disciplinaService.buscar(id);

		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		existente.setNome(disciplina.getNome());
		return ResponseEntity.ok(existente);
	}

	@PutMapping("/{id}/nota")
	public ResponseEntity<Disciplina> atualizarNota(@PathVariable int id, @RequestBody Disciplina disciplina) {
		
		Disciplina existente = disciplinaService.buscar(id);

		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		existente.setNota(disciplina.getNota());
		return ResponseEntity.ok(existente);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Disciplina> remover(@PathVariable int id) {

		Disciplina disciplina = disciplinaService.buscar(id);

		if (disciplina == null) {
			return ResponseEntity.notFound().build();
		}
		disciplinaService.remover(id);
		return ResponseEntity.ok(disciplina);
	}
	
	@GetMapping("/ranking")
	public List<Disciplina> ranking() {
		return this.disciplinaService.ranking();
	}
}
