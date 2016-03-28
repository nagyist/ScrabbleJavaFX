package model;

import controllerGUI.ControllerGUI;

/**
 *
 * @author raphaelgrau
 */
public class Scrabble {
    
    private final Grille grille;
    private final Chevalet chev;
    
    public Scrabble(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
        this.chev = ctrl.getChevalet();
    }
    
    public void placerLettre(int x, int y, Jeton j) {
        System.out.println(x + "et" + y + "et" + j.getChar());
        grille.setCase(x, y, j.getChar());
        System.out.println("Lettre model :" + grille.getCase(x, y).getChar());
    }
    
    public void removeJeton(Jeton j) {
        chev.removeJeton(j);
    }
    
    public void rechargerChevalet(Sac sac) {
        chev.rechargerChevalet(sac);
        
    }
    
    
    
}
