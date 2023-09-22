package com.example.JaEventos.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JaEventos.DTOs.DTOEvento;
import com.example.JaEventos.Models.ModelEvento;
import com.example.JaEventos.services.ServiceEvento;

@RequestMapping(value = "/evento")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ControllerEvento {
	ServiceEvento serviceEvento = new ServiceEvento();
	
	@PostMapping()
	public ResponseEntity<Object> postNovoEvento(@RequestBody @Validated DTOEvento novoEvento) {
		return ResponseEntity.status(200).body(serviceEvento.createNewEvento(novoEvento));
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<Object> getAllEvento() {
		return ResponseEntity.status(200).body(serviceEvento.getAllEventos());
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getEvento(@PathVariable(value = "id") UUID id) {
		Optional<ModelEvento> opEvento =  serviceEvento.getOneEvento(id);
		
		if(opEvento.isPresent()) {
			return ResponseEntity.status(200).body(opEvento.get());
		}
		
		//if(opEvento.isEmpty()) {
			return ResponseEntity.status(200).body("não existe");
		//}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Object> putEvento(
			@PathVariable(value = "id") UUID id,
			@RequestBody DTOEvento novoEvento) {
		return ResponseEntity.status(200).body(serviceEvento.updateEvento(id, novoEvento));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> putEvento(@PathVariable(value = "id") UUID id) {
		return ResponseEntity.status(200).body(serviceEvento.deleteOneEvento(id));
	}
	
	
	
	
	
}
