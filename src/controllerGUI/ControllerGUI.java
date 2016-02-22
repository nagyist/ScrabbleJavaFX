package controllerGUI;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Chevalet;
import model.Grille;
import model.Mot;
import viewGUI.ViewChevalet;
import viewGUI.MainView;
import viewGUI.ViewGrille;

/**
 *
 * @author 0404ragrau
 */
public class ControllerGUI extends Application {

    private Chevalet chev;
    private Grille grille;
    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
    private Mot mot = new Mot();


    public ControllerGUI() {
        this.chev = new Chevalet();
        this.grille = new Grille();
        this.viewChevalet = new ViewChevalet(this);
        this.viewGrille = new ViewGrille(this);
        this.mot = new Mot();
//        chev.addObserver((Observer) viewChevalet);
//        grille.addObserver((Observer) viewGrille);
        lancer();
    }

//    private boolean exists(char c) {
//        for (Jeton j : chev.getChev()) {
//            if (j.getChar() == c) {
//                return true;
//            }
//        }
//        return false;
//    }

    public Mot getMot() {
        return this.mot;
    }

    public Chevalet getChevalet() {
        return this.chev;
    }

    public Grille getGrille() {
        return this.grille;
    }

    
//    public boolean verifierLettre(char ch) {
//        if (!exists(ch) && ch != CHAR_FIN_MOT)
//            return false;
//        return true;
//    }
    
//    public boolean verifierPosition(Point pt) {
//       return pt.x >= 0 && pt.x < DIM && pt.y >= 0 && pt.y < DIM && grille.getCharAt(pt) == ' ';
//    }
    

//    public void positionnerLettre(Point pt, char ch) {
//
//        grille.getCase(pt).setChar(ch);
//        Jeton j = chev.getJeton(ch);
//        mot.ajouterJetonMot(j);
//        chev.removeJeton(ch);
//        grille.notif();
////        demanderLettre();
//        //chevalet.notif();
//    }

    private void lancer() {
        grille.notif();
//        chevalet.notif();
//        demanderLettre();

    }
    
//    private void demanderLettre() {
//        char ch = vue.choisirLettre();
//        if (ch == CHAR_FIN_MOT)
//            vue.afficherMot(mot);
//        else {
//            Point pt = vue.choisirPosition();
//            positionnerLettre(pt, ch);
//        }
//    }

    public static void main(String[] args) {

//        ControllerGUI control = new ControllerGUI();
        launch();
    }

    
    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView viewGUI = new MainView(viewGrille, viewChevalet, this, 0, 0);
    }



}
