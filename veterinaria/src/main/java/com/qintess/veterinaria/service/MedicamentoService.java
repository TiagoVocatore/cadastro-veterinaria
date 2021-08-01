package com.qintess.veterinaria.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Medicamento;
import com.qintess.veterinaria.repos.MedicamentoRepository;

@Service
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;
	
	public void insere(Medicamento medicamento) {
		medicamentoRepository.save(medicamento);	
	}
	
	public void deleta(Medicamento medicamento) {
		medicamentoRepository.delete(medicamento);
	}
	
	public Medicamento buscaPorNome(String medicamento) {
		return medicamentoRepository.findByNome(medicamento);
	}
	
	public Medicamento buscaPorId(int codigo) {
		return medicamentoRepository.findById(codigo);	
	}
	
	public List<Medicamento> buscaTodos(){
		return  medicamentoRepository.findAll();
	}

}
