package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewTriple extends ViewCase {

    
    public ViewTriple(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        getCarreCase().setFill(Color.web("0066cc"));
    }  
}
