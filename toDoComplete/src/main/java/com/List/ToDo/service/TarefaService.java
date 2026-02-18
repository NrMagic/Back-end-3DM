package com.List.ToDo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.List.ToDo.entity.Status;
import com.List.ToDo.dto.TarefaRequestDTO;
import com.List.ToDo.dto.TarefaResponseDTO;
import com.List.ToDo.entity.Tarefa;
import com.List.ToDo.entity.Usuario;
import com.List.ToDo.repository.TarefaRepository;
import com.List.ToDo.repository.UsuarioRepository;

@Service
public class TarefaService {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TarefaRepository tarefaRepository;


	// criar tarefa
	public TarefaResponseDTO saveTask(TarefaRequestDTO tarefaRequestDTO) {

		Usuario usuario = usuarioRepository.findById(tarefaRequestDTO.getIdUsuario())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		
		Tarefa tarefa = new Tarefa(
		 usuario,
		 tarefaRequestDTO.getNome(),
		 tarefaRequestDTO.getDescricao(),
		 Status.A_FAZER, 
		 tarefaRequestDTO.getDtInicio(), 
		 tarefaRequestDTO.getDtFim());

		

		tarefaRepository.save(tarefa);

		TarefaResponseDTO task = new TarefaResponseDTO(tarefa);

		return task;
	}

	// mostrar as tarefas
	public List<TarefaResponseDTO> mostrar() {
		List<Tarefa> tarefas = tarefaRepository.findAll();
		List<TarefaResponseDTO> listaDeTarefas = tarefas.stream().map(TarefaResponseDTO::new).toList();

		return listaDeTarefas;
	}

	// atualizar status da tarefa
	public String atualizar(int id, Tarefa novaTarefa) {
		Optional<Tarefa> TarefaExistente = tarefaRepository.findById(id);

		if (TarefaExistente.isPresent()) {
			Tarefa Tarefa = TarefaExistente.get();
			Tarefa.setStatus(novaTarefa.getStatus());

			tarefaRepository.save(Tarefa);

			TarefaResponseDTO dto = new TarefaResponseDTO(Tarefa);

			return dto.toString();
		} else {
			return "Não foi achado a tarefa.";
		}
	}

	// deletar tarefa
	public String deleteTarefa(int id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isPresent()) {
			tarefaRepository.deleteById(id);
			return "Tarefa deletada com sucesso.";
		} else {
			return "Esse ID não existe.";
		}
	}
	
	public String searchById(int id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);

		if (tarefa.isPresent()) {
			TarefaResponseDTO dto = new TarefaResponseDTO(tarefa.get());
			return dto.toString();
		} else {
			return "Esse ID não existe.";
		}
	}
}
