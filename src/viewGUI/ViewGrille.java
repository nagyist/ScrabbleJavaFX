package viewGUI;

import controllerGUI.ControllerGUI;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.GridPane;
import model.*;
import static model.Grille.DIM;

/**
 *
 * @author raphaelgrau
 */
public class ViewGrille extends GridPane implements Observer {
    
    private final ControllerGUI ctrl;
    private final Grille grille;
    private ViewCase viewCase;
        
    public ViewGrille(ControllerGUI ctrl) {
        this.ctrl = ctrl;
        this.grille = ctrl.getGrille(); 
    }    
    
    public void afficherGrille() {
        
        for (int li = 0; li < DIM; li++) {
            for (int co = 0; co < DIM; co++) {
                Point pt = new Point(li, co);
                Case caseCourante = grille.getCase(pt);
                
                if (caseCourante.getChar() != ' ') {
                    viewCase = new ViewSimple(li, co, "" + caseCourante.getChar(), this, ctrl);
                } else if (caseCourante instanceof model.Double) {
                    viewCase = new ViewDouble(li, co, "" + caseCourante.getChar(), this, ctrl);
                }
                else if (caseCourante instanceof Triple) {
                    viewCase = new ViewTriple(li, co, "" + caseCourante.getChar(), this, ctrl);
                }
                else if (caseCourante instanceof MotDouble) {
                    viewCase = new ViewMotDouble(li, co, "" + caseCourante.getChar(), this, ctrl);
                } 
                else if (caseCourante instanceof MotTriple) {
                    viewCase = new ViewMotTriple(li, co, "" + caseCourante.getChar(), this, ctrl);
                } else {
                    viewCase = new ViewSimple(li, co, "" + caseCourante.getChar(), this, ctrl);  
                }
                this.add(viewCase, li, co);
                
            }
        }
    }

    public Jeton getCourant() {
        return ctrl.getCourant();     
    }
    
    public void setCourant(Jeton courant) {
        ctrl.setCourant(courant);
    }
    
    public ViewCase getViewCase(int x, int y) {      
        return (ViewCase)this.getChildren().get( x * DIM + y);
    }
    
    public void removeViewCase(int x, int y) {
        getViewCase(x,y).getChildren().remove(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        
        for (ViewCaseTemp vct : ctrl.getListCasesTemp()) {
            ctrl.removeViewCaseTemp(vct);
//            ctrl.placerViewJetonGrille(vct);
        }
        
        for (ViewJeton vj : ctrl.getListJetonsJoues()) { 
            ctrl.placerViewJetonGrille(vj);
        }
        
        ctrl.getListCasesTemp().clear();
        
    }
    

    
     

}


