package com.qintess.veterinaria.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.veterinaria.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	public Animal findByNome(String nome);
	
	public List<Animal> findAll();
	
	public Animal findById(int codigo);
	
}
