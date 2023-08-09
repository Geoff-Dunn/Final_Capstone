package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerDto;

import java.util.List;

public interface VolunteerDao {
    Volunteer getVolunteerById(int id);
    List <Volunteer> getVolunteers();
    Volunteer createVolunteer(VolunteerDto volunteer);
}