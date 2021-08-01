package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.veterinaria.model.Veterinario;
import com.qintess.veterinaria.repos.VeterinarioRepository;

@Service
public class VeterinarioService {
	
	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	public void insere(Veterinario veterinario) {
		veterinarioRepository.save(veterinario);	
	}
	
	public void deleta(Veterinario veterinario) {
		veterinarioRepository.delete(veterinario);
	}
	
	public Veterinario buscaPorNome(String nome) {
		return veterinarioRepository.findByNome(nome);
	}
	
	public Veterinario buscaPorId(int codigo) {
		return veterinarioRepository.findById(codigo);	
	}
	
	public List<Veterinario> buscaTodos(){
		return  veterinarioRepository.findAll();
	}

	
}
