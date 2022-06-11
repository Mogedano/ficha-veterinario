package com.init.fichaVeterinario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.fichaVeterinario.entity.Pet;

@Repository  //Sin esto el programa no guarda en BBDD
public interface PetRepository extends JpaRepository<Pet, Long>{

}
