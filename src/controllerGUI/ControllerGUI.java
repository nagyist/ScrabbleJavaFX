package controllerGUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
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
//    private final Mot mot;
    private final VerifMot verifMot;
    private Jeton courant;
    private final List<ViewCaseTemp> listCasesTemp = new ArrayList<>();
    private final List<ViewJeton> listJetonsJoues = new ArrayList<>();
    private final Sac sac;
    private final Alert alertError = new Alert(Alert.AlertType.ERROR);
    private final Alert alertWarning = new Alert(Alert.AlertType.WARNING);
    private final Alert alertConfirm = new Alert(Alert.AlertType.CONFIRMATION);
//    private final List<ViewJetonTemp> listViewJetonsTemp = new ArrayList<>();
    private final List<Jeton> listJetonsChange = new ArrayList<>();
    


    public ControllerGUI() {
        
//        this.mot = new Mot();
        this.sac = new Sac();
        this.chev = new Chevalet(sac);
        this.grille = new Grille();
        this.verifMot = new VerifMot(this);
        this.scrabble = new Scrabble(this);
        this.viewChevalet = new ViewChevalet(this);
        this.viewGrille = new ViewGrille(this);
        scrabble.addObserver(viewChevalet);
        scrabble.addObserver(viewGrille);
        lancer();
    }

//    public Mot getMot() {
//        return this.mot;
//    }

    public Chevalet getChevalet() {
        return this.chev;
    }

    public Grille getGrille() {
        return this.grille;
    }

    public Sac getSac() {
        return this.sac;
    }
    
    public VerifMot getVerifMot() {
        return this.verifMot;
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
   
    public boolean casePossible(int x, int y) {
        return !caseJouee(x, y) && !caseTempJouee(x,y);
    }
    
    
    // on place une ViewCaseTemp
    public void placerLettreTemp(int x, int y, Jeton j) {
        String lettre = j.getStr();
        listCasesTemp.add(new ViewCaseTemp(x, y, lettre, j, viewGrille, this));
        setXToViewJeton(x, j);
        setYToViewJeton(y, j);      
    }
    
    public void addListJetonsChange(Jeton j) {
        listJetonsChange.add(j);
    }
    
    public void removeListJetonsChange(Jeton j) {
        listJetonsChange.remove(j);
    }
    
    public void changerJetonsSelected() {
        if (!listJetonsChange.isEmpty()) {
            scrabble.changeJetons(listJetonsChange, sac);
            listJetonsChange.clear();
            sac.afficherSac();
        } else
            displayAlert(alertWarning);
    }
    
    public void afficheListJetonsChange() {
        System.out.println("list : ");
        for (Jeton j : listJetonsChange)
            System.out.println(j.getChar() + " ");
    }
    
//    public void placerViewJetonTemp(Jeton j) {
//        listViewJetonsTemp.add(new ViewJetonTemp(0,0,j,this,viewChevalet));
//    }
//    
//    public void removeViewJetonTemp(ViewJetonTemp vjt) {
//        listViewJetonsTemp.remove(vjt);
//        System.out.println("hello");
//
//    }
//    
//    public boolean isViewJetonTempSelected(Jeton j) {
//        ViewJetonTemp v = null;
//        for (ViewJetonTemp vjt : listViewJetonsTemp) {
//            if (j == vjt.getJeton()) {
//                v = vjt;
//                return true;
//            }
//        }
//        return false;
//    }
//    
//    public ViewJetonTemp getViewJetonTemp(Jeton j) {
//        ViewJetonTemp v = null;
//        for (ViewJetonTemp vjt : listViewJetonsTemp) {
//            if (j == vjt.getJeton()) {
//                v = vjt;
//            }
//        }
//        return v;
//    }
    
   
    
    // on place une ViewJeton sur la grille à la position où était la ViewCaseTemp
    public void placerViewJetonGrille(ViewJeton vj) {
//        getViewCase(vct.getX(), vct.getY()).getChildren().set(0, new ViewJeton(vct.getX(), vct.getY(), vct.getJeton(), this, viewChevalet));
            getViewCase(vj.getX(), vj.getY()).getChildren().set(0, getViewJetonAt(vj.getX(), vj.getY())); 

    }
    
    

    
    

    public void removeViewCaseTemp(ViewCaseTemp vct) {
        getViewCase(vct.getPosX(), vct.getPosY()).getChildren().remove(vct);
    }
   

    public List<Jeton> lsVCTtolsJetons(List<ViewCaseTemp> lsViewCaseTemp) {
        List<Jeton> lsJetons = new ArrayList<>();
        for (ViewCaseTemp vct : lsViewCaseTemp) {
            lsJetons.add(vct.getJeton());
        }
        return lsJetons;
    }
    
    public List<Jeton> lsVJJtolsJetons(List<ViewJeton> lsViewJetonsJoues) {
        List<Jeton> lsJetons = new ArrayList<>();
        for (ViewJeton vj : lsViewJetonsJoues) {
            lsJetons.add(vj.getCourant());
        }
        return lsJetons;
    }

    
    public void displayAlert(Alert alert) {
        
        if(alert.getAlertType() == AlertType.ERROR) {
            alert.setTitle("Erreur"); 
            alert.setHeaderText("Mauvais coup : ");
            alert.setContentText(verifMot.getError());
        } else if (alert.getAlertType() == AlertType.WARNING) {
            alert.setTitle("Attention");
            alert.setHeaderText("Échanger des lettres : ");
            alert.setContentText("Sélectionnez d'abord les jetons du chevalet que vous voulez échanger.");

        } else {
            alert.setTitle("Mot valide");
            alert.setHeaderText("Le mot joué est : ");
            alert.setContentText(verifMot.getMotJoue());
        }

        
        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("alert clicked OK");
                //formatSystem() ===> fonction qui 'annule le coup'
                ;
            }
        });
    }
    
    
    

    public void validerCoup(List<ViewCaseTemp> lsViewCaseTemp) {
//        , List<ViewJeton> lsViewJetonsJoues
//            }) {
        
       List<Jeton> lsJetons = lsVCTtolsJetons(lsViewCaseTemp);
        
       
       
//        scrabble.ajouterMotVerif2(lsJetons);
//        scrabble.ajouterMotVerif(lsViewCaseTemp);
        
        
        if (!scrabble.motValide(lsJetons)) {
            System.out.println("coup pas OK");
            displayAlert(alertError);
//        }
//            
//        if (!scrabble.coupOK()) {
////            scrabble.displayError();
////            scrabble.setAlert(popupAlert);
//            System.out.println("coup pas OK");
            
        } else {
            
            displayAlert(alertConfirm);
             
            
//            scrabble.placerLettres(lsVCTtolsJetons(lsViewCaseTemp));
//            
////            for (ViewCaseTemp vct : lsViewCaseTemp) {
////                scrabble.placerLettre(vct.getPosX(), vct.getPosY(), vct.getJeton()); // <--- grille : model modifié
//////            removeViewCaseTemp(vct); // <--- grille : update ViewGrille
////            }
//            scrabble.removeJetons(lsVJJtolsJetons(lsViewJetonsJoues));
//            
//            scrabble.rechargerChevalet(lsVJJtolsJetons(lsViewJetonsJoues), sac);
            
            
            scrabble.jouerCoup(lsJetons, sac);
            
//            for (Iterator<ViewJeton> it = lsViewJetonsJoues.iterator(); it.hasNext();) {
//                ViewJeton vj = it.next();
//                scrabble.removeJeton(vj.getCourant()); // <--- chevalet : model modifié
//                scrabble.rechargerChevalet(sac);
//                return;

//            }
            
            System.out.print("Chevalet model : ");
            for (Jeton j : chev.getChev()) {
                System.out.print(j.getChar() + " ");
            }
            
            System.out.println("Sac contenu : ");
            sac.afficherSac();
 
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
        scrabble.notif();
    }

    public static void main(String[] args) {
        launch();
    }
    
//    
//    private static Stage pStage;
//    
//    private void setPrimaryStage(Stage pStage) {
//        this.pStage = pStage;
//    }
//    
//    public static Stage getPrimaryStage() {
//        return pStage;
//    }
//    
//    Stage newStage = new Stage();
//    
//    
//    public void nouvelleFenetre() {
//        MainView anotherViewGUI = new MainView(newStage, viewGrille, viewChevalet, this);
//    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        setPrimaryStage(primaryStage);
        MainView viewGUI = new MainView(primaryStage, viewGrille, viewChevalet, this);
    }

}
