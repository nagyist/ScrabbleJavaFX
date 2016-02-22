package viewGUI;

import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewMotTriple extends ViewCase {

  
    public ViewMotTriple(String lettre, ViewGrille viewGrille) {
        super(lettre, viewGrille);
        carreCase.setFill(Color.web("ff0000"));
    }
    

    @Override
    public void affiche() {
    }

    
}
