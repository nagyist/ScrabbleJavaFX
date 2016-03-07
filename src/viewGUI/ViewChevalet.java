package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import model.Chevalet;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewChevalet extends HBox {
    
    
    private final Chevalet chev;
    private final ControllerGUI ctrl;
    private final List<ViewJeton> listJetons = new ArrayList<>();
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }

    public List<ViewJeton> getListJetons() {
        return listJetons;
    }
    
    
    

    public void initChevalet() {        
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(j, ctrl, this);
            this.getChildren().add(vJeton);
            listJetons.add(vJeton);
        }
//        this.getChildren().addAll(listJetons);
        
    } 
    
    public void removeViewJeton(Jeton jj) {
        
//        for (ViewJeton vj : listJetons) {
//            if (jj == vj.getCourant())
//                listJetons.remove(vj);           
//        }   
//    }
    
    for (Iterator<ViewJeton> it = listJetons.iterator(); it.hasNext(); ) {
            ViewJeton vj = it.next();
            if (jj == vj.getCourant()) {
                it.remove();
                this.getChildren().remove(vj);
                return;
            }
        }       
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
    

    
//    public void afficherChevalet() {
//        for (Jeton j : chev.getChev()) {
//            
//        }
//    }
    
//    public Jeton getCourant() {
//        return ctrl.getCourant();
//    }

}
