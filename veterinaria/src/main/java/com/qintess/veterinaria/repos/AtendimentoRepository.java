package com.qintess.veterinaria.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
	
	public List<Atendimento> findAll();
	
	public Atendimento findById(int codigo);

}
