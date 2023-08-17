package com.techelevator.dao;

import com.techelevator.model.Pets;
import com.techelevator.model.PetsDto;

import java.util.List;



public interface PetsDao {
    List <Pets> getAllPets();

    Pets updatePets(PetsDto pet);

    Pets createPets(PetsDto pets);

    List<Pets> getPetsBySpecies(String species);

    List<Pets> getAllAdoptedPets();

    int deletePetById(int id);

}
