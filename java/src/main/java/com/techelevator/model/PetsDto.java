package com.techelevator.model;

public class PetsDto {
    private int petId;
    private String petName;
    private String species;
    private String sex;
    private int age;
    private boolean isSpayedNeutered;
    private String description;
    private String picture;
    private boolean isAdopted;

    public void Pets(String petName, String species, String sex, int age, boolean isSpayedNeutered, String description, String picture, boolean isAdopted) {
        this.petName = petName;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.isSpayedNeutered = isSpayedNeutered;
        this.description = description;
        this.picture = picture;
        this.isAdopted = isAdopted;
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

    public boolean isSpayedNeutered() {
        return isSpayedNeutered;
    }

    public int getAge() {
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

    public void setAge(int age) {
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

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petIdd) {
        this.petId = petId;
    }
}
