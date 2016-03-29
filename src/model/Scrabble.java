package model;

import controllerGUI.ControllerGUI;
import java.util.Observable;

/**
 *
 * @author raphaelgrau
 */
public class Scrabble extends Observable {
    
    private final Grille grille;
    private final Chevalet chev;
    
    public Scrabble(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
        this.chev = ctrl.getChevalet();
    }
    
    public void placerLettre(int x, int y, Jeton j) {
        grille.setCase(x, y, j.getChar());
//        notif()
                ;
    }
    
    public void removeJeton(Jeton j) {
        chev.removeJeton(j);
//        notif()
                ;
    }
    
    public void rechargerChevalet(Sac sac) {
        chev.rechargerChevalet(sac);
        notif();
    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }
    
    
}
