package com.example.JaEventos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.JaEventos.DTOs.DTOEvento;
import com.example.JaEventos.Models.ModelEvento;
import com.example.JaEventos.repo.BancoDeDados;
import com.example.JaEventos.repo.ModeloBD;

public class ServiceEvento {
	private ModeloBD bd = BancoDeDados.getInstance();
	
	public ModelEvento createNewEvento(DTOEvento novoEvento) {
		ModelEvento evento = new ModelEvento();
		evento.setNome(novoEvento.getNome());
		evento.setDescricao(novoEvento.getDescricao());
		evento.setFormato(novoEvento.getFormato());
		evento.setDataInicio(novoEvento.getDataInicio());
		evento.setDataFinal(novoEvento.getDataFinal());
		evento.setDisponivel(novoEvento.getDisponivel());
		evento.setLocal(novoEvento.getLocal());
		evento.setListAtividades(new ArrayList<>());
		
		evento.setId(UUID.randomUUID());
		bd.getEventos().add(evento);
		
		return evento;
	}

	
	public List<ModelEvento> getAllEventos(){
		return bd.getEventos();
	}
	
	public Optional<ModelEvento> getOneEvento(UUID id) {
		for (ModelEvento evento : bd.getEventos()) {
			if(evento.getId().equals(id)) {
				return Optional.of(evento);
			}
		}
		
		return Optional.empty();
	}
	
	public boolean deleteOneEvento(UUID id) {
		Optional<ModelEvento> opEvento = getOneEvento(id);
		
		if(opEvento.isPresent()) {
			return bd.getEventos().remove(opEvento.get());
		}else {
			return false;
		}
		
	}

	public ModelEvento updateEvento(UUID id, DTOEvento info) {
		Optional<ModelEvento> evento = getOneEvento(id);
		
		if(evento.isPresent()) {
			evento.get().setNome(info.getNome());
			evento.get().setDescricao(info.getDescricao());
			evento.get().setFormato(info.getFormato());
			evento.get().setDataInicio(info.getDataInicio());
			evento.get().setDataFinal(info.getDataFinal());
			evento.get().setDisponivel(info.getDisponivel());
			evento.get().setLocal(info.getLocal());
		}
		
		return evento.get();
	}


}
