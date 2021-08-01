package com.qintess.veterinaria.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.veterinaria.model.Animal;
import com.qintess.veterinaria.model.Cliente;
import com.qintess.veterinaria.model.Especie;
import com.qintess.veterinaria.service.AnimalService;
import com.qintess.veterinaria.service.ClienteService;
import com.qintess.veterinaria.service.EspecieService;


@Controller
@RequestMapping("/animal")
public class AnimalController {
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EspecieService especieService;

	@RequestMapping("")
	public String carregaAnimal(Model model) {
		model.addAttribute("animal", new Animal());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("especie", new Especie());
		List<Animal> animais = animalService.buscaTodos();
		model.addAttribute("animais", animais);
		List<Cliente> clientes = clienteService.buscaTodos();
		model.addAttribute("clientes", clientes);
		List<Especie> especies = especieService.buscaTodos();
		model.addAttribute("especies", especies);
		return "animal";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(@RequestParam("cliente") Cliente cliente, 
						@RequestParam("especie") Especie especie,
						@ModelAttribute Animal animal,
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(animal.getCodigo() == 0) {	
				animalService.insere(animal);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Animal cadastrado com sucesso!");
			}
			
			else {
				animalService.insere(animal);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Animal alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/animal";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Animal animal = animalService.buscaPorId(codigo);
			animalService.deleta(animal);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Animal deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/animal";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Animal animal = animalService.buscaPorId(codigo);
			model.addAttribute("animal", animal);
			List<Cliente> clientes = clienteService.buscaTodos();
			model.addAttribute("clientes", clientes);
			List<Especie> especies = especieService.buscaTodos();
			model.addAttribute("especies", especies);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Animal alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "animal";
	}
	
	

}
