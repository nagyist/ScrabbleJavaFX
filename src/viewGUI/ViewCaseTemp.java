
package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewCaseTemp extends ViewCase {
    
    private final ControllerGUI ctrl;
    private final Color TEMP_COLOR = Color.SNOW;
    private final String cssJetonTemp
                = "-fx-stroke: black;\n"
                + "-fx-stroke-width: 1;\n"
                + "-fx-stroke-dash-array: 4 4 4 4;\n"
                + "-fx-stroke-dash-offset: 4;\n";
//                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
    
    public ViewCaseTemp(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        this.ctrl = ctrl;
        setColorCase(TEMP_COLOR);
        setStyleCase(cssJetonTemp);
        setLettre(lettre);
    }
    
    
    public Jeton getJeton() {
        return ctrl.getCourant();
    }
    
    public String getLettreViewCaseTemp() {
        return getLettre().toString();
    }
  

    @Override
    public void affiche() {
    }
    
}
