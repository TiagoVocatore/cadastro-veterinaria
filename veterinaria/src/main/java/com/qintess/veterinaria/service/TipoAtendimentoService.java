package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.veterinaria.model.TipoAtendimento;
import com.qintess.veterinaria.repos.TipoAtendimentoRepository;

@Service
public class TipoAtendimentoService {
	
	@Autowired
	private TipoAtendimentoRepository tipoAtendimentoRepository;
	
	public void insere(TipoAtendimento tipoAtendimento) {
		tipoAtendimentoRepository.save(tipoAtendimento);	
	}
	
	public void deleta(TipoAtendimento tipoAtendimento) {
		tipoAtendimentoRepository.delete(tipoAtendimento);
	}
	
	public TipoAtendimento buscaPorTipo(String tipo) {
		return tipoAtendimentoRepository.findByTipo(tipo);
	}
	
	public TipoAtendimento buscaPorId(int codigo) {
		return tipoAtendimentoRepository.findById(codigo);	
	}
	
	public List<TipoAtendimento> buscaTodos(){
		return  tipoAtendimentoRepository.findAll();
	}

}
