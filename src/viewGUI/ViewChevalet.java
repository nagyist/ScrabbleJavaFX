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
    private final List<ViewJeton> listViewJetons = new ArrayList<>();
    private final List<ViewJeton> listViewJetonsJoues = new ArrayList<>();
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }

    
    public List<ViewJeton> getListViewJetons() {
        return listViewJetons;
    }
    
    public List<ViewJeton> getListViewJetonsJoues() {
        return listViewJetonsJoues;
    }
    
    public void addViewJetonJoue(ViewJeton vj) {
        listViewJetonsJoues.add(vj);
    }
    
    public ViewJeton getViewJeton(Jeton jj) {
        for (Iterator<ViewJeton> it = listViewJetonsJoues.iterator(); it.hasNext(); ) {
            ViewJeton vj = it.next();
            if (jj == vj.getCourant()) {
                return vj;
            }
        }
        return null;
            
    }
    
    public ViewJeton getViewJetonAt (int x, int y) {
        for (Iterator<ViewJeton> it = listViewJetonsJoues.iterator(); it.hasNext(); ) {
            ViewJeton vj = it.next();
            if (x == vj.getX() && y == vj.getY()) {
                return vj;
            }
        }
        return null;
    }
    
    public void initChevalet() {        
        listViewJetons.clear();
        listViewJetonsJoues.clear();
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(0, 0, j, ctrl, this);
            listViewJetons.add(vJeton);
        }   
        this.getChildren().clear();
        this.getChildren().addAll(listViewJetons);
    } 
    
    
    
    public void removeViewJetonFromChev(Jeton jj) {        
        for (Iterator<ViewJeton> it = listViewJetons.iterator(); it.hasNext(); ) {
                ViewJeton vj = it.next();
                if (jj == vj.getCourant()) {
                    listViewJetonsJoues.add(vj);
                    it.remove();
                    this.getChildren().remove(vj);
                    return;
                }
            }       
    }
    
}
