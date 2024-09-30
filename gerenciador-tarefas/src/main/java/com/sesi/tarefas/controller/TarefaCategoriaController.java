package com.sesi.tarefas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;

@Controller
public class TarefaCategoriaController {
	
	@Autowired
	TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@GetMapping("/listarCategoria")
	public String listarCategoria(Model modelo) {
		modelo.addAttribute("categorias", tarefaCategoriaRepository.findAll());
		return "listarTarefaCategoria";
	}
	
	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@PathVariable("id") int id, Model modelo) {
		Optional<TarefaCategoria> categoriaOpt=tarefaCategoriaRepository.findById(id);
		if(categoriaOpt.isPresent()) {
			modelo.addAttribute("categoria",categoriaOpt.get());
		}else {
			return "formularioTarefaCategoria";
		}
		return "redirect:/listarTarefaCategoria";
	}
	
	@GetMapping("/formularioTarefaCategoria")
	public String mostrarFormulario() {
		return "formularioTarefaCategoria";
	}
}