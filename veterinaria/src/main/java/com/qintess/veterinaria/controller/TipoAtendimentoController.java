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

import com.qintess.veterinaria.model.Animal;
import com.qintess.veterinaria.model.TipoAtendimento;
import com.qintess.veterinaria.service.AnimalService;
import com.qintess.veterinaria.service.TipoAtendimentoService;

@Controller
@RequestMapping("/tipoAtendimento")
public class TipoAtendimentoController {
	
	@Autowired
	private TipoAtendimentoService tipoAtendimentoService;
	
	@RequestMapping("")
	public String carregaTipoAtendimento(Model model) {
		model.addAttribute("tipo", new TipoAtendimento());
		List<TipoAtendimento> tipos = tipoAtendimentoService.buscaTodos();
		model.addAttribute("tipos", tipos);
		return "tipoAtendimento";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(
		   @ModelAttribute TipoAtendimento tipoAtendimento, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(tipoAtendimento.getCodigo() == 0) {	
				tipoAtendimentoService.insere(tipoAtendimento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Tipo de atendimento cadastrado com sucesso!");
			}
			
			else {
				tipoAtendimentoService.insere(tipoAtendimento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Tipo de atendimento alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/tipoAtendimento";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			TipoAtendimento tipoAtendimento = tipoAtendimentoService.buscaPorId(codigo);
			tipoAtendimentoService.deleta(tipoAtendimento);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Tipo de atendimento deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/tipoAtendimento";
	}
	
	@RequestMapping("/altera/{codigo}")
	public String carregaAlterar(@PathVariable(name="codigo") int codigo,
			                     Model model, RedirectAttributes redirectAtt) {
		
		try {
			TipoAtendimento tipo = tipoAtendimentoService.buscaPorId(codigo);
			model.addAttribute("tipo", tipo);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Tipo de atendimento alterado com sucesso!");
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
		return "tipoAtendimento";
	}

}
