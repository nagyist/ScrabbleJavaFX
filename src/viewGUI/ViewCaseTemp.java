
package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.text.Text;

/**
 *
 * @author raphaelgrau
 */
public class ViewCaseTemp extends ViewCase {

    public ViewCaseTemp(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        getCarreCase().setStyle(cssJetonTemp);
        getCarreCase().setFill(TEMP_COLOR);
        setLettre(lettre);
        System.out.println("lettre : " + lettre);

    }
    
  

    @Override
    public void affiche() {
    }
    
}
