package com.techelevator.dao;


import com.techelevator.exception.DaoException;
import com.techelevator.model.Pets;
import com.techelevator.model.PetsDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPetsDao implements PetsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPetsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//...........................................................................


    public List<Pets> getAllPets() {
        List<Pets> ListofPets = new ArrayList<>();
        String sql = "SELECT * FROM pets;";
        try {
            Pets pets = null;
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
            while (result.next()) {
                pets = mapRowToPets(result);
                ListofPets.add(pets);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return ListofPets;
    }
//...........................................................................

    @Override
    public Pets updatePets(int petId) {

        return null;
    }
//...........................................................................

    public Pets createPets(PetsDto pets) {
        Pets newPet =  null;
        String sql = "INSERT INTO pets (pet_name, species, sex, age, spayed_neutered, description, picture, adopted) VALUES (?,?,?,?,?,?,?,?) RETURNING pet_id;";
        try {
            int createdPet = jdbcTemplate.queryForObject(sql, int.class, pets.getPetName(), pets.getSpecies(),pets.getSex(),pets.getAge(),pets.getIsSpayedNeutered(),pets.getDescription(), pets.getPicture(), pets.isAdopted());
            newPet = getPetById(createdPet);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newPet;
    }

    private Pets getPetById(int createdPet) {
        return null;
    }

//...........................................................................

    public List<Pets> getPetsBySpecies(String species) {
        List<Pets> speciesList = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE species = ?;";
        try {
            Pets pets = null;
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql, species);
            while(result.next()) {
                pets = mapRowToPets(result);
                speciesList.add(pets);
            }
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return speciesList;
    }
//...........................................................................





//map
    public Pets mapRowToPets(SqlRowSet rowSet) {
        Pets pets = new Pets();
        pets.setPetName(rowSet.getNString("petName"));
        pets.setSpecies(rowSet.getNString("species"));
        pets.setSex(rowSet.getNString("sex"));
        pets.setAge(rowSet.getInt("age"));
        pets.setSpayedNeutered(rowSet.getBoolean("isSpayedNeutered"));
        pets.setDescription(rowSet.getNString("description"));
        pets.setPicture(rowSet.getNString("picture"));
        pets.setIsAdopted(rowSet.getBoolean("isAdopted"));
        return pets;

    }
}

