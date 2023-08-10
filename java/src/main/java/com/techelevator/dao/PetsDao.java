package com.techelevator.dao;

import com.techelevator.model.Pets;

import java.util.List;

public interface PetsDao {
    List<Pets> getPetsBySpecies(String species);
    List<Pets> modifyPetsById(int petId);


}
