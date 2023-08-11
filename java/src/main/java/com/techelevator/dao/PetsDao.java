package com.techelevator.dao;

import com.techelevator.model.Pets;
<<<<<<< HEAD

import java.util.List;

public interface PetsDao {
    List<Pets> getPetsBySpecies(String species);
    List<Pets> modifyPetsById(int petId);


=======
import com.techelevator.model.PetsDto;

import javax.validation.Valid;
import java.util.List;

public interface PetsDao {
    List<Pets> getAllPets();

    Pets updatePets(int petId);

    Pets createPets(PetsDto pets);

    List<Pets> getPetsBySpecies(String species);
>>>>>>> 1c1292ded90c3d1a3f74d5bbd647e1dfe4b867d1
}
