package viewGUI;

import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase extends Parent {

    
    final Text lettre;
    Rectangle carreCase;
    
    public ViewCase(String lettre) {
        
        carreCase = new Rectangle(40, 40, Color.PURPLE);
        this.getChildren().add(carreCase);
        
        this.lettre = new Text (lettre);
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.WHITE);
        this.lettre.setX(36);
        this.lettre.setY(34);
        
        final String cssDefault = 
            "-fx-stroke: black;\n"
          + "-fx-stroke-width: 1;\n"
          + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
        
        carreCase.setStyle(cssDefault);

        this.getChildren().add(this.lettre);    
    }
    
    public Text getLettre() {
        return lettre;
    }


    abstract public void affiche();
  

}
