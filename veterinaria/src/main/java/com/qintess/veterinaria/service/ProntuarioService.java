package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Atendimento;
import com.qintess.veterinaria.model.Prontuario;
import com.qintess.veterinaria.repos.AtendimentoRepository;
import com.qintess.veterinaria.repos.ProntuarioRepository;

@Service
public class ProntuarioService {
	
	@Autowired
	private ProntuarioRepository prontuarioRepository;
	
	public void insere(Prontuario prontuario) {
		prontuarioRepository.save(prontuario);	
	}
	
	public void deleta(Prontuario prontuario) {
		prontuarioRepository.delete(prontuario);
	}
	
	
	public Prontuario buscaPorId(int codigo) {
		return prontuarioRepository.findById(codigo);	
	}
	
	public List<Prontuario> buscaTodos(){
		return  prontuarioRepository.findAll();
	}

}
