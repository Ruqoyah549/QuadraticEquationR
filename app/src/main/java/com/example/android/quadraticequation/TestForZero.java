package com.example.android.quadraticequation;

/**
 * Created by Ruqoyah on 31/01/2018.
 * this class test if an input is zero or not
 * after parsing the string inpput into integer
 */

public class TestForZero {
    private String input;

    public TestForZero(String i) {
        this.input = i;
    }

    public boolean testZero() {
        int i = Integer.parseInt(input);
        if (i == 0) {
            return true;
        } else {
            return false;
        }
    }
}
