package controllerGUI;

import java.util.ArrayList;
import java.util.Iterator;
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

    private final Scrabble scrabble;
    private final Chevalet chev;
    private final Grille grille;
    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
    private Mot mot = new Mot();
    private Jeton courant;
    private final List<ViewCaseTemp> listCasesTemp = new ArrayList<>();
    private final List<ViewJeton> listJetonsJoues = new ArrayList<>();
    private final Sac sac;

    public ControllerGUI() {
        
        this.mot = new Mot();
        this.sac = new Sac();
        this.chev = new Chevalet(sac);
        this.grille = new Grille();
        this.scrabble = new Scrabble(this);
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
        for (ViewCaseTemp vct : listCasesTemp) {
            if (vct.getPosX() == x && vct.getPosY() == y)
                return true;
        }
        return false;   
    }

    public ViewCaseTemp getViewCaseTemp(Jeton j) {
        ViewCaseTemp v = null;
        for (ViewCaseTemp vct : listCasesTemp) {
            if (j == vct.getJetonCourant()) {
                v = vct;
            }
        }
        return v;
    }

    public ViewJeton getViewJeton(Jeton j) {
        for (ViewJeton vj : viewChevalet.getListViewJetonsChevalet()) {
            if (j == vj.getCourant()) {
                return vj;
            }
        }
        return null;
    }
    
    public ViewJeton getViewJetonAt(int x, int y) {
        for (Iterator<ViewJeton> it = listJetonsJoues.iterator(); it.hasNext();) {
            ViewJeton vj = it.next();
            if (x == vj.getX() && y == vj.getY()) {
                return vj;
            }
        }
        return null;
    }
    
    public void removeViewJeton(ViewJeton vj) {
        listJetonsJoues.remove(vj);
    }

    public ViewCase getViewCase(int x, int y) {
        return viewGrille.getViewCase(x, y);
    }

    public List<ViewCaseTemp> getListCasesTemp() {
        return listCasesTemp;
    }

    public List<ViewJeton> getListJetonsJoues() {
        return listJetonsJoues;
    }
      

    public void setXToViewJeton(int x, Jeton j) {
        getViewJeton(j).setX(getViewCaseTemp(j).getPosX());
    }

    public void setYToViewJeton(int y, Jeton j) {
        getViewJeton(j).setY(getViewCaseTemp(j).getPosY());
    }

    private void afficherListViewCaseTemp() {
        for (ViewCaseTemp vct : listCasesTemp) {
            System.out.println(vct.getLettreViewCaseTemp());
        }
    }
    
    public boolean casePossible(int x, int y) {
        return !caseJouee(x, y) && !caseTempJouee(x,y);
    }
    
    
    // place une ViewCaseTemp
    public void placerLettreTemp(int x, int y, Jeton j) {
        String lettre = j.getStr();
        listCasesTemp.add(new ViewCaseTemp(x, y, lettre, j, viewGrille, this));
        System.out.println("ViewCaseTemp, jetons : ");
        setXToViewJeton(x, j);
        setYToViewJeton(y, j);
        afficherListViewCaseTemp();
    }
   
    private void placerLettreModel(List<ViewCaseTemp> lvct) {
        for (ViewCaseTemp vct : lvct) {
            System.out.println(vct.getPosX());
            System.out.println(vct.getPosY());
            System.out.println(vct.getJeton().getStr());
            scrabble.placerLettre(vct.getPosX(), vct.getPosY(), vct.getJeton());
            getViewCase(vct.getPosX(), vct.getPosY()).getChildren().remove(vct);
        }
    }
    
    private void supprViewCaseTemp(List<ViewCaseTemp> lvct) {
        for (ViewCaseTemp vct : lvct) {
            System.out.println(vct.getPosX());
            System.out.println(vct.getPosY());
            System.out.println(vct.getJeton().getStr());
            scrabble.placerLettre(vct.getPosX(), vct.getPosY(), vct.getJeton());
            getViewCase(vct.getPosX(), vct.getPosY()).getChildren().remove(vct);
        }
    }
    
    private void placerViewJetonSurViewCase(List<ViewJeton> lvjj) {
        for (ViewJeton vj : lvjj) {
            getViewCase(vj.getX(), vj.getY()).getChildren().set(0, getViewJetonAt(vj.getX(), vj.getY()));
        }
    }
    
    private void removeViewJetonChevalet(List<ViewJeton> lvjj) {
        for (ViewJeton vj : lvjj) {
            scrabble.removeJeton(vj.getCourant());
//            chev.removeJeton(vj.getCourant())
                    ;
        }
    }
    
    private void rechargerChev(List<ViewJeton> lvjj) {
        for (ViewJeton vj : lvjj) {
            scrabble.rechargerChevalet(sac);
//            chev.rechargerChevalet(sac)
                    ;
        }
    }
    
    private void reaffichChevalet() {
        viewChevalet.initChevalet();
    }

    public void validerCoup(List<ViewCaseTemp> lsViewCaseTemp, List<ViewJeton> lsViewJetonsJoues) {

        // placer lettres dans le model
        placerLettreModel(lsViewCaseTemp);
        // supprimer la ViewCase existante sur la grille
        supprViewCaseTemp(lsViewCaseTemp);
        // placer ViewJeton sur la ViewCase
        placerViewJetonSurViewCase(lsViewJetonsJoues);
        // enlever jeton du chevalet    
        removeViewJetonChevalet(lsViewJetonsJoues);
        // recharger chevalet du nombre de jetons joués
        rechargerChev(lsViewJetonsJoues);
        // réafficher le chevalet
        reaffichChevalet();
        
        // nettoyer la lsViewCaseTemp
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
    
    private ViewCaseTemp getLastVCT(List<ViewCaseTemp> casesTemp) {
        return casesTemp.get(casesTemp.size() - 1);
    }
    
    private void removeLastVCTFromViewCase() {
        ViewCaseTemp lastVCT = getLastVCT(listCasesTemp);
        listCasesTemp.remove(lastVCT);
        getViewCase(lastVCT.getPosX(), lastVCT.getPosY()).getChildren().remove(lastVCT);     
    }
    
    private ViewJeton getLastViewJeton() {
        return listJetonsJoues.get(listJetonsJoues.size() - 1);
    }
    
    private void addViewJetonToChev() {
        ViewJeton lastVJ = getLastViewJeton();
        listJetonsJoues.remove(lastVJ);
        removeViewJeton(lastVJ);
        viewChevalet.addViewJeton(lastVJ);
    }
    

    public void annulerDerniereLettre() {

        if (!getListCasesTemp().isEmpty()) {
            removeLastVCTFromViewCase();
            addViewJetonToChev();
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
