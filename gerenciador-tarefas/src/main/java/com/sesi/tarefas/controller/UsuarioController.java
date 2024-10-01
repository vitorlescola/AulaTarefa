package com.sesi.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios") //requisição sempre vai começar com /usuarios
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/listarUsuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", usuarioRepository.findAll());
		return "listarUsuarios";
	}
	
	@GetMapping("/formularioUsuario")
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return"formularioUsuario";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(@ModelAttribute Usuario usuario) {
	    usuarioRepository.save(usuario);
	    return "redirect:/usuarios/listarUsuario";
	}
}