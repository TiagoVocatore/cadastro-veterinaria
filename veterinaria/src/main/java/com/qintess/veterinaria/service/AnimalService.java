package com.qintess.veterinaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.veterinaria.model.Animal;
import com.qintess.veterinaria.repos.AnimalRepository;

@Service
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepository;
	
	public void insere(Animal animal) {
	animalRepository.save(animal);	
	}
	
	public void deleta(Animal animal) {
		animalRepository.delete(animal);
	}
	
	public Animal buscaPorNome(String nome) {
		return animalRepository.findByNome(nome);
	}
	
	public Animal buscaPorId(int codigo) {
		return animalRepository.findById(codigo);	
	}
	
	public List<Animal> buscaTodos(){
		return  animalRepository.findAll();
	}
	
}
