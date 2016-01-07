/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Chevalet;
import model.Grille;
import model.Jeton;
import view.View;

/**
 *
 * @author 0404ragrau
 */
public class ControllerImpl implements Controller {
    
    
    private Grille grille;
    private View vue;
    private Chevalet chevalet;
    
    

    public ControllerImpl() {
        this.vue = new View(this);
        this.grille = new Grille();
        this.chevalet = new Chevalet();
        grille.addObserver(vue);
        chevalet.addObserver(vue);
        lancer();
    }

    
    public void positionnerLettre(int li, int co) {
        
    }
    
    
    public void verifierLettre(char c) {
       
        chevalet.verifLettre(c);
    }
    

    
    public void lancer() {
//        grille.initGrille();
//        grille.notif();
//        chevalet.notif();
        grille.initGrille();
//        chevalet.affiche();
//        grille.afficheGrille();
        vue.choisirLettre();
        vue.choisirPosition();
//        grille.placerLettreGrille();
        
    }
     
    public Chevalet getChevalet() {
        return this.chevalet;
    }
     
    public static void main(String[] args) {
    
        ControllerImpl control = new ControllerImpl();

    }
     
}
