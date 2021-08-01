package com.qintess.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.qintess.veterinaria.model.Especie;
import com.qintess.veterinaria.service.EspecieService;

@Controller
@RequestMapping("/especie")
public class EspecieController {
	
	@Autowired
	private EspecieService especieService;
	
	@RequestMapping("")
	public String carregaAnimal(Model model) {
		model.addAttribute("especie", new Especie());
		List<Especie> especies = especieService.buscaTodos();
		model.addAttribute("especies", especies);
		return "especie";
	}
	
	@RequestMapping("/salva")
	public String salva(@ModelAttribute Especie especialidade, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(especialidade.getCodigo() == 0) {	
				especieService.insere(especialidade);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Especie cadastrada com sucesso!");
			}
			
			else {
				especieService.insere(especialidade);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Especie alterada com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/especie";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Especie especie = especieService.buscaPorId(codigo);
			especieService.deleta(especie);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Especie deletada com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/especie";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Especie especie = especieService.buscaPorId(codigo);
			model.addAttribute("especie", especie);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Especie alterada com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "especie";
	}

}
