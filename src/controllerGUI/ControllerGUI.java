package controllerGUI;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Chevalet;
import model.Grille;
import model.Jeton;
import model.Mot;
import viewGUI.MainView;
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
    private final List<ViewCaseTemp> casesTemp = new ArrayList<>();

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

//    public void removeJeton(Jeton j) {
//        chev.removeJeton(j);
//    }

    public boolean caseJouee(int x, int y) {
        
        
        return grille.getCase(x, y).caseLibre();
    }
    

    public ViewCaseTemp getViewCaseTemp(Jeton j) {
        ViewCaseTemp v = null;
        for (ViewCaseTemp vct : casesTemp) {
            if (j == vct.getJetonCourant()) {
                v = vct;
            }
        }
        return v;
    }

    public void placerLettreTemp(int x, int y, Jeton j) {
        String lettre = j.getStr();
        casesTemp.add(new ViewCaseTemp(x, y, lettre, j, viewGrille, this));

        System.out.println("ViewCaseTemp, jetons : ");
        afficherListViewCaseTemp();

    }
    
    public List<ViewCaseTemp> getListCasesTemp() {
        return casesTemp;
    }

    private void afficherListViewCaseTemp() {
        for (ViewCaseTemp vct : casesTemp) {
            System.out.println(vct.getLettreViewCaseTemp());
        }
    }
    
    private boolean ListEmpty() {
        return casesTemp.isEmpty();
    }
     
    // place une lettre (jeton) à une position donnée dans le model Grille
    public void placerLettre(int x, int y, Jeton j) {
        grille.setCase(x, y, j.getChar());
    }
    
    public void validerCoup(List<ViewCaseTemp> lsViewCaseTemp) {
        for (ViewCaseTemp vct : lsViewCaseTemp) {
            System.out.println(vct.getPosX());
            System.out.println(vct.getPosY());
            System.out.println(vct.getJeton().getStr());
            placerLettre(vct.getPosX(), vct.getPosY(), vct.getJeton());
        }
        lsViewCaseTemp.clear();
        viewGrille.afficherGrille();

        System.out.println("ViewCaseTemp vide? :" + ListEmpty());
    }
    
    public String getLettreAt(int x, int y) {
        return grille.getLettreAt(x, y);
    }

    private void lancer() {
        grille.notif();
//        chevalet.notif();
//        demanderLettre();

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainView viewGUI = new MainView(primaryStage, viewGrille, viewChevalet, this);
    }

}
