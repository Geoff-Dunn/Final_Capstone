package com.techelevator.model;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin

public class VolunteerDto {
    public String fullName;
    public int age;
    public String phoneNumber;
    public String address;
    public String email;
    public String role;
    public boolean isActive;



    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber =phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail(){
        return address;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getRole(){
        return role;
    }
    public void setRole(String role){
        this.role = role;
    }
    public boolean getisActive() {
        return isActive;
    }
    public void setIsActive(boolean isActive) {
        this.isActive = this.isActive;
    }
}
