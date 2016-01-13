package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author 0404ragrau
 */
public class Mot {
    
    List<Jeton> mot = new ArrayList<>();

    public Mot() {
        this.mot = mot;
    }
    
    public void ajouterJetonMot(Jeton j) {
        mot.add(j);
        
    }
    
    public void afficherMot() {
        for (Jeton j : mot)
            System.out.print(j.getChar());
    }
    
    
    
    
    
}
