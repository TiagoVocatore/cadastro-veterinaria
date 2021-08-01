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
import com.qintess.veterinaria.model.Atendimento;
import com.qintess.veterinaria.model.Cliente;
import com.qintess.veterinaria.model.Especie;
import com.qintess.veterinaria.model.Exame;
import com.qintess.veterinaria.model.Medicamento;
import com.qintess.veterinaria.model.Prontuario;
import com.qintess.veterinaria.model.TipoAtendimento;
import com.qintess.veterinaria.model.Veterinario;
import com.qintess.veterinaria.service.AnimalService;
import com.qintess.veterinaria.service.AtendimentoService;
import com.qintess.veterinaria.service.ExameService;
import com.qintess.veterinaria.service.MedicamentoService;
import com.qintess.veterinaria.service.ProntuarioService;
import com.qintess.veterinaria.service.TipoAtendimentoService;
import com.qintess.veterinaria.service.VeterinarioService;

@Controller
@RequestMapping("/prontuario")
public class ProntuarioController {
	
	@Autowired
	private ProntuarioService prontuarioService;
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private ExameService exameService;
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	
	
	@RequestMapping("")
	public String carregaAtendimento(Model model) {
		model.addAttribute("prontuario", new Prontuario());
		model.addAttribute("atendimento", new Atendimento());
		model.addAttribute("exame", new Exame());
		model.addAttribute("medicamento", new Medicamento());
		
		List<Prontuario> prontuarios = prontuarioService.buscaTodos();;
		List<Atendimento> atendimentos = atendimentoService.buscaTodos();
		List<Exame> exames = exameService.buscaTodos();
		List<Medicamento> medicamentos  = medicamentoService.buscaTodos();
		
		model.addAttribute("prontuarios", prontuarios);
		model.addAttribute("atendimentos", atendimentos);
		model.addAttribute("exames", exames);
		model.addAttribute("medicamentos", medicamentos);
		
		return "prontuario";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(@RequestParam("atendimento") Atendimento atendimento,
			@RequestParam("exames") Exame exame,
			@RequestParam("medicamentos") Medicamento metidamento,
		   @ModelAttribute Prontuario prontuario, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(prontuario.getCodigo() == 0) {	
				prontuarioService.insere(prontuario);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Prontuario cadastrado com sucesso!");
			}
			
			else {
				prontuarioService.insere(prontuario);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Prontuario alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/prontuario";
	}
	

	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Prontuario prontuario = prontuarioService.buscaPorId(codigo);
			prontuarioService.deleta(prontuario);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Prontuario deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/prontuario";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			Prontuario prontuario = prontuarioService.buscaPorId(codigo);
			model.addAttribute("prontuario", prontuario);
			List<Prontuario> prontuarios = prontuarioService.buscaTodos();
			model.addAttribute("prontuarios", prontuarios);
			Atendimento atendimento =  atendimentoService.buscaPorId(codigo);
			model.addAttribute("atendimento", atendimento);
			List<Atendimento> atendimentos = atendimentoService.buscaTodos();
			model.addAttribute("atendimentos", atendimentos);
			Medicamento medicamento =  medicamentoService.buscaPorId(codigo);
			model.addAttribute("medicamento", medicamento);
			List<Medicamento> medicamentos = medicamentoService.buscaTodos();
			model.addAttribute("medicamentos", medicamentos);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Prontuario alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "prontuario";
	}


}
