package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 0404ragrau
 */
public class Mot {

    List<Jeton> motPrincipal = new ArrayList<>();
    List<Mot> lsMots = new ArrayList<>();


    public Mot(List<Jeton> mot) {
        for (Jeton j : mot)
            motPrincipal.add(j);
    }
    
    
    public void addMot(List<Jeton> mot) {
        
    }
    
}
