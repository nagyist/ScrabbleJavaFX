
package model;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet extends Observable {
    
    private List<Jeton> chev; 
    public int nbJetons;
    private final Scanner scanner = new Scanner(System.in);
    

    public Chevalet() {
        this.nbJetons = 0;
        this.chev = new ArrayList<>();
        
        for (int i = 0; i < 7 ; ++i) {
            chev.add(new Jeton());
            ++nbJetons;
        }    
    }
    
    public void getJetons() {
        for (Jeton j : getChev())
            System.out.print(j.getChar() + "  ");
    }
    
    
    public void removeJeton(Jeton j) {
        chev.remove(j);
    }
    
    public void placerMot() {
        
    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }    

    /**
     * @return the chev
     */
    public List<Jeton> getChev() {
        return chev;
    }
}
    
    

