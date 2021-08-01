package com.qintess.veterinaria.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Atendimento;
import com.qintess.veterinaria.model.Prontuario;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Integer> {
	
	public List<Prontuario> findAll();
	
	public Prontuario findById(int codigo);

}
