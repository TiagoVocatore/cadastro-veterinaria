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
import com.qintess.veterinaria.service.DisponibilidadeService;


@Controller
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {
	
	@Autowired
	private DisponibilidadeService disponibilidadeService;
	
	@RequestMapping("")
	public String carregaTipoAtendimento(Model model) {
		model.addAttribute("disponibilidade", new Disponibilidade());
		List<Disponibilidade> disponibilidades = disponibilidadeService.buscaTodos();
		model.addAttribute("disponibilidades", disponibilidades);
		return "disponibilidade";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(
		   @ModelAttribute Disponibilidade disponibilidade, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(disponibilidade.getCodigo() == 0) {	
				disponibilidadeService.insere(disponibilidade);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Disponibilidade cadastrada com sucesso!");
			}
			
			else {
				disponibilidadeService.insere(disponibilidade);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Disponibilidade alterada com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/disponibilidade";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Disponibilidade disponibilidade = disponibilidadeService.buscaPorId(codigo);
			disponibilidadeService.deleta(disponibilidade);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Disponibilidade deletada com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/disponibilidade";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Disponibilidade disponibilidade = disponibilidadeService.buscaPorId(codigo);
			model.addAttribute("disponibilidade", disponibilidade);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Disponibilidade alterada com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "disponibilidade";
	}
	
	

}
