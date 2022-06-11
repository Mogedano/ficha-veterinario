package com.init.fichaVeterinario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.init.fichaVeterinario.entity.Pet;
import com.init.fichaVeterinario.service.PetService;

@RestController
@RequestMapping("/Pet")
public class PetController {

	@Autowired // Me traigo los métodos de PetService
	PetService petService;

	// Listar mascotas
	@GetMapping(value = "/listPet") // Para listar hacemos un Get
	public ResponseEntity<List<Pet>> listPet() {
		try {
			List<Pet> listPet = petService.listPet();
			return new ResponseEntity<List<Pet>>(listPet, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// Crear mascota
	@PostMapping(value = "/createPet") // Para crear hacemos un Post
	public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
		try {
			Pet newPet = petService.createPet(pet);
			return new ResponseEntity<Pet>(newPet, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// Updatear mascota
	@PutMapping(value = "/updatePet/{id}") // Para updatear hacemos un Put
	public ResponseEntity<String> updatePet(@PathVariable long id, @RequestBody Pet pet) {
		try {
			String response = petService.updatePet(id, pet);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

	}

	// Delete mascota
	@DeleteMapping(value = "/deletePet/{id}") // Para borrar hacemos un Delete
	public ResponseEntity<String> deletePet(@PathVariable long id) {
		try {
			String response = petService.deletePet(id);
			return new ResponseEntity<String>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}

	}

	// Buscar mascota por Id
	@GetMapping(value = "/findPet/{id}") // Para buscar hacemos un Get
	public ResponseEntity<?> findPet(@PathVariable long id) {
		try {
			Optional<Pet> optionalPet = petService.findById(id);
			if (optionalPet.isEmpty()) {
				String response = "Esta mascota no existe";
				return new ResponseEntity<String>(response, HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Pet>(optionalPet.get(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);

		}

	}

}
