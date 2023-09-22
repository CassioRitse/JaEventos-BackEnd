package com.example.JaEventos.services;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import com.example.JaEventos.DTOs.DTOAtividade;
import com.example.JaEventos.Models.ModelAtividade;
import com.example.JaEventos.Models.ModelEvento;
import com.example.JaEventos.Models.ModelParticipante;
import com.example.JaEventos.repo.BancoDeDados;
import com.example.JaEventos.repo.ModeloBD;

public class ServiceAtividade {
	private ModeloBD bd = BancoDeDados.getInstance();
	private ServiceEvento servicoEvento = new ServiceEvento();
	
	public ModelAtividade createNovaAtividade(UUID id, DTOAtividade atividade) {
		Optional<ModelEvento> evento = servicoEvento.getOneEvento(id);
		ModelAtividade novaAtv = new ModelAtividade();
		
		if(evento.isPresent()) {
			novaAtv.setId(UUID.randomUUID());
			novaAtv.setNome(atividade.getNome());
			novaAtv.setId(UUID.randomUUID());
			novaAtv.setListParticipantes();
			evento.get().getListAtividades().add(novaAtv);
		}
		
		return novaAtv;
	}
	
	public ModelAtividade getOneAtividade(UUID idevento, UUID idatividade) {
		for (ModelEvento evento : servicoEvento.getAllEventos()) {
			if(evento.getId().equals(idevento)) {
				for (ModelAtividade atv : evento.getListAtividades()) {
					if(atv.getId().equals(idatividade)) {
						return atv;
					}
				}
			}
		}
		
		return null;
	}
	
	
	public boolean deleteOneAtividade(UUID idevento, UUID idatividade) {
		Optional<ModelEvento> evento = servicoEvento.getOneEvento(idevento);
		ModelAtividade atv  = getOneAtividade(idevento, idatividade);
		return evento.get().getListAtividades().remove(atv);
	}
}
