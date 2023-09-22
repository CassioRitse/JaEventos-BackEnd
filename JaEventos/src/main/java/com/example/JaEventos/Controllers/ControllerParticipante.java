package com.example.JaEventos.Controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JaEventos.DTOs.DTOEvento;
import com.example.JaEventos.DTOs.DTOInscreverse;
import com.example.JaEventos.DTOs.DTOParticipante;
import com.example.JaEventos.services.ServiceParticipante;

@RequestMapping(value = "/participante")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerParticipante {
	ServiceParticipante servico = new ServiceParticipante();

	@PostMapping()
	public ResponseEntity<Object> postNovoParcipante(@RequestBody DTOParticipante novoParticipante) {
		return ResponseEntity.status(200).body(servico.postNewParticipante(novoParticipante));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllParticipante() {
		return ResponseEntity.status(200).body(servico.getAllParticipantes());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getOneParticipante(@PathVariable(value = "id") UUID id) {
		return ResponseEntity.status(200).body(servico.getOneParticipante(id));
	}

	@PostMapping(value = "/inscreverse")
	public ResponseEntity<Object> postInscreverParticipante(@RequestBody DTOInscreverse infos) {
		return ResponseEntity.status(200).body(servico.postInscricao(infos));
	}

}
