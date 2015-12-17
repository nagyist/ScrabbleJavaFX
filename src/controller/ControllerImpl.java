/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import view.View;
import model.Grille;

/**
 *
 * @author 0404ragrau
 */
public class ControllerImpl implements Controller {
    
    
    private Grille grille;
    private View vue;
    

    public ControllerImpl() {
        this.vue = new View(this);
        this.grille = new Grille();
        grille.addObserver(view);
    }
    
    public void lancer() {
        grille.initGrille();
    }
     
     
    public static void main(String[] args) {
    
        ControllerImpl control = new ControllerImpl();
        control.lancer();
    }
     
}
