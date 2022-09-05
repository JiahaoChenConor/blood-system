package com.elec5619.bloodsystem.entity;

public enum Gender {
    MALE("male"),
    FEMALE("female");


    private String gender;
    Gender(String gender){
        this.gender = gender;
    }


    @Override
    public String toString(){
        return gender;
    }
}
