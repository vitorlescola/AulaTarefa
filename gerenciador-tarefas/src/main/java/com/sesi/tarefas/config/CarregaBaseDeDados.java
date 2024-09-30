package com.sesi.tarefas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;

@Configuration
public class CarregaBaseDeDados {
	
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	
	@Bean
	CommandLineRunner executar() {
		return ergs ->{
			TarefaCategoria categoria1=new TarefaCategoria();
			categoria1.setNome("teste");
			tarefaCategoriaRepository.save(categoria1);
			
			TarefaCategoria categoria2=new TarefaCategoria();
			categoria2.setNome("teste2");
			tarefaCategoriaRepository.save(categoria2);
		};
	}
	
}