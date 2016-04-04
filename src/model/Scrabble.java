package model;

import controllerGUI.ControllerGUI;
import java.util.List;
import java.util.Observable;
import javafx.scene.control.Alert.AlertType;
import viewGUI.PopupAlert;
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
    
    public void removeJeton(Jeton j) {
        chev.removeJeton(j);
//        notif()
                ;
    }
    
    public void rechargerChevalet(Sac sac) {
        chev.rechargerChevalet(sac);
        notif();
    }
    
    
    
    public boolean coupOK() {
        return verif.coupOK();
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
    
    public void setAlert(PopupAlert pop) {
        verif.setAlert(pop);
//        notif();
    }
    
//    public void setConfirm(AlertType type) {
//        verif.setConfirm();
////        notif();
//    }
    
    public void notif() {
        setChanged();
        notifyObservers();
    }


    
    
}
