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
public class ViewChevalet extends FlowPane implements Iterable {
    
    
    private final Chevalet chev;
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();       
    }
    
    
    
    public void afficherChevalet() {
        
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(j.getStr().toUpperCase());
            this.getChildren().add(vJeton);
        }    
    } 

    @Override
    public Iterator iterator() {
        Iterator it = this.iterator();
        return it;   
    }

    String getText() {
        return "aaa";
        }

}
