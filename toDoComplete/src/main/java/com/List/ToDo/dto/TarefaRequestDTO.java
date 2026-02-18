package com.List.ToDo.dto;

import java.time.LocalDate;

import com.List.ToDo.entity.Status;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TarefaRequestDTO {

	@NotNull
	private int idUsuario;

	@NotBlank(message = "O nome não pode ser vazio e/ou nulo.")
	private String nome;
	@NotBlank(message = "A descrição não pode ser vazia e/ou nula.")
	private String descricao;
//	@NotBlank(message = "O status não pode ser vazio e/ou nulo.")
	private Status status;
//	@NotBlank(message = "A data de início não pode ser vazia e/ou nula.")
	private LocalDate dtInicio;
//	@NotBlank(message = "A data de fim não pode ser vazia e/ou nula.")
	private LocalDate dtFim;

	public TarefaRequestDTO() {

	}

	public TarefaRequestDTO(int idUsuario , String nome, String descricao, Status status, LocalDate dtInicio, LocalDate dtFim) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.descricao = descricao;
		this.status = status;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}
	
		public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDate getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(LocalDate dtInicio) {
		this.dtInicio = dtInicio;
	}

	public LocalDate getDtFim() {
		return dtFim;
	}

	public void setDtFim(LocalDate dtFim) {
		this.dtFim = dtFim;
	}

}
