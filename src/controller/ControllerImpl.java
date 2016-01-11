package controller;

import java.util.Scanner;
import model.Chevalet;
import model.Grille;
import model.Jeton;
import view.View;

/**
 *
 * @author 0404ragrau
 */
public class ControllerImpl implements Controller {
    
    
    private final Grille grille = new Grille();
    private final View vue;
    private final Chevalet chevalet = new Chevalet();
    private final Scanner scanner = new Scanner(System.in);
    

    public ControllerImpl() {
        this.vue = new View(this);
        grille.addObserver(vue);
        chevalet.addObserver(vue);
        lancer();
    }

  
    public boolean exists(char c){
        for(Jeton j : chevalet.getChev()){
            if(j.getChar()==c){
                return true;
            }
        }
        return false;
    }
    
    public void verifierLettre(char c) {
        while (!exists(c)) {
            System.out.println("vous ne possédez pas cette lettre sur votre chevalet");
            c = scanner.next().charAt(0);
        }
    }
    
        
    public void positionnerLettre(int li, int co, char c) {
     
        grille.getCase(li, co).setChar(c); 
    }
    
    
    public void lancer() {
        grille.notif();
        chevalet.notif();
//        grille.initGrille();
//        grille.notif();
//        chevalet.notif();
//        grille.initGrille();
//        vue.afficherChevalet();
//        vue.afficherGrille();
//        vue.choisirLettre();
//        vue.choisirPosition();
//        grille.placerLettreGrille();
        
    }
     
    public Chevalet getChevalet() {
        return this.chevalet;
    }
    
    public Grille getGrille() {
        return this.grille;
    }
    

    
    public static void main(String[] args) {
    
        ControllerImpl control = new ControllerImpl();

    }   
}
