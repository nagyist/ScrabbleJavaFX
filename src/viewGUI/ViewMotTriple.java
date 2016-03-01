package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewMotTriple extends ViewCase {

  
    public ViewMotTriple(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        getCarreCase().setFill(Color.web("ff0000"));
    }
    

    @Override
    public void affiche() {
    }

    
}
