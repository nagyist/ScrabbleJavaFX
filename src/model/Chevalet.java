
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
    
    public List<Jeton> chev; 
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
        for (Jeton j : chev)
            System.out.println(j.getChar() + " ");

    }
    
   
    private boolean seTrouveDansChev(char c) {

        return chev.contains(c);
            
//        for (Jeton j : chev) {
//            if (j.getChar() == c) {
//                return true;
//            }
//        }
//        return false;
    }
    
    
    public void verifLettre(char c) {
        
        while (!seTrouveDansChev(c)) {
            System.out.println("vous ne possédez pas cette lettre sur votre chevalet");
            c = scanner.next().charAt(0);
        }
    }
        

    
    public void placerMot() {
        
    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }    
}
    
    

