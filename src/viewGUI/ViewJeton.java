package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewJeton extends StackPane {
    
    public Text lettre;
    final Rectangle jeton;
    private int positionX;
    private int positionY;
    private ControllerGUI ctrl;
    private Jeton courant;
    private final ViewChevalet viewChevalet;
    
    public ViewJeton(Jeton lettre, ControllerGUI ctrl, ViewChevalet viewChevalet) {
        this.ctrl = ctrl;
        this.viewChevalet = viewChevalet;
        this.courant = lettre;
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
       
        this.lettre = new Text (lettre.getStr());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        
        this.lettre.setStyle("-fx-font-weight: bold");
        this.getChildren().add(this.lettre);    
        

        this.setOnMouseEntered((MouseEvent me) -> {
            jeton.setFill(Color.web("f9ffe6"));
        });
        this.setOnMouseExited((MouseEvent me) -> {
            jeton.setFill(Color.web("ffffcc"));
        });
        this.setOnMousePressed((MouseEvent me) -> {
            appuyer();
        });
        this.setOnMouseReleased((MouseEvent me) -> {
            relacher();
        });
        
        
        this.setOnDragDetected((event) -> {
            System.out.println("drag n drop détecté");
            final Dragboard db = this.startDragAndDrop(TransferMode.ANY);

            final ClipboardContent content = new ClipboardContent();
            content.putString("bla bla bla");
            db.setContent(content);
            
            viewChevalet.setCourant(courant);
            
            

            event.consume();
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
