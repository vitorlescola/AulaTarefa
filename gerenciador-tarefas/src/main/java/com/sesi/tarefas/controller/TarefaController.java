package com.sesi.tarefas.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.tarefas.model.Tarefa;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaRepository;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@GetMapping("/listarTarefas")
	public String listarTarefas(Model modelo) {
		modelo.addAttribute("tarefas",tarefaRepository.findAll());
		return "listarTarefas";
	}
	
	@GetMapping("editarTarefa/{id}")
	public String editarTarefa(@PathVariable("id") int id, Model modelo) {
		Optional<Tarefa> usuarioOpt = tarefaRepository.findById(id);
		
		if(usuarioOpt.isPresent()) {
			modelo.addAttribute("tarefa", usuarioOpt.get());
			return "formularioTarefa";
		}else {
			return "redirect:/tarefas/listarTarefa";
		}
	}
	
	@GetMapping("/formularioTarefa")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("tarefa", new Tarefa());
		return "formularioTarefa";
	}
	
	@PostMapping("/salvarTarefa")
	public String salvarTarefa(@ModelAttribute Tarefa tarefa) {
		tarefaRepository.save(tarefa);
		return "redirect:/tarefas/listarTarefas";
	}
	
	@GetMapping("/excluirTarefa/{id}")
	public String excluirTarefa(@PathVariable("id") int id) {
		tarefaRepository.deleteById(id);
		return "redirect:/tarefas/listarTarefas";
	}

}