package viewGUI;

import controllerGUI.ControllerGUI;
import java.awt.Point;
import javafx.scene.layout.GridPane;
import model.Case;
import model.Grille;
import static model.Grille.DIM;
import model.MotDouble;
import model.MotTriple;
import model.Triple;



/**
 *
 * @author raphaelgrau
 */
public class ViewGrille extends GridPane {
    
    private ControllerGUI ctrl;
    private Grille grille;
        
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
                    viewCase = new ViewSimple("" + caseCourante.getChar());
                } else if (caseCourante instanceof model.Double) {
                    viewCase = new ViewDouble("" + caseCourante.getChar());
                }
                else if (caseCourante instanceof Triple) {
                    viewCase = new ViewTriple("" + caseCourante.getChar());
                }
                else if (caseCourante instanceof MotDouble) {
                    viewCase = new ViewMotDouble("" + caseCourante.getChar());
                } 
                else if (caseCourante instanceof MotTriple) {
                    viewCase = new ViewMotTriple("" + caseCourante.getChar());
                } else {
                    viewCase = new ViewSimple("" + caseCourante.getChar());  
                }
                this.add(viewCase, li, co);
                
            }
        }
    }
    

}


