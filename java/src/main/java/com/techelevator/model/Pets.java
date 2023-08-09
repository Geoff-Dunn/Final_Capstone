package com.techelevator.model;

public class Pets {
    private String petName;
    private String species;
    private String sex;
    private int age;
    private boolean isSpayedNeutered;
    private String description;
    private boolean picture;
    private boolean adopted;

    public Pets(String petName, String species, String sex, int age, boolean isSpayedNeutered, String description, boolean picture, boolean adopted) {
        this.petName = petName;
        this.species = species;
        this.sex = sex;
        this.age= age;
        this.isSpayedNeutered = isSpayedNeutered;
        this.description = description;
        this.picture = picture;
        this.adopted= adopted;
    }
    
}
