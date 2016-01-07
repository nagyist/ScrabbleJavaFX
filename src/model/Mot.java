/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 0404ragrau
 */
public class Mot {
    
    List<Jeton> mot = new ArrayList<>();

    public Mot(List<Jeton> mot) {
        this.mot = mot;
    }
    
    public void ajouterLettre(Jeton j) {
        mot.add(j);
        
    }
    
    
    
}
