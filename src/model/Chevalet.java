
package model;

import java.util.Observable;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet extends Observable {
    
    // le chevalet est un tableau de jetons
    public Jeton[] chev;
    public int nbJetons;
    
    

    // par défaut, le chevalet est vide
    public Chevalet() {
        this.nbJetons = 0;
        this.chev = new Jeton[7];
        
        for (int i = 0; i < 7 ; ++i) {
            chev[i] = new Jeton();
            ++nbJetons;
        }
        
    }
    
    
    
    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    
//    
//    // methode random qui place 7 jetons au hasard sur le chevalet
//    public DistribJetons() {
//        
//        
//    }
//    
//    
//    // le joueur choisi la lettre qu'il veut placer ainsi que les coordonnées de 
//    // la case où il veut la placer
//    public placerMot() {
//        
//    }
    
}
