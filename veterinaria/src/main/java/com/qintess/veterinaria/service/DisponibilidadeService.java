package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.veterinaria.model.Disponibilidade;
import com.qintess.veterinaria.repos.DisponibilidadeRepository;

@Service
public class DisponibilidadeService {
	
	@Autowired
	private DisponibilidadeRepository disponibilidadeRepository;
	
	public void insere(Disponibilidade disponibilidade) {
		disponibilidadeRepository.save(disponibilidade);	
	}
	
	public void deleta(Disponibilidade disponibilidade) {
		disponibilidadeRepository.delete(disponibilidade);
	}
	
	public Disponibilidade buscaPorNome(String disponibilidade) {
		return disponibilidadeRepository.findByNome(disponibilidade);
	}
	
	public Disponibilidade buscaPorId(int codigo) {
		return disponibilidadeRepository.findById(codigo);	
	}
	
	public List<Disponibilidade> buscaTodos(){
		return  disponibilidadeRepository.findAll();
	}

}
