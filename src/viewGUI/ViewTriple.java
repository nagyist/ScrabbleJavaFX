package viewGUI;

import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewTriple extends ViewCase {

    
    public ViewTriple(String lettre, ViewGrille viewGrille) {
        super(lettre, viewGrille);
        carreCase.setFill(Color.web("0066cc"));
    }
    

    @Override
    public void affiche() {
    }

    
}
