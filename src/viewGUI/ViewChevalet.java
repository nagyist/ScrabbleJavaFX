package viewGUI;

import controllerGUI.ControllerGUI;
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
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }
    

    public void initChevalet() {
        
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(j, ctrl, this);
            this.getChildren().add(vJeton);
        }    
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
