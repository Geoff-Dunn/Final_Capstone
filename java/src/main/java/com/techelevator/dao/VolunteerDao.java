package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerDto;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin

public interface VolunteerDao {
    Volunteer getVolunteerById(int id);

    Volunteer updateVolunteer(int id);

    List <Volunteer> getVolunteers(boolean is_active);

    Volunteer createVolunteer(VolunteerDto volunteer);

    List <Volunteer> getAllVolunteers();

}
