package com.elec5619.bloodsystem.entity;

public enum BloodType {
    A("A"),
    B("B"),
    AB("AB"),
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
