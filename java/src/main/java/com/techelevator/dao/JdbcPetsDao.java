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
        List<Pets> listOfPets = new ArrayList<>();
        String sql = "SELECT * FROM pets;";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
            while (result.next()) {
                Pets pet  = mapRowToPets(result);
                listOfPets.add(pet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return listOfPets;

    }

    @Override
    public Pets updatePets(PetsDto pet) {
        return null;
    }

//    @Override
//    public Pets updatePets() {
//        return null;
//    }
    //...........................................................................


    public List<Pets> getAllAdoptedPets() {
        List<Pets> listOfPets = new ArrayList<>();
        String sql = "SELECT * FROM pets WHERE adopted is true";
        try {
            SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
            while (result.next()) {
                Pets pet  = mapRowToPets(result);
                listOfPets.add(pet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return listOfPets;
    }

    @Override
    public int deletePetById(int petId) {
        int number=0;
        String sql = "DELETE FROM pets WHERE pet_id = ?;";

        try {
            number = jdbcTemplate.update(sql, petId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return number;
    }
//...........................................................................


    public Pets updatePets(Pets pet) {
        Pets updatedpet = null;
        String sql = "UPDATE pets SET pet_name = ?, species = ?, sex = ?, age = ?, spayed_neutered = ?, description = ?, picture = ?, adopted = ? WHERE pet_id = ?;";
        try {
            int rowsAffected = jdbcTemplate.update(sql, pet.getPetName(), pet.getSpecies(), pet.getSex(), pet.getAge(), pet.getIsSpayedNeutered(), pet.getDescription(), pet.getPicture(), pet.getisAdopted(), pet.getPetId());
            if (rowsAffected == 0) {
                throw new DaoException("Pet was not updated, expected at least one change");
            }
            updatedpet = getPetById(pet.getPetId());
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedpet;
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
//...........................................................................

    private Pets getPetById(int petId) {
        Pets petById = null;
        String sql = "SELECT * FROM pets WHERE pet_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);
            if (results.next()) {
                petById = mapRowToPets(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return petById;
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
        pets.setPetId(rowSet.getInt("pet_id"));
        pets.setPetName(rowSet.getString("pet_name"));
        pets.setSpecies(rowSet.getString("species"));
        pets.setSex(rowSet.getString("sex"));
        pets.setAge(rowSet.getString("age"));
        pets.setSpayedNeutered(rowSet.getBoolean("spayed_neutered"));
        pets.setDescription(rowSet.getString("description"));
        pets.setPicture(rowSet.getString("picture"));
        pets.setIsAdopted(rowSet.getBoolean("adopted"));
        return pets;

    }
}

