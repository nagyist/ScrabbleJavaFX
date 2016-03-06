package viewGUI;

import controllerGUI.ControllerGUI;
import java.awt.Point;
import javafx.scene.layout.GridPane;
import model.Case;
import model.Grille;
import static model.Grille.DIM;
import model.Jeton;
import model.MotDouble;
import model.MotTriple;
import model.Triple;



/**
 *
 * @author raphaelgrau
 */
public class ViewGrille extends GridPane {
    
    private final ControllerGUI ctrl;
    private final Grille grille;
        
    public ViewGrille(ControllerGUI ctrl) {
        this.ctrl = ctrl;
        this.grille = ctrl.getGrille(); 
    }    
    
    public void afficherGrille() {
        
        for (int li = 0; li < DIM; li++) {
            for (int co = 0; co < DIM; co++) {
                Point pt = new Point(li, co);
                Case caseCourante = grille.getCase(pt);
                ViewCase viewCase;
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
      

}


