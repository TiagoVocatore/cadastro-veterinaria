package com.qintess.veterinaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Especie;
import com.qintess.veterinaria.repos.EspecieRepository;

@Service
public class EspecieService {
	
	@Autowired
	private EspecieRepository especieRepository;
	
	public void insere(Especie especie) {
		especieRepository.save(especie);	
	}
	
	public void deleta(Especie especie) {
		especieRepository.delete(especie);
	}
	
	public Especie buscaPorNome(String especie) {
		return especieRepository.findByNome(especie);
	}
	
	public Especie buscaPorId(int codigo) {
		return especieRepository.findById(codigo);	
	}
	
	public List<Especie> buscaTodos(){
		return  especieRepository.findAll();
	}

}
