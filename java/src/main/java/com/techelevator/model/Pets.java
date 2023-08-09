package com.techelevator.model;

public class Pets {
    private String petName;
    private String species;
    private String sex;
    private int age;
    private boolean isSpayedNeutered;
    private String description;
    private String picture;
    private boolean adopted;

    public Pets(String petName, String species, String sex, int age, boolean isSpayedNeutered, String description, String picture, boolean adopted) {
        this.petName = petName;
        this.species = species;
        this.sex = sex;
        this.age= age;
        this.isSpayedNeutered = isSpayedNeutered;
        this.description = description;
        this.picture = picture;
        this.adopted= adopted;
    }

    public String getPetName(){
        return petName;
    }
    public void setPetName(String petName){
        this.petName = petName;
    }
    public String getSpecies(){
        return species;
    }
    public void setSpecies(String species){
        this.species = species;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public boolean setIsSpayedNeutered(){
        return isSpayedNeutered;
    }
    public void setIsSpayedNeutered(boolean isSpayedNeutered){
        this.isSpayedNeutered = isSpayedNeutered;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getPicture(){
        return picture;
    }
    public void setPicture(String picture){
        this.picture = picture;
    }
    public boolean getAdopted(){
        return adopted;
    }
    public void setAdopted(boolean adopted){
        this.adopted = adopted;
    }
}
