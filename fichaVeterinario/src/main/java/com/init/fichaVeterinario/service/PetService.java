package com.init.fichaVeterinario.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.fichaVeterinario.entity.Pet;
import com.init.fichaVeterinario.repository.PetRepository;

@Service
public class PetService {

	@Autowired
	PetRepository petRepository;

	// Método para listar todas las mascotas que tenga la BBDD
	public List<Pet> listPet() {

		List<Pet> list = petRepository.findAll();

		return list;

	}

	// Método para crear mascota
	public Pet createPet(Pet pet) {

		Pet newPet = petRepository.save(pet);
		
		return newPet;

	}
	
	//Método Update
	public String updatePet(long id, Pet pet) {
		
		 Optional<Pet> optionalPet = petRepository.findById(id);
		 
		 String response = "";
		 
		 if(optionalPet.isEmpty()) {
			 response = "Esta mascota no existe";
		 }else{
			 Pet updatePet = optionalPet.get();
			 
			 updatePet.setName(pet.getName());
			 updatePet.setAge(pet.getAge());
			 petRepository.save(updatePet);
			 response = "Usuario actualizado";
			 
		 }
		 
		 
		 return response;
		
	}  
	
	//Método Delete
	public String deletePet(long id) {
		
		 Optional<Pet> optionalPet = petRepository.findById(id);
		 
		 String response = "";
		 
		 if(optionalPet.isEmpty()) {
			 response = "Esta mascota no existe";
		 }else{	
			 Pet deletePet = optionalPet.get();
			 petRepository.delete(deletePet);
			 response = "Mascota borrada";
		 }
		 
		 return response;
	}	
	
	//Método para buscar por Id
	public Optional<Pet> findById(long id) {
		
		 Optional<Pet> optionalPet = petRepository.findById(id);
		 
		 return optionalPet;
		
	}
	
	

}
