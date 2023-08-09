package com.techelevator.controller;

import com.techelevator.dao.JdbcPetsDao;
import com.techelevator.dao.PetsDao;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PetsController {
    private JdbcPetsDao petDao;

    public PetsController(JdbcPetsDao dao) {
        this.petDao = dao;
    }
}
