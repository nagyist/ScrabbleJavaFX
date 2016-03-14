package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet extends Observable {
    
    private final List<Jeton> chev = new ArrayList<>(); 
    private final int CHEV_SIZE = 7;
    

    public Chevalet(Sac sac) {
        
        for (int i = 0; i < CHEV_SIZE ; ++i) {
            chev.add(new Jeton(sac.getRandomLettre()));
        }    
    }
     
    
    public List<Jeton> getChev() {
        return chev;
    }
    
    
    // ne peut etre appelé que si ch est dans le chevalet    
    public Jeton getJeton(char c) {
        for (Jeton j : chev)
            if (j.getChar() == c) {
                return j;
            }
        throw new RuntimeException();
    }
    
    
    public void removeJeton(Jeton jj) {
        for (Iterator<Jeton> it = chev.iterator(); it.hasNext(); ) {
            Jeton j = it.next();
            if (j == jj) {
                it.remove();
                return;
            }
        }       
    }


    public void notif() {
        setChanged();
        notifyObservers();
    }
}
    
    

