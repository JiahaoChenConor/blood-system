package com.elec5619.bloodsystem.domain;

/**
 * The enum Subject.
 */
public enum Subject {


    /**
     * The Blood request.
     */
    NORMAL_CASE("normal case"),
    /**
     * The Urgent request.
     */
    URGENT_CASE("urgent case");


    private String subject;

    private Subject(String s){
        subject = s;
    }


    @Override
    public String toString(){
        return subject;
    }
}
