package com.techelevator.model;

public class Pets {
    private String petName;
    private String species;
    private String sex;
    private int age;
    private boolean isSpayedNeutered;
    private String description;
    private String picture;
    private boolean isAdopted;

    public Pets(String petName, String species, String sex, int age, boolean isSpayedNeutered, String description, String picture, boolean isAdopted) {
        this.petName = petName;
        this.species = species;
        this.sex = sex;
        this.age= age;
        this.isSpayedNeutered = isSpayedNeutered;
        this.description = description;
        this.picture = picture;
        this.isAdopted= isAdopted;
    }

}
