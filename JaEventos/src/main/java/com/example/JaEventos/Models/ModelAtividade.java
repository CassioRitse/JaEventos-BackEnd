package com.example.JaEventos.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ModelAtividade {
	private UUID id;
	private String nome;
	private List<ModelParticipante> listParticipantes;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ModelParticipante> getListParticipantes() {
		return listParticipantes;
	}

	public void setListParticipantes() {
		this.listParticipantes = new ArrayList<ModelParticipante>();
	}

}
