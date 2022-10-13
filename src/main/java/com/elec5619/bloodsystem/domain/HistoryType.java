package com.elec5619.bloodsystem.domain;

/**
 * The enum History type.
 */
public enum HistoryType {
    /**
     * Donate history type.
     */
    DONATE("donate"),
    /**
     * Request history type.
     */
    REQUEST("request"),

    /**
     * Urgent history type.
     */
    URGENT("urgent");


    private String historyType;
    HistoryType(String historyType){
        this.historyType = historyType;
    }


    @Override
    public String toString(){
        return historyType;
    }
}
