package com.example.android.quadraticequation;


/**
 * Created by Ruqoyah on 29/01/2018.
 * this class test the input for numbers
 * string input are not allowed
 */

public class TestForNumber {
    private String text;

    //constructor
    public TestForNumber(String i) {
        this.text = i;
    }//end constructor

    //method to test if a number is an integer
    public boolean testInput() {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }//end method testInput
}
