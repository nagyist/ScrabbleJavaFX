
package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewCaseTemp extends ViewCase {
    
    private final ControllerGUI ctrl;
    private final Jeton j;
    private final Color TEMP_COLOR = Color.web("ffffcc");//Color.SNOW;
    private final String cssJetonTemp = "-fx-stroke:yellow; -fx-stroke-width: 2;\n";

    
    public ViewCaseTemp(int x, int y, String lettre, Jeton j, ViewGrille viewGrille, ControllerGUI ctrl) {
        super(x, y, lettre, viewGrille, ctrl);
        this.ctrl = ctrl;
        this.j = j;
        setColorCase(TEMP_COLOR);
        setStyleCase(cssJetonTemp);
        setLettre(lettre);
        j.setX(x);
        j.setY(y);
        
        Tooltip t = new Tooltip(j.afficherPoints());
        Tooltip.install(this, t);
    }
    
    public Jeton getJeton() {
        return j;
    }
    
    public Jeton getJetonCourant() {
        return ctrl.getCourant();
    }
    
    // =====> meme méthode ????
    
       
    public int getPosX() {
        return getX();
    }
    
    public int getPosY() {
        return getY();
    }
    
    public char getChar() {
        return j.getChar();
    }        
}
