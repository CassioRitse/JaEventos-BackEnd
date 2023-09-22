package com.example.JaEventos.Models;

import java.util.UUID;

public class ModelParticipante {
	UUID id;
	String nome;
	
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
}
