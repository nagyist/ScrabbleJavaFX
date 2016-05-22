package model;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author raphaelgrau
 */
public class VerifMot {

    private final Grille grille;

    private String errorDisplayed = "";
    private final String errorCenter = "Au moins une des lettres doit passer par le centre du plateau.";
    private final String errorNotTouchingExisting = "Le mot placé doit toucher un mot existant déjà sur le plateau.";
    private final String errorNotTouching = "Les lettres du mot doivent se toucher entre elles.";
    private final String errorTooShort = "Le mot doit faire au minimum 2 lettres.";
    private final String errorMotNotAligned = "Le mot placé doit être horizontal ou vertical.";


    private final List<Jeton> motCandidate = new ArrayList<>();
    private List<Jeton> motCandidateSorted = new ArrayList<>();
    private int nbTrousVerti;
    private int nbTrousHoriz;

    public VerifMot(ControllerGUI ctrl) {
        this.grille = ctrl.getGrille();
    }
    
    public String getError() {
        return errorDisplayed;
    }
    
    public boolean ajouterMotVerif(List<Jeton> lsJetons) {
        motCandidate.clear();
        motCandidateSorted.clear();
        for (Jeton j : lsJetons) {
            motCandidate.add(j);
        }
        return this.coupOK(); 
    }

    private boolean isItFirstCoup() {
        return grille.isEmpty();
    }

    private boolean lettreAtCenter() {
        for (Jeton j : motCandidate) {
            if (grille.jAtCenter(j.getX(), j.getY())) {
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
    
//    private boolean watchUp(Jeton j) {
//        return grille.watchUp(j);
//    }
//    
//    private boolean watchUp(Jeton j) {
//        return grille.caseJouee(j.getX(), j.getY() - 1);
//    }
//
//    private boolean watchRight(Jeton j) {
//        return grille.caseJouee(j.getX() + 1, j.getY());
//    }
//
//    private boolean watchDown(Jeton j) {
//        return grille.caseJouee(j.getX(), j.getY() + 1);
//    }
//
//    private boolean watchLeft(Jeton j) {
//        return grille.caseJouee(j.getX() - 1, j.getY());
//    }
//
//    private boolean touchJetonGrille(Jeton j) {
//        return watchUp(j) || watchRight(j) || watchDown(j) || watchLeft(j);
//    }

    private boolean alignVerti(List<Jeton> mot) {
        int x = mot.get(0).getX();
        for (Jeton j : mot) {
            if (j.getX() != x) {
                return false;
            }
        }
        return true;
    }

    private boolean alignHoriz(List<Jeton> mot) {
        int y = mot.get(0).getY();
        for (Jeton j : mot) {
            if (j.getY() != y) {
                return false;
            }
        }
        return true;
    }

    private boolean aligned(List<Jeton> mot) {
        return alignVerti(mot) || alignHoriz(mot);
    }

    private boolean uneSeuleLettre(List<Jeton> mot) {
        return mot.size() <= 1;
    }

    private boolean touchMotGrille() {
        for (Jeton j : motCandidate) {
            if (grille.watchAround(j)) {
                return true;
            }
        }
        return false;
    }
    
    public List<Jeton> sort(List<Jeton> lsJetons) {
        if(alignVerti(lsJetons))
            Collections.sort(lsJetons, Jeton.COMPARE_BY_Y);
        else if (alignHoriz(lsJetons))
            Collections.sort(lsJetons, Jeton.COMPARE_BY_X);
        return lsJetons;
   }

    
    private void sortMot() {

        motCandidateSorted = motCandidate;

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
//        afficheMot(mot);
        boolean result = false;
        int posY = -1;
        int posXPremierTrou = -1;
        for (int i = 0; i < mot.size() - 1; i++) {
            posY = mot.get(i).getY();
//            System.out.println(posY);
            if (mot.get(i + 1).getX() != (mot.get(i).getX() + 1)) {
                posXPremierTrou = mot.get(i).getX() + 1;
                nbTrousHoriz = (mot.get(i + 1).getX()) - (mot.get(i).getX() + 1);
                result = true;
            }
        }
//        System.out.println("posY : " + posY);
//        System.out.println("posXPremierTrou : " + posXPremierTrou);
//        System.out.println("nbTrousHoriz : " + nbTrousHoriz);
        if (result == true) { // si il y a un/des TROU
//            System.out.println("test");
            result = !verifTrousHorizGrille(posXPremierTrou, posY, nbTrousHoriz);
//            System.out.println("result" + result);
        }
//        System.out.println("trouHoriz result : " + result);    
        return result;
    }

    private boolean verifTrousHorizGrille(int posX, int posY, int nbTrousHoriz) {
//        System.out.println("testVTGFDFZEFGEZ");
//        System.out.println(posX + " * " + posY + " * " + nbTrousHoriz);
        for (int i = 0; i < nbTrousHoriz; ++i, ++posX) {
//            System.out.println(i + "+" + posX);
            if (!grille.caseJouee(posX, posY)) {
//                System.out.println("pas joué dans model, vrai trou");
                return false;
            }
        }
        return true;
    }

    private boolean verifTrousVertiGrille(int posX, int posY, int nbTrousVerti) {
//        System.out.println("testVTGFDFZEFGEZ");
//        System.out.println(posX + " * " + posY +  " * " + nbTrousVerti);
        for (int i = 0; i < nbTrousVerti; ++i, ++posY) {
//            System.out.println(i + "+" + posX);
            if (!grille.caseJouee(posX, posY)) {
//                System.out.println("pas joué dans model, vrai trou");
                return false;
            }
        }
        return true;
    }

    private boolean trouVerti(List<Jeton> mot) {
//        afficheMot(mot);
        boolean result = false;
        int posX = -1;
        int posYPremierTrou = -1;
        for (int i = 0; i < mot.size() - 1; i++) {
            posX = mot.get(i).getX();
//            System.out.println(posX);
            if (mot.get(i + 1).getY() != (mot.get(i).getY() + 1)) {
                posYPremierTrou = mot.get(i).getY() + 1;
                nbTrousVerti = (mot.get(i + 1).getY()) - (mot.get(i).getY() + 1);
                result = true;
            }
        }
//        System.out.println("posX : " + posX);
//        System.out.println("posYPremierTrou : " + posYPremierTrou);
//        System.out.println("nbTrousVerti : " + nbTrousVerti);
        if (result == true) {
//            System.out.println("test");
            result = !verifTrousVertiGrille(posX, posYPremierTrou, nbTrousVerti);
//            System.out.println("result" + result);
        }
//        System.out.println("trouVerti result : " + result);    
        return result;
    }

    private boolean motLineaire() {

        if (aligned(motCandidate)) { // OK
//            System.out.println("--- mot aligné ---");
            sortMot();

            if (alignVerti(motCandidateSorted)) { // OK
//                System.out.println("align VERTI");
                if (trouVerti(motCandidateSorted)) { // OK 
//                    System.out.println("trou verti");
                    return false;
                }
            } else if (alignHoriz(motCandidateSorted)) { // OK
//                System.out.println("align HORIZ");
                if (trouHoriz(motCandidateSorted)) { // OK 
//                    System.out.println("trou horiz");
                    return false;

                }
            }
            return true;
        } else {
//            System.out.println("NOT ALIGNED !!! "); // OK
            return false;
        }
    }

    public void displayError() {
        System.out.println(errorDisplayed);
    }

//    public void displayAlert(Alert alert) {
//        
//        if(alert.getAlertType() == AlertType.ERROR) {
//            alert.setTitle("Erreur"); 
//            alert.setHeaderText("Mauvais coup : ");
//            alert.setContentText(errorDisplayed);
//        } else {
//            alert.setTitle("Mot valide");
//            alert.setHeaderText("Le mot joué est : ");
//            alert.setContentText(displayMot(motCandidateSorted));
//        }
//
//        
//        alert.showAndWait().ifPresent(response -> {
//            if (response == ButtonType.OK) {
//                System.out.println("alert clicked OK");
//                //formatSystem() ===> fonction qui 'annule le coup'
//                ;
//            }
//        });
//    }
    public String getMotJoue() {
        String str = "";
        if (firstCoup()) {

            for (Jeton j : motCandidateSorted) {
                str += j.getStr().toUpperCase() + " ";
            }
            return str;
        } else {
            for (Jeton j : motCandidateSorted) {
                str += j.getStr().toUpperCase() + " ";
            }
        }
        return str;

    }


    public boolean firstCoup() {
        if (!lettreAtCenter()) {
            errorDisplayed = errorCenter;
            displayError();
//                displayAlert(alertError);
            return false;
        } else if (!motLineaire()) {
            errorDisplayed = errorNotTouching;
            displayError();
//                displayAlert(alertError);
            return false;
        } else if (uneSeuleLettre(motCandidate)) {
            errorDisplayed = errorTooShort;
            displayError();
//                displayAlert(alertError);
            return false;
        } else {
//            System.out.println("Premier coup OK!");
//                displayAlert(alertConfirm);
//            Mot firstMot = new Mot(motCandidateSorted);
            return true;
        }
    }

    public boolean otherCoup() {

        if (!touchMotGrille()) {
            errorDisplayed = errorNotTouchingExisting;
//            System.out.println("touche pas grille");  // pas ok
            displayError();
//            displayAlert(alertError);
            return false;
        }

        if (motLineaire()) {
            if (alignHoriz(motCandidateSorted)) {
                if (trouHoriz(motCandidateSorted)) {
                    errorDisplayed = errorNotTouchingExisting;   // OK
//                    System.out.println("trou horiz et touche pas grille");
                    displayError();
//                        displayAlert(alertError);
                    return false;
                }
            } else if (alignVerti(motCandidateSorted)) {      // ------> OK !!!
                if (trouVerti(motCandidateSorted)) {
                    errorDisplayed = errorNotTouchingExisting;
//                    System.out.println("trou verti et touche pas grille");
                    displayError();
//                        displayAlert(alertError);
                    return false;
                }
            }
        } else if (!motLineaire()) {
            errorDisplayed = errorMotNotAligned;
            displayError();
//            System.out.println("mot pas aligné");
            return false;
        } else {
            if (!touchMotGrille()) {
                errorDisplayed = errorNotTouchingExisting;
//                System.out.println("aligné mais touche pas grille");  // pas ok
                displayError();
//                    displayAlert(alertError);
                return false;
            }
        }
//        System.out.println("mot ok!");
//        displayAlert(alertConfirm);
        return true;
    }

    public boolean coupOK() {

        if (isItFirstCoup()) {
//            System.out.println("1e coup");
            return firstCoup();    // OK
        } else {
//            System.out.println("autre coup coup");
            return otherCoup();
        }
    }
}
