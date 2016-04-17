package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewJetonTemp extends ViewJeton {
    
    private final ControllerGUI ctrl;
    private final Jeton j;
    private final Color TEMP_COLOR = Color.web("ffffcc");//Color.SNOW;
    private final String cssJetonTemp = "-fx-stroke:yellow; -fx-stroke-width: 2;\n";
    private String lettre;
    
    
    public ViewJetonTemp(int x, int y, Jeton jeton, ControllerGUI ctrl, ViewChevalet viewChevalet) {
        super(x, y, jeton, ctrl, viewChevalet);
        this.ctrl = ctrl;
        this.j = jeton;
        setColorJeton(TEMP_COLOR);
        setStyleJeton(cssJetonTemp);
        lettre = j.getStr();
        setLettre(lettre);
        
    }
    
    public void setColorJeton(Color col) {
        getRectJeton().setFill(col);
    }
    
    public void setStyleJeton(String style) {
        getRectJeton().setStyle(style);
    }
    
    public void setLettre(String lettre) {
        this.lettre = j.getStr();
    }
    
    public Jeton getJeton() {
        return this.j;
    }
    
}
