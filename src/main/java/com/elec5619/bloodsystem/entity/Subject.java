package com.elec5619.bloodsystem.entity;

public enum Subject {


    BLOOD_REQUEST("Blood request"),
    URGENT_REQUEST("urgent request");


    private String subject;

    private Subject(String s){
        subject = s;
    }


    @Override
    public String toString(){
        return subject;
    }
}
