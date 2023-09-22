package com.example.JaEventos.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.JaEventos.DTOs.DTOInscreverse;
import com.example.JaEventos.DTOs.DTOParticipante;
import com.example.JaEventos.Models.ModelAtividade;
import com.example.JaEventos.Models.ModelParticipante;
import com.example.JaEventos.repo.BancoDeDados;
import com.example.JaEventos.repo.ModeloBD;

import ch.qos.logback.core.model.Model;

public class ServiceParticipante {
	private ModeloBD bd = BancoDeDados.getInstance();
	private ServiceAtividade servicoAtv = new ServiceAtividade();
	
	public ModelParticipante postNewParticipante(DTOParticipante novoParticipante) {
		ModelParticipante novoPart = new ModelParticipante();
		
		novoPart.setNome(novoParticipante.getNome());
		novoPart.setId(UUID.randomUUID());
		
		bd.getUsuarios().add(novoPart);
		
		return novoPart;
	}
	
	public List<ModelParticipante> getAllParticipantes(){
		return bd.getUsuarios();
	}
	
	public Optional<ModelParticipante> getOneParticipante(UUID idParticipante) {
		for (ModelParticipante part : bd.getUsuarios()) {
			if(part.getId().equals(idParticipante)) {
				return Optional.of(part);
			}
		}
		
		return Optional.empty();
	}
	
	public boolean postInscricao(DTOInscreverse infos){
		Optional<ModelParticipante> part = getOneParticipante(infos.getIdParticipante());
		ModelAtividade atv = servicoAtv.getOneAtividade(infos.getIdEvento(), infos.getIdAtividade());
		
		return atv.getListParticipantes().add(part.get());
	}
	
}
