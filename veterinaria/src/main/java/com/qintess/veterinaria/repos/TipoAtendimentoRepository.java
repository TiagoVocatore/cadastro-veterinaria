package com.qintess.veterinaria.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.qintess.veterinaria.model.TipoAtendimento;


public interface TipoAtendimentoRepository extends JpaRepository<TipoAtendimento, Integer> {
	
	public TipoAtendimento findByTipo(String tipo);
	
	public List<TipoAtendimento> findAll();
	
	public TipoAtendimento findById(int codigo);
}