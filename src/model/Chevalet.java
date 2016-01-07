
package model;


import java.awt.Point;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author 0404ragrau
 */
public class Chevalet extends Observable {
    
    // le chevalet est un tableau de jetons
    public Jeton[] chev;
    public int nbJetons;
    private final Scanner scanner = new Scanner(System.in);
    

    public Chevalet() {
        this.nbJetons = 0;
        this.chev = new Jeton[7];
        
        for (int i = 0; i < 7 ; ++i) {
            chev[i] = new Jeton();
            ++nbJetons;
        }    
    }
    
    public void getJetons() {
        
    }
    
   
    private boolean seTrouveDansChev(char c) {

        for (Jeton j : chev.getJetons()) {
            if (j.getChar() == c) {
                return true;
            }
        }
        return false;
    }
    
    
    public void verifLettre(char c) {
        
        while (!seTrouveDansChev(c)) {
            System.out.println("vous ne possédez pas cette lettre sur votre chevalet");
            c = scanner.next().charAt(0);
        }
    }
        

    
    public void placerMot() {
        
        notif();
    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }    
}
    
    

