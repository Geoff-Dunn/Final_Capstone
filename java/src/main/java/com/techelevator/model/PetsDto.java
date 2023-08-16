package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PetsDto {
    private int petId;
    private String petName;
    private String species;
    private String sex;
    private String age;
    private boolean isSpayedNeutered;
    private String description;
    private String picture;
    private boolean isAdopted;

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public boolean getIsSpayedNeutered() {
        return isSpayedNeutered;
    }

    public String getPetName() {
        return petName;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public boolean sSpayedNeutered() {
        return isSpayedNeutered;
    }

    public String getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public String getSex() {
        return sex;
    }

    public String getSpecies() {
        return species;
    }

    public void setIsAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSpayedNeutered(boolean spayedNeutered) {
        isSpayedNeutered = spayedNeutered;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean getisAdopted() {
        return isAdopted;
    }

//    public int getPetId() {
//        return petId;
//    }
//
//    public void setPetId(int petIdd) {
//        this.petId = petId;
//    }
}
