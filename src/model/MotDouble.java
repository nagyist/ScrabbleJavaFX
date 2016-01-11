/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author 0404ragrau
 */
public class MotDouble extends Case {
    
    private static final String MOTDOUBLE = "\u001b[45m"; 
    private static final String RESET = "\u001B[0m";
    

    @Override
    public char getChar() {
        return lettre;
    }
    
    @Override
    public String toString() {
        return MOTDOUBLE + " " + lettre + " " + RESET;
    }
    
}
