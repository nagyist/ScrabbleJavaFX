package viewGUI;

import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewDouble extends ViewCase {

  
    public ViewDouble(String lettre, ViewGrille viewGrille) {
        super(lettre, viewGrille);
        carreCase.setFill(Color.web("0099ff"));
    }
    
    @Override
    public void affiche() {
    }

    
}
