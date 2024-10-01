package com.sesi.tarefas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;
import com.sesi.tarefas.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {
	
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Bean
	CommandLineRunner executar() {
		return ergs ->{
			Usuario usuario1=new Usuario();
			usuario1.setNome("Fulano");
			usuario1.setSenha("senha123");
			usuarioRepository.save(usuario1);
			
			Usuario usuario2=new Usuario();
			usuario2.setNome("Fulana");
			usuario2.setSenha("senha456");
			usuarioRepository.save(usuario2);
			
			TarefaCategoria categoria1=new TarefaCategoria();
			categoria1.setNome("teste");
			tarefaCategoriaRepository.save(categoria1);
			
			TarefaCategoria categoria2=new TarefaCategoria();
			categoria2.setNome("teste2");
			tarefaCategoriaRepository.save(categoria2);
		};
	}
}