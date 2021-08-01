package com.qintess.veterinaria.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Integer> {
	
	public Veterinario findByNome(String nome);
	
	public List<Veterinario> findAll();
	
	public Veterinario findById(int codigo);
	

}
