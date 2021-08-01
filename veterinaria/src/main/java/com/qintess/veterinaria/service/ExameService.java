package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Exame;
import com.qintess.veterinaria.repos.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public void insere(Exame exame) {
		exameRepository.save(exame);	
	}
	
	public void deleta(Exame exame) {
		exameRepository.delete(exame);
	}
	
	public Exame buscaPorNome(String exame) {
		return exameRepository.findByNome(exame);
	}
	
	public Exame buscaPorId(int codigo) {
		return exameRepository.findById(codigo);	
	}
	
	public List<Exame> buscaTodos(){
		return  exameRepository.findAll();
	}

}
