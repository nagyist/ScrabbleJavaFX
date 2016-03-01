package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewMotDouble extends ViewCase {


    public ViewMotDouble(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        getCarreCase().setFill(Color.web("ffcccc"));
    }
    

    @Override
    public void affiche() {
    }

    
}
