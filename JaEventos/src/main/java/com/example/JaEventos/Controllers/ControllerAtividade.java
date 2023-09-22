package com.example.JaEventos.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JaEventos.DTOs.DTOAtividade;
import com.example.JaEventos.DTOs.DTOEvento;
import com.example.JaEventos.Models.ModelAtividade;
import com.example.JaEventos.services.ServiceAtividade;

@RequestMapping(value = "/atividade")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerAtividade {
	ServiceAtividade serviceAtividade = new ServiceAtividade();
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Object> postNovaAtividade(
			@PathVariable(value = "id") UUID id,
			@RequestBody DTOAtividade novaAtividade) {
		return ResponseEntity.status(200).body(serviceAtividade.createNovaAtividade(id, novaAtividade));
	}
	

	@GetMapping(value = "/{idEvento}/{idAtividade}")
	public ResponseEntity<Object> getAtividade(
			@PathVariable(value = "idEvento") UUID id,
			@PathVariable(value = "idEvento") UUID atv) {
		return ResponseEntity.status(200).body(serviceAtividade.getOneAtividade(id, atv));
	}
	
	@DeleteMapping(value = "/{idEvento}/{idAtividade}")
	public ResponseEntity<Object> deleteAtividade(
			@PathVariable(value = "idEvento") UUID id,
			@PathVariable(value = "idEvento") UUID atv) {
		return ResponseEntity.status(200).body(serviceAtividade.deleteOneAtividade(id, atv));
	}
	
	
	
}
