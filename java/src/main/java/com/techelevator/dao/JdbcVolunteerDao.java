package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Volunteer;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.VolunteerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Volunteer createVolunteer(VolunteerDto volunteer) {
        Volunteer volunteerSignup =  null;
        String sql = "INSERT INTO volunteersignup (name, age, phone_number, address, email, is_active) VALUES (?,?,?,?,?,?) RETURNING volunteer_id;";
        try {
            int newVolunteerid = jdbcTemplate.queryForObject(sql, int.class, volunteer.getFullName(),volunteer.getAge(),volunteer.getPhoneNumber(), volunteer.getAddress(), volunteer.getEmail(), volunteer.getisActive());
            volunteerSignup = getVolunteerById(newVolunteerid);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return volunteerSignup;
    }
    public List<Volunteer> getVolunteers(boolean is_active) {
        List<Volunteer> volunteers = new ArrayList<>();
        String sql = "SELECT name, age, phone_number, address, email, isActive FROM volunteersignup WHERE is_active = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, is_active);
            while (results.next()) {
                Volunteer volunteer = mapRowtoVolunteer(results);
                volunteers.add(volunteer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return volunteers;
    }

    @Override
    public Volunteer getVolunteerById(int id) {
        return null;
    }






    private Volunteer mapRowtoVolunteer(SqlRowSet rs) {
        Volunteer volunteer = new Volunteer();
        volunteer.setFullName(rs.getString("volunteer_id"));
        volunteer.setAddress(rs.getString("address"));
        volunteer.setAge(rs.getInt("age"));
        volunteer.setIsActive(rs.getBoolean("is_active"));
        volunteer.setPhoneNumber((rs.getString("phone_Number")));
        volunteer.setRole(rs.getString("role"));
        return volunteer;
    }
}
