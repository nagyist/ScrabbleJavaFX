/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Random;

/**
 *
 * @author 0404ragrau
 */
public class Jeton {
    
    
    private static final char[] lettres = {'*','a','b','c','d','e','f','g','h','i','j','k','l','m','n'+
                                'o','p','q','r','s','t','u','v','w','x','y','z'};
    private final char lettre;

   
    public Jeton() {
        
        Random rand = new Random();
        int n = rand.nextInt(26);
        this.lettre = lettres[n];

    }
    
    public char getChar() {
        return lettre;
    }


}
