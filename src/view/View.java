/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import controller.Controller;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author 0404ragrau
 */
public class View implements Observer {
    
    
    private final Controller ctrl;
    private final Scanner scanner = new Scanner(System.in);
    
    
    public View(Controller ctrl) {
        this.ctrl = ctrl;
    }

//    private static final String CASENORMALE = "\u001b[40m ";
//    private static final String CASEMOTTRIPLE = "\u001b[41m "; 
//    private static final String CASEMOTDOUBLE = "\u001b[45m "; 
//    private static final String CASELETTRETRIPLE = "\u001b[44m "; 
//    private static final String CASELETTREDOUBLE = "\u001b[46m "; 
//    private static final String CASECENTRE = "\u001b[43m ";
//    private static final String RESET = "\u001B[0m ";
//    

    // affichage de la grille à l'écran
    public void afficherGrille() {
        
    }

    // va afficher le chevalet à l'écran
    public void afficheChevalet() {
    
    }

    // utilisateur va sélectionner une lettre de son chevalet à placer sur la grille
    public void choisirLettre() {
        
    }
    
    


    @Override
    public void update(Observable o, Object arg) {
        
        
    }



//dessiner grille
//        for (int row = 0; row < 15; row++) {
//            for (int col = 0; col < 15; col++) {
//                grille[row][col] = new Case();
//            }
//        }
//    }



    public static void main(String[] args) {
        
        
        // Test couleurs :
        System.out.println(CASENORMALE + "Case normale " + RESET);
        System.out.println(CASEMOTTRIPLE + "Case mot triple " + RESET);
        System.out.println(CASEMOTDOUBLE + "Case mot double " + RESET);
        System.out.println(CASELETTRETRIPLE + "Case lettre triple " + RESET);
        System.out.println(CASELETTREDOUBLE + "Case lettre double " + RESET);
        System.out.println(CASECENTRE + "Case centre " + RESET);
        
    }


