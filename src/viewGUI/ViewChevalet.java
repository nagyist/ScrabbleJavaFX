package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.Iterator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Rectangle;
import model.Chevalet;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewChevalet extends FlowPane {
    
    
    private final Chevalet chev;
    private final ControllerGUI ctrl;
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }
    

    public void afficherChevalet() {
        
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(j, ctrl, this);
            this.getChildren().add(vJeton);
        }    
    } 
    
    public Jeton getCourant() {
        return ctrl.getCourant();
    }

    public void setCourant(Jeton courant) {
        ctrl.setCourant(courant);
    }

}
