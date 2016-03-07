package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    } 
    
    public void removeViewJeton(Jeton jj) {        
        for (Iterator<ViewJeton> it = listJetons.iterator(); it.hasNext(); ) {
                ViewJeton vj = it.next();
                if (jj == vj.getCourant()) {
                    it.remove();
                    this.getChildren().remove(vj);
                    return;
                }
            }       
    }
    
}
