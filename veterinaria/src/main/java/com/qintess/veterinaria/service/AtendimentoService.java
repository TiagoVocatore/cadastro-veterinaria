package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Atendimento;
import com.qintess.veterinaria.repos.AtendimentoRepository;

@Service
public class AtendimentoService {
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public void insere(Atendimento atendimento) {
		atendimentoRepository.save(atendimento);	
	}
	
	public void deleta(Atendimento atendimento) {
		atendimentoRepository.delete(atendimento);
	}
	
	
	public Atendimento buscaPorId(int codigo) {
		return atendimentoRepository.findById(codigo);	
	}
	
	public List<Atendimento> buscaTodos(){
		return  atendimentoRepository.findAll();
	}

}
