package com.qintess.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qintess.veterinaria.model.Disponibilidade;
import com.qintess.veterinaria.model.Exame;
import com.qintess.veterinaria.service.DisponibilidadeService;
import com.qintess.veterinaria.service.ExameService;


@Controller
@RequestMapping("/exame")
public class ExameController {
	
	@Autowired
	private ExameService exameService;
	
	@RequestMapping("")
	public String carregaExame(Model model) {
		model.addAttribute("exame", new Exame());
		List<Exame> exames = exameService.buscaTodos();
		model.addAttribute("exames", exames);
		return "exame";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(
		   @ModelAttribute Exame exame, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(exame.getCodigo() == 0) {	
				exameService.insere(exame);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Exame cadastrado com sucesso!");
			}
			
			else {
				exameService.insere(exame);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Exame alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/exame";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Exame exame = exameService.buscaPorId(codigo);
			exameService.deleta(exame);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Exame deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/exame";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Exame exame = exameService.buscaPorId(codigo);
			model.addAttribute("exame", exame);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Exame alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "exame";
	}
	
	

}
