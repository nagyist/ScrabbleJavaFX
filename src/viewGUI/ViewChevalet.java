package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import javafx.scene.layout.FlowPane;
import model.Chevalet;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewChevalet extends FlowPane {
    
    
    private final Chevalet chev;
    private final ControllerGUI ctrl;
    private ArrayList<ViewJeton> listJetons;
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }
    

    public void initChevalet() {        
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(j, ctrl, this);
            this.getChildren().add(vJeton);
            listJetons.add(vJeton);
        }
//        this.getChildren().addAll(listJetons);
        
    } 
    
//    public void afficherChevalet() {
//        for (ViewJeton v : listJetons)
//            this.getChildren().add(v);
//    }
    
//    public ViewJeton getViewJeton(Jeton courant) {
//        for (Jeton j : chev.getChev()) {
//            if (j == courant)
//                return j;
//        }
//    }
    
    public void removeViewJeton() {
        
        
    }
    
//    public void afficherChevalet() {
//        for (Jeton j : chev.getChev()) {
//            
//        }
//    }
    
//    public Jeton getCourant() {
//        return ctrl.getCourant();
//    }

}
