package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {
    Volunteer newVolunteer(Volunteer volunteer);
    Volunteer getVolunteerById(int id);
    List<Volunteer>getVolunteers(boolean is_active);
}
