package com.qintess.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.veterinaria.model.Cliente;
import com.qintess.veterinaria.repos.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public void insere(Cliente cliente) {
		clienteRepository.save(cliente);	
	}
	
	public void deleta(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	public Cliente buscaPorNome(String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	public Cliente buscaPorId(int codigo) {
		return clienteRepository.findById(codigo);
	}
	
	public List<Cliente> buscaTodos(){
		return  clienteRepository.findAll();
	}

}
