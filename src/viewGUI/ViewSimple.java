package viewGUI;

import javafx.scene.paint.Color;

/**
 *
 * @author 0404ragrau
 */
public class ViewSimple extends ViewCase {

        
    public ViewSimple(String lettre, ViewGrille viewGrille) {
        super(lettre, viewGrille);
        carreCase.setFill(Color.web("009966"));
    }
    

    @Override
    public void affiche() {
    }

    
}
