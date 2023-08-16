package com.techelevator.controller;



import jdk.jfr.consumer.RecordedEvent;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;



import com.techelevator.dao.JdbcPetsDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Pets;
import com.techelevator.model.PetsDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
public class PetsController {
    private JdbcPetsDao PetsDao;

    public PetsController(JdbcPetsDao dao) {
        this.PetsDao = dao;
    }
//...........................................................................
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Pets> getAllPets() {
        List<Pets> pets = PetsDao.getAllPets();
        return pets;
    }


//...........................................................................
    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Pets updatePets(@Valid @RequestBody Pets updatePets) {
        updatePets.getPetId();
        try {
            Pets updated = PetsDao.updatePets(updatePets);
            return updated;
        }
        catch (DaoException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found.");
        }
    }

//...........................................................................
    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Pets createPets(@Valid @RequestBody PetsDto newpet) {
        try {
            Pets pets= PetsDao.createPets(newpet);
            return pets;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Pet creation failed!");
        }

    }
//...........................................................................


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable int petId) {
        try {
            int petDeleted = PetsDao.deletePetById(petId);
            if (petDeleted == 0) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

