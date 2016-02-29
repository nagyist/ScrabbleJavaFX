package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Chevalet;
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewJeton extends StackPane {
    
    private final ControllerGUI ctrl;
    private final ViewChevalet viewChevalet;
    private final Chevalet chev;
    public Text lettre;
    private final Rectangle rectJeton;
    private int positionX;
    private int positionY;
    Jeton courant;
    private boolean caseJ;
    
    
    public ViewJeton(Jeton jeton, ControllerGUI ctrl, ViewChevalet viewChevalet) {
        this.ctrl = ctrl;
        this.chev = ctrl.getChevalet();
        this.viewChevalet = viewChevalet;
        this.courant = jeton;
        this.caseJ = ctrl.getCaseJ();
        
        rectJeton = new Rectangle(40, 40, Color.web("ffffcc"));
        rectJeton.setArcWidth(10);
        rectJeton.setArcHeight(10);

        this.getChildren().add(rectJeton);
        
 
        final String cssDefault = 
        "-fx-stroke: black;\n"
      + "-fx-stroke-width: 3;\n"
      + "-fx-border-radius: 10, 10, 10, 10;"
      + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
        
        rectJeton.setStyle(cssDefault);
       
        this.lettre = new Text (jeton.getStr().toUpperCase());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        
        this.lettre.setStyle("-fx-font-weight: bold");
        this.getChildren().add(this.lettre);    
        

        this.setOnMouseEntered((MouseEvent me) -> {
            rectJeton.setFill(Color.web("f9ffe6"));
        });
        this.setOnMouseExited((MouseEvent me) -> {
            rectJeton.setFill(Color.web("ffffcc"));
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
            
            content.putString(jeton.getStr());
            db.setContent(content);
            
            ctrl.setCourant(courant);

            event.consume();
        });  
        
//        this.setOnDragDone((event) -> {
//            System.out.println("remove jeton");
//            
//            
//            ctrl.caseJouee(x, y)
//            
//            if (!caseJ) {
//                chev.removeJeton(courant);
//            }
//            for (Jeton j : chev.getChev())
//                System.out.println(j);
//            this.getChildren().clear();
//            event.consume();
//            
//        });
        
    }
    public void appuyer() {
        rectJeton.setFill(Color.web("fff9b3"));
        this.setTranslateY(positionY + 2);
        this.setTranslateX(positionX - 2);
    }

    public void relacher() {
        rectJeton.setFill(Color.web("f9ffe6"));
        this.setTranslateY(positionY);
        this.setTranslateX(positionX);
    }

}
