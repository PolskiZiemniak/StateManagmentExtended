package com.example.statemanagmentextended;

public class StateViewModel extends androidx.lifecycle.ViewModel {
    private int counter = 0;
    private String text = "";
    private Boolean isChecked = false;
    private Boolean isSwitched = false;

    public int getCounter(){
        return counter;
    }
    public String getText(){
        return text;
    }
    public Boolean getIsChecked(){
        return isChecked;
    }
    public Boolean getIsSwitched(){
        return isSwitched;
    }


    public void setText(String text) {
        this.text = text;
    }
    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
    public void setSwitched(Boolean switched) {
        isSwitched = switched;
    }


    public void incrementCount(){
        counter++;
    }
}
