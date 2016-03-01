package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewDouble extends ViewCase {

  
    public ViewDouble(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        getCarreCase().setFill(Color.web("0099ff"));
    }
    
    @Override
    public void affiche() {
    }

    
}
