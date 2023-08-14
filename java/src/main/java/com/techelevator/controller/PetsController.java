package com.techelevator.controller;



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

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Pets updatePets(@Valid @RequestBody Pets updatePets, @PathVariable int id) {
        updatePets.setPetId(id);
        try {
            Pets updated = PetsDao.updatePets(id);
            return updated;
        }
        //what happens if the ID doesn't exist in the database?
        catch (DaoException ex) {
            //... if I can't update the pets because it doesn't exist...
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet not found.");
            //throw an exception with a HTTP status code (404), and a message
        }
    }

//...........................................................................

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
}

