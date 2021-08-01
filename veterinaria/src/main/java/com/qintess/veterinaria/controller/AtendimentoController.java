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
import com.qintess.veterinaria.model.TipoAtendimento;
import com.qintess.veterinaria.model.Veterinario;
import com.qintess.veterinaria.service.AnimalService;
import com.qintess.veterinaria.service.AtendimentoService;
import com.qintess.veterinaria.service.TipoAtendimentoService;
import com.qintess.veterinaria.service.VeterinarioService;

@Controller
@RequestMapping("/atendimento")
public class AtendimentoController {
	
	@Autowired
	private AtendimentoService atendimentoService;
	
	@Autowired
	private TipoAtendimentoService tipoAtendimentoService;
	
	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private VeterinarioService veterinarioService;
	
	@RequestMapping("")
	public String carregaAtendimento(Model model) {
		model.addAttribute("atendimento", new Atendimento());
		model.addAttribute("tipo", new TipoAtendimento());
		model.addAttribute("animal", new Animal());
		model.addAttribute("veterinario", new Veterinario());
		
		List<Atendimento> atendimentos = atendimentoService.buscaTodos();;
		List<TipoAtendimento> tipos = tipoAtendimentoService.buscaTodos();
		List<Animal> animais = animalService.buscaTodos();
		List<Veterinario> veterinarios = veterinarioService.buscaTodos();
		
		model.addAttribute("atendimentos", atendimentos);
		model.addAttribute("tipos", tipos);
		model.addAttribute("animais", animais);
		model.addAttribute("veterinarios", veterinarios);
		
		return "atendimento";
	}
	
	@RequestMapping(value="/salva", method=RequestMethod.POST)
	public String salva(@RequestParam("animal") Animal animal,
			@RequestParam("tipoAtendimento") TipoAtendimento tipo,
			@RequestParam("veterinario") Veterinario veterinario,
		   @ModelAttribute Atendimento atendimento, 
		   RedirectAttributes redirectAtt) {
		
		try {
			
			if(atendimento.getCodigo() == 0) {	
				atendimentoService.insere(atendimento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Atendimento cadastrado com sucesso!");
			}
			
			else {
				atendimentoService.insere(atendimento);
				redirectAtt.addFlashAttribute("mensagemSucesso", "Atendimento alterado com sucesso!");
			}
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
	
		return "redirect:/atendimento";
	}
	
	@RequestMapping("/emergencia")
	public String emergencia(Model model) {
		model.addAttribute("atendimento", new Atendimento());
		return "atendimento";
	}
	
	@RequestMapping("/deleta/{codigo}")
	public String carregaDeletar(@PathVariable(name="codigo") int codigo,
			                     Model model,
			                     RedirectAttributes redirectAtt) {
		
		try {
			
			Atendimento atendimento = atendimentoService.buscaPorId(codigo);
			atendimentoService.deleta(atendimento);
			redirectAtt.addFlashAttribute("mensagemSucesso", "Atendimento deletado com sucesso!");
			
		} catch (Exception e) {
			redirectAtt.addFlashAttribute("mensagemErro", "Erro: " + e.getMessage());
		}
		
			
		
		return "redirect:/atendimento";
	}
	
	


}
