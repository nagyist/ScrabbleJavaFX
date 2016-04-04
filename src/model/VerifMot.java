package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import viewGUI.PopupAlert;
import viewGUI.ViewCaseTemp;

/**
 *
 * @author raphaelgrau
 */
public class VerifMot {

    private final Grille grille;
    
    private String errorDisplayed = "";
    private final String errorCenter = "Au moins une des lettres doit passer par le centre du plateau.";
    private final String errorNotTouchingExisting = "Au moins une des lettres du mot placé doit toucer un mot existant déjà sur le plateau.";
    private final String errorNotTouching = "Les lettres du mot doivent se toucher entre elles.";
    private final String errorTooShort = "Le mot doit faire au minimum 2 lettres.";
//    private final Alert alertError = new Alert(Alert.AlertType.ERROR);
//    private final Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
   
    private final List<Jeton> motCandidate = new ArrayList<>();
    private List<Jeton> motCandidateSorted = new ArrayList<>();

    
    public VerifMot(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
    }

    public void ajouterMotVerif(List<ViewCaseTemp> lsViewCaseTemp) {
        for (ViewCaseTemp vct : lsViewCaseTemp) {
            motCandidate.add(vct.getJeton());
        }
    }

    private boolean isItFirstCoup() {
        return grille.isEmpty();
    }

    private boolean lettreAtCenter() {
        for (Jeton j : motCandidate) {
            if (j.isAtCenter()) {
                return true;
            }
        }
        return false;
    } 
    
    
//    private boolean touch(Jeton j) {
//        Jeton jj = new Jeton(' ', 0, 0);
//        
//        int xj = j.getX();
//        int yj = j.getY();
//
//        int xjj = jj.getX();
//        int yjj = jj.getY();
//    
//        return  (xj == xjj+1 && yj == yjj) 
//             || (xj == xjj-1 && yj == yjj)
//             || (xj == xjj && yj+1 == yjj)
//             || (xj == xjj && yj+1 == yjj);
//            
//    }
    
    private boolean watchUp(Jeton j) {
        return grille.caseJouee(j.getX(), j.getY()-1);
    }
    private boolean watchRight(Jeton j) {
        return grille.caseJouee(j.getX()+1, j.getY());
    }
    private boolean watchDown(Jeton j) {
        return grille.caseJouee(j.getX(), j.getY()+1);
    }
    private boolean watchLeft(Jeton j) {
        return grille.caseJouee(j.getX()-1, j.getY());
    }
    
    private boolean touchJetonGrille(Jeton j) {
        return watchUp(j) || watchRight(j) || watchDown(j) || watchLeft(j);
    }
    
    private boolean alignVerti(List<Jeton> mot) {
        int x = mot.get(0).getX();
        for (Jeton j : mot) {
            if (j.getX() != x)
                return false;
        }
        return true;     
    }
    
    private boolean alignHoriz(List<Jeton> mot) {
        int y = mot.get(0).getY();
        for (Jeton j : mot) {
            if (j.getY() != y)
                return false;
        }
        return true;     
    }
    
    private boolean aligned(List<Jeton> mot) {
        return alignVerti(mot) || alignHoriz(mot);
    }
        
    
    private void sortMot() {
        
//        System.out.println("before sort :");
//        afficheMot(motCandidate);
//        afficheMot(motCandidateSorted);

        motCandidateSorted = motCandidate;
        
//        afficheMot(motCandidate);
//        afficheMot(motCandidateSorted);

        if (alignVerti(motCandidate)) {
            Collections.sort(motCandidateSorted, Jeton.COMPARE_BY_Y);
            
        } else if (alignHoriz(motCandidate)) {
            Collections.sort(motCandidateSorted, Jeton.COMPARE_BY_X);       
        }        
    }
    
    private void afficheMot(List<Jeton> mot) {
        for (Jeton j : mot) {
            System.out.println(j.getChar() + " ");
        }            
    }   
    

    private boolean trouHoriz(List<Jeton> mot) {
        boolean result = false;
        for (int i = 0; i < mot.size() - 1; i++) {
            if (mot.get(i+1).getX() != (mot.get(i).getX() + 1)) {  
                result = true;              
            }
        }
        return result;
    }
    
    private boolean trouVerti(List<Jeton> mot) {
        boolean result = false;        
        for (int i = 0; i < mot.size() - 1; i++) {
            if (mot.get(i+1).getY() != (mot.get(i).getY() + 1)) {  
                result = true;
            }    
        }
        return result;
    }

    private boolean motLineaire() {

        if (aligned(motCandidate)) { // OK
            System.out.println("--- mot aligné ---");
            sortMot();
            
            if (alignVerti(motCandidateSorted)) { // OK
                System.out.println("align VERTI"); 
                if (trouVerti(motCandidateSorted)) { // OK 
                    System.out.println("trou verti");                                
                    return false; 
                }
            } else if (alignHoriz(motCandidateSorted)) { // OK
                System.out.println("align HORIZ");
                if (trouHoriz(motCandidateSorted)) { //  PAS OK 
                    System.out.println("trou horiz");
                    return false;

                }
            }
            return true;
        }
        else {
            System.out.println("NOT ALIGNED !!! "); // OK
            return false;
        }
    }
    
    private boolean uneSeuleLettre(List<Jeton> mot) {
        return mot.size() <= 1;
    }

    private boolean touchMotGrille() {
        for (Jeton j : motCandidate) {
            if (touchJetonGrille(j))
                    return true;  
        }
        return false;
    }

    public void displayError() {
        System.out.println(errorDisplayed);
    }

    public void displayAlert(Alert alert) {
        
        if(alert.getAlertType() == AlertType.ERROR) {
            alert.setTitle("Erreur"); 
            alert.setHeaderText("Mauvais coup : ");
            alert.setContentText(errorDisplayed);
        } else {
            alert.setTitle("Mot valide");
            alert.setHeaderText("Le mot joué est : ");
            alert.setContentText(displayMot(motCandidateSorted));
        }

        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("alert clicked OK");
                //formatSystem() ===> fonction qui 'annule le coup'
                ;
            }
        });
    }
    
    public String displayMot(List<Jeton> mot) {
        String str = "";
        for (Jeton j : mot)
            str += j.getStr().toUpperCase() + " ";
        return str;
    }
    
    public void setAlert(PopupAlert pop) {
        pop.alertType(AlertType.ERROR);
        errorDisplayed = errorCenter;
        
    }
    
    public void setConfirm(AlertType type) {
        type = AlertType.CONFIRMATION;
        
    }
    
    
    public boolean firstCoup() {
        if (!lettreAtCenter()) {          
		errorDisplayed = errorCenter;
                displayError();
		return false;
	} else if (!motLineaire()) {
		errorDisplayed = errorNotTouching;
                displayError();
		return false;
	} else if (uneSeuleLettre(motCandidate)) {
		errorDisplayed = errorTooShort;
                displayError();
		return false;
	} else {
                System.out.println("Premier coup OK!");
		return true;
            }
	}
    
    public boolean otherCoup() {
        //...
        return true;
    }
    

    public boolean coupOK() {
       
        
        if (isItFirstCoup()) {
            return firstCoup();    // OK
        } else {
            return otherCoup();
        } 
    }

}
