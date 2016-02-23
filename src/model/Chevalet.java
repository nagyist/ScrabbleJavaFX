package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet extends Observable {
    
    private final List<Jeton> chev; 
    private final Scanner scanner = new Scanner(System.in);
    

    public Chevalet() {
        this.chev = new ArrayList<>();
        
        for (int i = 0; i < 7 ; ++i) {
            chev.add(new Jeton());
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
    
    

