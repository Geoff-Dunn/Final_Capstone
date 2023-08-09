package com.techelevator.controller;

import com.techelevator.dao.JdbcVolunteerDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class VolunteerController {
    private JdbcVolunteerDao volunteerDao;
    public  VolunteerController(JdbcVolunteerDao dao) {
        this.volunteerDao = dao;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value ="/volunteer", method= RequestMethod.POST)
    public Volunteer volunteerSignup(@RequestBody Volunteer volunteer) {
        return VolunteerDao.newVolunteer(volunteer);
    }

    @RequestMapping(value = "/volunteer/list", method = RequestMethod.GET)
    public  List<Volunteer> getVolunteers(@PathVariable int volunteer) {

    }
}
