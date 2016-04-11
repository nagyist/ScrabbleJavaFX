package model;

import controllerGUI.ControllerGUI;
import java.util.List;
import java.util.Observable;
//import javafx.scene.control.Alert.AlertType;
//import viewGUI.PopupAlert;
import viewGUI.ViewCaseTemp;

/**
 *
 * @author raphaelgrau
 */
public class Scrabble extends Observable {
    
    private final Grille grille;
    private final Chevalet chev;
    private final VerifMot verif;
    
    public Scrabble(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
        this.chev = ctrl.getChevalet();
        this.verif = ctrl.getVerifMot();
    }
    
    public void placerLettre(int x, int y, Jeton j) {
        grille.setCase(x, y, j.getChar());
//        notif()
                ;
    }
    
    public void placerLettres(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons) {
            placerLettre(j.getX(), j.getY(), j);
        }
    }
    
    public void removeJeton(Jeton j) {
        chev.removeJeton(j);
//        notif()
                ;
    }
    
    public void removeJetons(List<Jeton> lsJetons) {
        for (Jeton j : lsJetons) {
            removeJeton(j);
        }
    }
    
    public void rechargerChevalet(Sac sac) {
        
        chev.rechargerChevalet(sac);
        
        notif();
    }
    
    public void rechargerChevalet(List<Jeton> lsJetons, Sac sac) {
        for (Jeton j : lsJetons) {
            chev.rechargerChevalet(sac);
        }
//        notif();
    }
    
    public void jouerCoup(List<Jeton> lsJetons, Sac sac) {
        placerLettres(lsJetons);
        removeJetons(lsJetons);
        rechargerChevalet(lsJetons, sac);
        notif();
    }
    
    
    
    public boolean coupOK() {
        return verif.coupOK();
    }
    
    public boolean verifMot(List<Jeton> lsJetons) {
        return verif.ajouterMotVerif2(lsJetons);
    }
    
    public void ajouterMotVerif2(List<Jeton> lsJetons) {
        verif.ajouterMotVerif2(lsJetons);
    }
    
    public void ajouterMotVerif(List<ViewCaseTemp> lsViewCaseTemp) {
        verif.ajouterMotVerif(lsViewCaseTemp);
    }
    

    
//    public void displayError() {
//        verif.displayError();
//    }
//    
//    public void displayConfirm() {
//        verif.displayConfirm();
//    }
    
//    public void setAlert(PopupAlert pop) {
//        verif.setAlert(pop);
////        notif();
//    }
    
//    public void setConfirm(AlertType type) {
//        verif.setConfirm();
////        notif();
//    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }


    
    
}
