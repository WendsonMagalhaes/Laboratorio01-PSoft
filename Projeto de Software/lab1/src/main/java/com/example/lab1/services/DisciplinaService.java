package com.example.lab1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.lab1.entities.Disciplina;

@Service
public class DisciplinaService {

	private Map<Integer, Disciplina> disciplinas;
	

	public DisciplinaService() {

		disciplinas = new HashMap<>();
	}

	public Disciplina inserir(Disciplina disciplina) {
		
		disciplina.setId(this.disciplinas.size() + 1);
		this.disciplinas.put(disciplina.getId(),disciplina);
		
		return disciplina;
		
	}

	public Disciplina buscar(int id) {

		return disciplinas.get(id);

	}

	public List<Disciplina> exibir() {

		return new ArrayList<>(disciplinas.values());
	}

	public Disciplina atualizar(Disciplina disciplina) {
		
		
		this.disciplinas.replace(disciplina.getId(), disciplina);
		return this.disciplinas.get(disciplina.getId());
	}

	
	
	public void remover(int id) {
	
		disciplinas.remove(id);
		
	}
	
	public List<Disciplina> ranking(){
		
		List<Disciplina> ranking = new ArrayList<>(this.disciplinas.values());
		Collections.sort(ranking);
		
		return ranking;
	}

}
