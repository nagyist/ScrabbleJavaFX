package model;

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
            chev.add(sac.getRandomJeton());

//            chev.add(new Jeton(sac.getRandomLettre(), 0, 0));
        }    
    }
     
    public List<Jeton> getChev() {
        return chev;
    }
    
    // ne peut etre appelé que si c est dans le chevalet    
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
//                System.out.println("TROUVE ET RETIRE : " + j.getChar());
                return;
            }
        }       
    }
    
    public void rechargerChevalet(Sac sac) {
        
        
        chev.add(sac.getRandomJeton());
//        char c = sac.getRandomLettre();
//        System.out.println("Jeton généré : " + c);
//        chev.add(new Jeton(c, 0, 0));
    }

    public void notif() {
        setChanged();
        notifyObservers();
    }
}
    
    

