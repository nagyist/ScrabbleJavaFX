package viewGUI;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author raphaelgrau
 */
public class ViewJeton extends StackPane {
    
    final Text lettre;
    final Rectangle jeton;
    private int positionX;
    private int positionY;
    
    public ViewJeton(String lettre) {
        jeton = new Rectangle(40, 40, Color.web("ffffcc"));
        
        jeton.setArcWidth(10);
        jeton.setArcHeight(10);

        this.getChildren().add(jeton);
        
        
        
        final String cssDefault = 
        "-fx-stroke: black;\n"
      + "-fx-stroke-width: 3;\n"
      + "-fx-border-radius: 10, 10, 10, 10;"
      + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
        
        jeton.setStyle(cssDefault);
       
        this.lettre = new Text (lettre);
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        
        this.lettre.setStyle("-fx-font-weight: bold");
        this.getChildren().add(this.lettre);    
        

        this.setOnMouseEntered(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
               jeton.setFill(Color.web("f9ffe6"));
            }
        });
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent me){
                jeton.setFill(Color.web("ffffcc"));
            }
        });
        this.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                appuyer();
            }
        });

        this.setOnMouseReleased(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                relacher();
            }
        });
        
        
    }
    public void appuyer() {
        jeton.setFill(Color.web("fff9b3"));
        this.setTranslateY(positionY + 2);
        this.setTranslateX(positionX - 2);
    }

    public void relacher() {
        jeton.setFill(Color.web("f9ffe6"));
        this.setTranslateY(positionY);
        this.setTranslateX(positionX);
    }
    
    
    public Text getLettre() {
        return lettre;
        
    }

}
