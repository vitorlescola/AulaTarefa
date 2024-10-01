package com.sesi.tarefas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;

@Configuration
public class CarregaBaseDeDados {
	
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Bean
	CommandLineRunner executar() {
		return ergs ->{
			Usuario usuario=new Usuario();
			usuario.setNome("Fulano");
			usuario.setSenha("senha123");
			
			Usuario usuario2=new Usuario();
			usuario.setNome("Fulana");
			usuario.setSenha("senha456");
			
			TarefaCategoria categoria1=new TarefaCategoria();
			categoria1.setNome("teste");
			tarefaCategoriaRepository.save(categoria1);
			
			TarefaCategoria categoria2=new TarefaCategoria();
			categoria2.setNome("teste2");
			tarefaCategoriaRepository.save(categoria2);
		};
	}
	
}