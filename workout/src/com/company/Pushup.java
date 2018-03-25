package com.company;

public class Pushup {

    private String[] progressions = new String[]{"Kneel, Half, Full, "};
    private String currProgression;
    public Pushup() {
    }

    public void setCurrentProgression(String currProgression){
        this.currProgression = currProgression;
    }
    public String getCurrentProgression(){
        return this.currProgression;
    }
}
