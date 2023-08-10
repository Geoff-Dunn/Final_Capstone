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
@CrossOrigin
@RestController
public class VolunteerController {
    private JdbcVolunteerDao VolunteerDao;
    public  VolunteerController(JdbcVolunteerDao dao) {
        this.VolunteerDao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="/volunteer", method= RequestMethod.POST)
    public Volunteer volunteerSignup(@Valid @RequestBody VolunteerDto newVolunteer) {
//        Volunteer volunteer;
        try {
            Volunteer volunteer = VolunteerDao.createVolunteer(newVolunteer);
//            if (volunteer == null) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Volunteer registration failed!");
//            }
            return volunteer;
        } catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Volunteer registration failed!");
        }

    }


//    @RequestMapping(value = "/volunteer", method = RequestMethod.GET)
//    public List<Volunteer> getVolunteers() {
//        List<Volunteer> volunteers = VolunteerDao.getVolunteers();
//        return volunteers;
//    }
}
