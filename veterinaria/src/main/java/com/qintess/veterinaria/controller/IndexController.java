package com.qintess.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.veterinaria.model.Animal;
import com.qintess.veterinaria.model.Cliente;
import com.qintess.veterinaria.service.AnimalService;

@Controller
public class IndexController {
	
	@Autowired
	private AnimalService animalService;
	
	@RequestMapping("")
	public String carregaIndex() {
		
		return "index";
	}

}
