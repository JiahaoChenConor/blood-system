package com.elec5619.bloodsystem.entity;

/**
 * The enum Gender.
 */
public enum Gender {
    /**
     * Male gender.
     */
    MALE("male"),
    /**
     * Female gender.
     */
    FEMALE("female"),
    /**
     * Other gender.
     */
    OTHER("other");


    private String gender;
    Gender(String gender){
        this.gender = gender;
    }


    @Override
    public String toString(){
        return gender;
    }
}
