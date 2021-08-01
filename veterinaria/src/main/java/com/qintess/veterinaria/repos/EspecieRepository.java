package com.qintess.veterinaria.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Especie;

public interface EspecieRepository  extends 
				 JpaRepository<Especie, Integer> {
	
	public Especie findByNome(String nome);
	
	public List<Especie> findAll();
	
	public Especie findById(int codigo);

}
