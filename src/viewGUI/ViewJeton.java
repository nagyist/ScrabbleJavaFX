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
import model.Jeton;

/**
 *
 * @author raphaelgrau
 */
public class ViewJeton extends StackPane {
   
    
    private Text lettre;
    private Rectangle rectJeton;
    private int positionX;
    private int positionY;
    private Jeton courant;
    private final String cssJetonsChevalet = 
                "-fx-stroke: black;\n"
              + "-fx-stroke-width: 3;\n"
              + "-fx-border-radius: 10, 10, 10, 10;"
              + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
    
    
    public ViewJeton(Jeton jeton, ControllerGUI ctrl, ViewChevalet viewChevalet) {

        this.courant = jeton;
        
        setRectJeton();       
        this.getChildren().add(rectJeton);
        setLettreJeton();
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
//            ctrl.setCaseJouee();

            event.consume();
        });  
        
        
        this.setOnDragDone((event) -> {
            System.out.println("remove jeton");
            final Dragboard db = event.getDragboard();
            String s = db.getString();
            System.out.println("s : " + s);
                       
            Jeton jj = ((ViewJeton) event.getGestureSource()).courant;
//            boolean joue = ((ViewJeton) event.getGestureSource(). );
            
            
//            System.out.println(ctrl.caseJouee());
//            if (!ctrl.caseJouee()) {
//                ctrl.removeJeton(jj);
//            }
            System.out.println("chevalet model : ");
            for (Jeton j : ctrl.getChevalet().getChev())
                System.out.println(j);
//            System.out.println(ctrl.caseJouee());
            
            event.consume(); 
        });
            

        
    }
    private void setRectJeton() {
            rectJeton = new Rectangle(40, 40, Color.web("ffffcc"));
            rectJeton.setArcWidth(10);
            rectJeton.setArcHeight(10);
            rectJeton.setStyle(cssJetonsChevalet);
        }
    
    private void setLettreJeton() {
        this.lettre = new Text (courant.getStr().toUpperCase());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);   
        this.lettre.setStyle("-fx-font-weight: bold");
    }

    public Jeton getCourant() {
        return courant;
    }

    public void setCourant(Jeton courant) {
        this.courant = courant;
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
