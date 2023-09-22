package com.example.JaEventos.repo;

import java.util.ArrayList;
import java.util.List;

import com.example.JaEventos.Models.ModelEvento;
import com.example.JaEventos.Models.ModelParticipante;

public class ModeloBD {
	private List<ModelEvento> eventos;
	private List<ModelParticipante> usuarios;

	public ModeloBD() {
		this.eventos = new ArrayList<ModelEvento>();
		this.usuarios = new ArrayList<ModelParticipante>();
	}

	public List<ModelEvento> getEventos() {
		return eventos;
	}

	public void setEventos(List<ModelEvento> eventos) {
		this.eventos = eventos;
	}

	public List<ModelParticipante> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<ModelParticipante> usuarios) {
		this.usuarios = usuarios;
	}

}
