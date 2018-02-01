package com.example.android.quadraticequation;

/**
 * Created by Ruqoyah on 28/01/2018.
 * This class calculate quadratic equation
 * it accepts three inputs for a, b, and c where a != 0
 * the term discriminant d = b*b - 4*a*c tells the nature of the roots
 * if d is greater than 0, the roots are real and different
 * if d is equal to 0, the roots are real and equal
 * if d is less than 0, the roots are complex and different
 */


public class CalQuadraticEquation {
    private int a, b, c;


    //constructor
    public CalQuadraticEquation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }//end constructor

    //method to calculate discriminant d = b*b -4*a*c
    public double discriminant() {
        double d = b * b - 4 * a * c;
        return d;
    }//end method discriminant

    //method to calculate root with +
    public double root1() {
        double dd = Math.sqrt(discriminant());
        double r1 = (-b + dd) / (2.0 * a);
        String s = String.format("%.2f", r1); //using String.format to format result to 2dp
        return Double.parseDouble(s); //convert the return type back to double
    }//end method root1

    //method to calculate root with -
    public double root2() {
        double dd = Math.sqrt(discriminant());
        double r1 = (-b - dd) / (2.0 * a);
        String s = String.format("%.2f", r1); //using String.format to format result to 2dp
        return Double.parseDouble(s); //convert the return type back to double
    }//end method root2

    //method to calculate quadratic equation
    public double calculateQuadratic() {

        //if discriminant is greater than zero, there are two roots
        if (discriminant() > 0) {
            return -1; //-1 means there is two roots, then root1 and root2 will be called later
        } else if (discriminant() == 0) {//equal roots i.e only one root
            double r1 = (-b) / (2.0 * a);
            String s = String.format("%.2f", r1); //using String.format to format result to 2dp
            return Double.parseDouble(s); //convert the return type back to double
        } else { // no real root
            return 0;
        }
    }//end method calculateQuadratic

}//end class


