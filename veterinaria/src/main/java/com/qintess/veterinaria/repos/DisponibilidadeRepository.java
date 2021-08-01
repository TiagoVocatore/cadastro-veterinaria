package com.qintess.veterinaria.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Disponibilidade;


public interface DisponibilidadeRepository extends 
JpaRepository<Disponibilidade, Integer> {
	
public Disponibilidade findByNome(String nome);

public List<Disponibilidade> findAll();

public Disponibilidade findById(int codigo);

}
