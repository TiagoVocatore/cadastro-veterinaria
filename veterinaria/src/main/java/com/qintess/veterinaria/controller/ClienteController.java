package com.qintess.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.veterinaria.model.Animal;
import com.qintess.veterinaria.model.Cliente;
import com.qintess.veterinaria.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping("")
	public String carregaCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		List<Cliente> clientes = clienteService.buscaTodos();
		model.addAttribute("clientes", clientes);
		return "cliente";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Cliente cliente,
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(cliente.getCodigo() == 0) {	
				clienteService.insere(cliente);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Cliente cadastrado com sucesso!");
			}
			
			else {
				clienteService.insere(cliente);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Cliente alterado com sucesso!");
			}
			
		} catch (Exception e) {
				redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		
		return "redirect:/cliente";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model, 
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Cliente cliente = clienteService.buscaPorId(codigo);
			clienteService.deleta(cliente);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Cliente deletado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "redirect:/cliente";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			Cliente cliente = clienteService.buscaPorId(codigo);
			model.addAttribute("cliente", cliente);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Cliente deletado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		
		return "cliente";
	}

}
