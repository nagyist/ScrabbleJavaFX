package controllerGUI;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Case;
import model.Chevalet;
import model.Grille;
import model.Jeton;
import model.Mot;
import viewGUI.MainView;
import viewGUI.ViewButtons;
import viewGUI.ViewCaseTemp;
import viewGUI.ViewChevalet;
import viewGUI.ViewGrille;

/**
 *
 * @author 0404ragrau
 */
public class ControllerGUI extends Application {

    private final Chevalet chev;
    private final Grille grille;
    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
    private Mot mot = new Mot();
    private Jeton courant;
    private boolean caseJ;
    private Case caseCourante;
    private boolean cj;
    private List<ViewCaseTemp> casesTemp = new ArrayList<>();
    ViewCaseTemp temp;
    private ViewButtons viewButtons;
   

    public ControllerGUI() {
        this.chev = new Chevalet();
        this.grille = new Grille();
        this.viewChevalet = new ViewChevalet(this);
        this.viewGrille = new ViewGrille(this);
        this.mot = new Mot();
        this.caseJ = false;
        this.cj = false;
//        chev.addObserver((Observer) viewChevalet);
//        grille.addObserver((Observer) viewGrille);
        lancer();
    }


    public Mot getMot() {
        return this.mot;
    }

    public Chevalet getChevalet() {
        return this.chev;
    }

    public Grille getGrille() {
        return this.grille;
    }
    
    public Jeton getCourant() {
        return this.courant;     
    }
    
    public void setCourant(Jeton courant) {
        this.courant = courant;
    }
       
    public boolean caseJouee(int x, int y) {
        return grille.getCase(x,y).caseLibre();
    }   
    
    public ViewCaseTemp getViewCaseTemp(Jeton j) {
        ViewCaseTemp v = null;
        for (ViewCaseTemp vct: casesTemp)
            if (j == vct.getJeton())
                v = vct;
        return v;
    }  
    
    public void placerLettreTemp(int x, int y, Jeton j) {
        String lettre = j.getStr();
        casesTemp.add(new ViewCaseTemp(x, y, lettre, viewGrille, this));
//        temp = new ViewCaseTemp(x, y, lettre, viewGrille, this);
        
        System.out.println("ViewCaseTemp, jetons : ");
        afficherListViewCaseTemp();

//        System.out.println(casesTemp);
//        System.out.println(temp.getLettre().toString());
    }
    
    public void afficherListViewCaseTemp() {
       for (ViewCaseTemp vct: casesTemp)
            System.out.println(vct.getLettreViewCaseTemp());
    }
    
    
    public void placerLettre(int x, int y, Jeton j) { 
        grille.setCase(x, y, j.getChar()); 
    }
    
    public void removeJeton(Jeton j) {
        chev.removeJeton(j);
    }
    
//    public ViewCase getViewCaseTemp(Jeton j) {
//        ViewCaseTemp v = null;
//        for (ViewCaseTemp vv: casesTemp)
//            if (vv.getJeton() == j)
//                v = vv;          
//        return v;
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
        MainView viewGUI = new MainView(primaryStage,viewGrille, viewChevalet, this, 0, 0);
    }








}
