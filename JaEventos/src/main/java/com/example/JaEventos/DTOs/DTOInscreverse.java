package com.example.JaEventos.DTOs;

import java.util.UUID;

public class DTOInscreverse {
	public UUID idEvento;
	public UUID idAtividade;
	public UUID idParticipante;

	public UUID getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(UUID idEvento) {
		this.idEvento = idEvento;
	}

	public UUID getIdAtividade() {
		return idAtividade;
	}

	public void setIdAtividade(UUID idAtividade) {
		this.idAtividade = idAtividade;
	}

	public UUID getIdParticipante() {
		return idParticipante;
	}

	public void setIdParticipante(UUID idParticipante) {
		this.idParticipante = idParticipante;
	}

}
