package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.HBox;
import model.Chevalet;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewChevalet extends HBox implements Observer {
    
     
    private final Chevalet chev;
    private final ControllerGUI ctrl;
    private final List<ViewJeton> listViewJetonsChevalet = new ArrayList<>();
    

    public ViewChevalet(ControllerGUI ctrl) {
        this.chev = ctrl.getChevalet();   
        this.ctrl = ctrl;
    }

    public List<ViewJeton> getListViewJetonsChevalet() {
        return listViewJetonsChevalet;
    }
       
    public void initChevalet() {        
        listViewJetonsChevalet.clear();
        ctrl.getListJetonsJoues().clear();
        for (Jeton j : chev.getChev()) {
            ViewJeton vJeton = new ViewJeton(0, 0, j, ctrl, this);
            listViewJetonsChevalet.add(vJeton);
        }   
        this.getChildren().clear();
        this.getChildren().addAll(listViewJetonsChevalet);
    } 
    
    public void addViewJeton(ViewJeton vj) {
        this.getChildren().add(vj);
        listViewJetonsChevalet.add(vj);
    }
      
    
    public void removeViewJetonFromChevalet(Jeton jj) {        
        for (Iterator<ViewJeton> it = listViewJetonsChevalet.iterator(); it.hasNext(); ) {
                ViewJeton vj = it.next();
                if (jj == vj.getCourant()) {
                    ctrl.getListJetonsJoues().add(vj);
                    it.remove();
                    this.getChildren().remove(vj);
                    return;
                }
            }       
    }  

    @Override
    public void update(Observable o, Object arg) { 
        
        
        initChevalet();
    }
}
