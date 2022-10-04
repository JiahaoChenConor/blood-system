package com.elec5619.bloodsystem.entity;

/**
 * The enum Blood type.
 */
public enum BloodType {
    /**
     * A blood type.
     */
    A("A"),
    /**
     * B blood type.
     */
    B("B"),
    /**
     * Ab blood type.
     */
    AB("AB"),
    /**
     * O blood type.
     */
    O("O");


    private String bloodType;
    BloodType(String bloodType){
        this.bloodType = bloodType;
    }


    @Override
    public String toString(){
        return bloodType;
    }
}
