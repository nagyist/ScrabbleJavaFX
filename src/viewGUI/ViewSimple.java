package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewSimple extends ViewCase {

        
    public ViewSimple(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        carreCase.setFill(Color.web("009966"));
    }
    

    @Override
    public void affiche() {
    }

    
}
