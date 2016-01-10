/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import controller.ControllerImpl;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import model.Chevalet;
import model.Grille;
import static model.Grille.DIM;
import model.Jeton;

/**
 *
 * @author 0404ragrau
 */
public class View implements Observer {
    
    
    private final ControllerImpl ctrl;
    private final Scanner scanner = new Scanner(System.in);
    public Chevalet chev;
    public Grille grille;

    
    
    public View(ControllerImpl ctrl) {
        this.ctrl = ctrl;
        this.chev = ctrl.getChevalet();
        this.grille = ctrl.getGrille();
 

    }

    
    public void affMsg(String msg) {
        System.out.println(msg);
    }

    private void testObs() {
        System.out.println("entrer nombre : ");
        ctrl.fournirChoix(entrerNb("choix : "));
    }
    
    
    public int entrerNb(String msg) {
        affMsg(msg);
        int entree = Integer.parseInt(scanner.next());
        return entree;
    }
    
    public void afficherGrille() {
        
        System.out.println("grille :");
        
        for (int li = 0; li < DIM; li++) {
            System.out.print("|");
            for (int co = 0; co < DIM; co++) {  
                System.out.println(grille.getCase(li,co));  
            }
            System.out.print("|\n");
        }    
    }

    
    public void afficherChevalet() {
        
        System.out.println("chevalet :");
        chev.getJetons();
//        
//        for (Jeton j : chev.getJetons())
//            System.out.print(j.getChar() + " ");
        System.out.print("\n");
//        
    }
    

    public void choisirPosition() {
        
//      Point pt;    
        System.out.println("choisir position (li, co) : ");
        
        int li = scanner.nextInt();
        int co = scanner.nextInt();
        
        while (li < 0 || li > 14 || co < 0 || co > 14) {
            System.out.println("mauvaise position");
            li = scanner.nextInt();
            co = scanner.nextInt();   
        }
        
        ctrl.positionnerLettre(li, co);
        
         
    }
    
    
    public void choisirLettre() {
        
        System.out.println("choisir lettre : ");
        char c = scanner.next().charAt(0);
        
        ctrl.verifierLettre(c);
        
 
    }
    


    // utilisateur va sélectionner une lettre + positions (li,co) à placer sur la grille
    public void placerLettre() {
        
      
    }
    

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Chevalet)
            afficherChevalet();
        else if (o instanceof Grille) {
            afficherGrille();
        }
        choisirPosition();
        choisirLettre();
//        testObs();
//            

    }

    
}