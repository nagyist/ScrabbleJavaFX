package controllerGUI;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import viewGUI.*;

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
    private final Sac sac;

    public ControllerGUI() {
        this.mot = new Mot();
        this.sac = new Sac();
        this.chev = new Chevalet(sac);
        this.grille = new Grille();
        this.viewChevalet = new ViewChevalet(this);
        this.viewGrille = new ViewGrille(this);
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

    public Sac getSac() {
        return this.sac;
    }

    // Jeton courant : celui qui est en train d'être joué lorsque l'utilisateur
    // clique sur un jeton dans le chevalet pour le placer sur la grille
    public Jeton getCourant() {
        return this.courant;
    }

    public void setCourant(Jeton courant) {
        this.courant = courant;
    }

    public boolean caseJouee(int x, int y) {
        return !grille.getCase(x, y).caseLibre();
    }
    
    public boolean caseTempJouee(int x, int y) {
        for (ViewCaseTemp vct : casesTemp) {
            if (vct.getPosX() == x && vct.getPosY() == y)
                return true;
        }
        return false;   
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

    public ViewJeton getViewJeton(Jeton j) {
        ViewJeton v = null;
        for (ViewJeton vj : viewChevalet.getListViewJetonsChevalet()) {
            if (j == vj.getCourant()) {
                v = vj;
            }
        }
        return v;
    }

    public ViewCase getViewCase(int x, int y) {
        return viewGrille.getViewCase(x, y);
    }

    public List<ViewCaseTemp> getListCasesTemp() {
        return casesTemp;
    }

    public List<ViewJeton> getListJetonsJoues() {
        return viewChevalet.getListViewJetonsJoues();
    }

    public void setXToViewJeton(int x, Jeton j) {
        getViewJeton(j).setX(getViewCaseTemp(j).getPosX());
    }

    public void setYToViewJeton(int y, Jeton j) {
        getViewJeton(j).setY(getViewCaseTemp(j).getPosY());
    }

    private void afficherListViewCaseTemp() {
        for (ViewCaseTemp vct : casesTemp) {
            System.out.println(vct.getLettreViewCaseTemp());
        }
    }
    
    // place une ViewCaseTemp
    public void placerLettreTemp(int x, int y, Jeton j) {
        String lettre = j.getStr();
        casesTemp.add(new ViewCaseTemp(x, y, lettre, j, viewGrille, this));
        System.out.println("ViewCaseTemp, jetons : ");
        afficherListViewCaseTemp();
    }

    // placer la lettre dans le model
    public void placerLettre(int x, int y, Jeton j) {
        grille.setCase(x, y, j.getChar());
        System.out.println("Lettre model :" + grille.getCase(x, y).getChar());
    }

    public void validerCoup(List<ViewCaseTemp> lsViewCaseTemp, List<ViewJeton> lsViewJetonsJoues) {

        // placer lettres dans le model
        // supprimer la ViewCase existante sur la grille
        for (ViewCaseTemp vct : lsViewCaseTemp) {
            System.out.println(vct.getPosX());
            System.out.println(vct.getPosY());
            System.out.println(vct.getJeton().getStr());
            placerLettre(vct.getPosX(), vct.getPosY(), vct.getJeton());
            getViewCase(vct.getPosX(), vct.getPosY()).getChildren().remove(vct);
        }

        // placer ViewJeton sur la grille
        for (ViewJeton vj : lsViewJetonsJoues) {

            getViewCase(vj.getX(), vj.getY()).getChildren().set(0, viewChevalet.getViewJetonAt(vj.getX(), vj.getY()));
            // enlever jeton du chevalet    
            chev.removeJeton(vj.getCourant());
            // recharger chevalet du nombre de jetons joués
            chev.rechargerChevalet(sac);
        }
        
        // réafficher le chevalet
        viewChevalet.initChevalet();
        lsViewCaseTemp.clear();

        // tests console :
//        System.out.println("Liste jetons joués : ");
//        for (ViewJeton vj : viewChevalet.getListViewJetonsJoues()) {
//            System.out.println("ViewJeton lettre : " + vj.getLettre());
//            System.out.println("ViewJeton x : " + vj.getX());
//            System.out.println("ViewJeton y : " + vj.getY());
//            System.out.println("Model : " + getLettreAt(vj.getX(), vj.getY()));
//        };

        
        System.out.print("Chevalet model : ");
        for (Jeton j : chev.getChev()) {
            System.out.print(j.getChar() + " ");
        }
    }

    public void annulerDerniereLettre() {

        if (!getListCasesTemp().isEmpty()) {
            
            ViewCaseTemp lastVCT = casesTemp.get(casesTemp.size() - 1);
            casesTemp.remove(lastVCT);
            getViewCase(lastVCT.getPosX(), lastVCT.getPosY()).getChildren().remove(lastVCT);
            
            ViewJeton lastVJ = viewChevalet.getListViewJetonsJoues().get(viewChevalet.getListViewJetonsJoues().size() - 1);
            viewChevalet.getListViewJetonsJoues().remove(lastVJ);
            viewChevalet.getChildren().add(lastVJ);
        }
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
