package com.sesi.tarefas.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sesi.tarefas.model.Prioridade;
import com.sesi.tarefas.model.StatusTarefa;
import com.sesi.tarefas.model.Tarefa;
import com.sesi.tarefas.model.TarefaCategoria;
import com.sesi.tarefas.model.Usuario;
import com.sesi.tarefas.repository.TarefaCategoriaRepository;
import com.sesi.tarefas.repository.TarefaRepository;
import com.sesi.tarefas.repository.UsuarioRepository;

@Configuration
public class CarregaBaseDeDados {
	
	@Autowired
	private TarefaCategoriaRepository tarefaCategoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private TarefaRepository tarefaRepository; 
	
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
			categoria1.setNome("estudo");
			tarefaCategoriaRepository.save(categoria1);
			
			TarefaCategoria categoria2=new TarefaCategoria();
			categoria2.setNome("pesquisa");
			tarefaCategoriaRepository.save(categoria2);
			
			Tarefa tarefa1=new Tarefa();
			tarefa1.setDescriçao("estudar");
			tarefa1.setStatus(StatusTarefa.A_fazer);
			tarefa1.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa1.setPrioridade(Prioridade.Media);
			tarefa1.setVisivel(true);
			tarefa1.setCategoria(categoria1);
			tarefa1.setUsuario(usuario1);
			tarefaRepository.save(tarefa1);
			
			Tarefa tarefa2=new Tarefa();
			tarefa2.setDescriçao("estudar spring security");
			tarefa2.setStatus(StatusTarefa.A_fazer);
			tarefa2.setDataEntrega(LocalDate.now().plusDays(1));
			tarefa2.setPrioridade(Prioridade.Media);
			tarefa2.setVisivel(true);
			tarefa2.setCategoria(categoria1);
			tarefa2.setUsuario(usuario2);
			tarefaRepository.save(tarefa2);
		};
	}
}