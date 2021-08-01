package com.qintess.veterinaria.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public Cliente findByNome(String nome);
	
	public List<Cliente> findAll();
	
	public Cliente findById(int codigo);
	

}
