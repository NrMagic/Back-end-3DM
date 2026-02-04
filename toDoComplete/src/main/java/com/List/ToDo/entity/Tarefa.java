package com.List.ToDo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_tarefa")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long idUsuario;
	private String nome;
	private String descricao;
	private Status status;
	private LocalDate dtInicio;
	private LocalDate dtFim;

	@ManyToOne
    @JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Tarefa() {

	}

	public Tarefa(long idUsuario, String nome, String descricao, Status status, LocalDate dtInicio, LocalDate dtFim) {
	
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.descricao = descricao;
		this.status = Status.A_FAZER;
		this.dtInicio = LocalDate.now();
		this.dtFim = dtFim;
	}
	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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
