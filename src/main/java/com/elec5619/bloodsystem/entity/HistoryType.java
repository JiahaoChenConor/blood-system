package com.elec5619.bloodsystem.entity;

public enum HistoryType {
    DONATE("donate"),
    REQUEST("request");


    private String historyType;
    HistoryType(String historyType){
        this.historyType = historyType;
    }


    @Override
    public String toString(){
        return historyType;
    }
}
