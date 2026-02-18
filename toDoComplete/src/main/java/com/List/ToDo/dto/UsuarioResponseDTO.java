package com.List.ToDo.dto;

import java.util.stream.Collectors;

import com.List.ToDo.entity.Usuario;

import java.util.List;

public class UsuarioResponseDTO {
	private long id;
	private String nome;
	private String email;
	private List<TarefaResponseDTO> tarefas;


	public UsuarioResponseDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		 // Converter a lista de tarefas da entidade para DTO
        this.tarefas = usuario.getTarefas()
                              .stream()
                              .map(TarefaResponseDTO::new)
                             .collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<TarefaResponseDTO> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<TarefaResponseDTO> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public String toString() {
		return "Usuário criado! " + "Nome=" + nome + ", Email=" + email;
	}

}
