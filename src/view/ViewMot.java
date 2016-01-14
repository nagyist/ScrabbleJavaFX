/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.List;
import model.Jeton;
import model.Mot;

/**
 *
 * @author 0404ragrau
 */
public class ViewMot {
    
    private List<Jeton> mot;
    
    public ViewMot(Mot m) {
        this.mot = m.getMot();
    }
   
    public void afficherMot() {
        for (Jeton j : mot)
            System.out.print(j.getChar());
    } 
}
