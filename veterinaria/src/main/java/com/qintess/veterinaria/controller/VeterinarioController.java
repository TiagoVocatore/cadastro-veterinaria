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
import com.qintess.veterinaria.model.Disponibilidade;
import com.qintess.veterinaria.model.Especie;
import com.qintess.veterinaria.model.Veterinario;
import com.qintess.veterinaria.service.AnimalService;
import com.qintess.veterinaria.service.DisponibilidadeService;
import com.qintess.veterinaria.service.EspecieService;
import com.qintess.veterinaria.service.VeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
	
	@Autowired
	private VeterinarioService veterinarioService;
	
	@Autowired
	private EspecieService especieService;
	
	@Autowired
	private DisponibilidadeService disponibilidadeService;
	
	@RequestMapping("")
	public String carregaVeterinario(Model model) {
		model.addAttribute("veterinario", new Veterinario());
		model.addAttribute("especie", new Especie());
		model.addAttribute("disponibilidade", new Disponibilidade());
		
		List<Veterinario> veterinarios = veterinarioService.buscaTodos();
		List<Especie> especies = especieService.buscaTodos();
		List<Disponibilidade> disponibilidades = disponibilidadeService.buscaTodos();
		
		model.addAttribute("veterinarios", veterinarios);
		model.addAttribute("especies", especies);
		model.addAttribute("disponibilidades", disponibilidades);
		
		return "veterinario";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(
		   @RequestParam("especies") Especie especie,
		   @RequestParam("disponibilidade") Disponibilidade disponibilidade,
		   @ModelAttribute Veterinario veterinario, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(veterinario.getCodigo() == 0) {	
				veterinarioService.insere(veterinario);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Veterinario cadastrado com sucesso!");
			}
			
			else {
				veterinarioService.insere(veterinario);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Veterinario alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/veterinario";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Veterinario veterinario = veterinarioService.buscaPorId(codigo);
			veterinarioService.deleta(veterinario);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Veterinario deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/veterinario";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Veterinario veterinario = veterinarioService.buscaPorId(codigo);
			model.addAttribute("veterinario", veterinario);
			List<Especie> especies = especieService.buscaTodos();
			model.addAttribute("especies", especies);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Veterinario alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "veterinario";
	}

}
