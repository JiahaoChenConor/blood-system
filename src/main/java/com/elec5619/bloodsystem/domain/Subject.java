package com.elec5619.bloodsystem.domain;

/**
 * The enum Subject.
 */
public enum Subject {


    /**
     * The Blood request.
     */
    BLOOD_REQUEST("Blood request"),
    /**
     * The Urgent request.
     */
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
