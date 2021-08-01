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
import com.qintess.veterinaria.model.Medicamento;
import com.qintess.veterinaria.service.DisponibilidadeService;
import com.qintess.veterinaria.service.ExameService;
import com.qintess.veterinaria.service.MedicamentoService;


@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@RequestMapping("")
	public String carregaExame(Model model) {
		model.addAttribute("medicamento", new Medicamento());
		List<Medicamento> medicamentos = medicamentoService.buscaTodos();
		model.addAttribute("medicamentos", medicamentos);
		return "medicamento";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(
		   @ModelAttribute Medicamento medicamento, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(medicamento.getCodigo() == 0) {	
				medicamentoService.insere(medicamento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Medicamento cadastrado com sucesso!");
			}
			
			else {
				medicamentoService.insere(medicamento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Medicamento alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/medicamento";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Medicamento medicamento = medicamentoService.buscaPorId(codigo);
			medicamentoService.deleta(medicamento);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Medicamento deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/medicamento";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Medicamento medicamento = medicamentoService.buscaPorId(codigo);
			model.addAttribute("medicamento", medicamento);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Medicamento alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "medicamento";
	}
	
	

}
