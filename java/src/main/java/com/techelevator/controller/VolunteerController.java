package com.techelevator.controller;

import com.techelevator.dao.JdbcVolunteerDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerDto;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class VolunteerController {
    private JdbcVolunteerDao VolunteerDao;

    public VolunteerController(JdbcVolunteerDao dao) {
        this.VolunteerDao = dao;
    }

    @CrossOrigin
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/volunteer", method = RequestMethod.POST)
    public Volunteer volunteerSignup(@Valid @RequestBody VolunteerDto newVolunteer) {
        try {
            Volunteer volunteer = VolunteerDao.createVolunteer(newVolunteer);
            return volunteer;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Volunteer registration failed!");
        }

    }



    @CrossOrigin
    @RequestMapping(value = "/volunteer", method = RequestMethod.GET)
    public List<Volunteer> getAllVolunteers() {
        List<Volunteer> volunteers = VolunteerDao.getAllVolunteers();
        return volunteers;
    }
}
