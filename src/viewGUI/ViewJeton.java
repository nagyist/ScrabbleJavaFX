package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.control.Tooltip;
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
                "-fx-stroke: transparent;\n"
              + "-fx-stroke-width: 3;\n"
              + "-fx-border-radius: 10, 10, 10, 10;"
              + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
    private final ViewChevalet vchev;
    private int x, y;
    private final String cssJetonTemp = "-fx-stroke:yellow; -fx-stroke-width: 2;\n"
                          + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";

    
    
    public ViewJeton(int x, int y, Jeton jeton, ControllerGUI ctrl, ViewChevalet viewChevalet) {

        this.courant = jeton;
        this.vchev = viewChevalet;
        this.x = x;
        this.y = y;
        
        setRectJeton();       
        this.getChildren().add(rectJeton);
        setLettreJeton();
        this.getChildren().add(this.lettre);    

        Tooltip t = new Tooltip(jeton.afficherPoints());
        Tooltip.install(this, t);
        


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
        
        
        
        
        this.setOnMouseClicked((event) -> {
            System.out.println("click !!!");
            System.out.println(courant.getChar());

            if (rectJeton.getStyle() == cssJetonTemp) {
                rectJeton.setStyle(cssJetonsChevalet);
                ctrl.removeListJetonsChange(jeton);
            } else {
                rectJeton.setStyle(cssJetonTemp);
                ctrl.addListJetonsChange(jeton);
            }
            
            ctrl.afficheListJetonsChange();


//            if (vjt != null) {
//                ctrl.removeViewJetonTemp(ctrl.getViewJetonTemp(jeton));
//                this.getChildren().remove(ctrl.getViewJetonTemp(jeton));
//            } else {
//                ctrl.placerViewJetonTemp(courant);
//                this.getChildren().add(ctrl.getViewJetonTemp(jeton));
//            }

        });

        
        this.setOnDragDetected((event) -> {
            
            final Dragboard db = this.startDragAndDrop(TransferMode.ANY);
            final ClipboardContent content = new ClipboardContent();
            content.putString(jeton.getStr());
            db.setContent(content);
            
            ctrl.setCourant(courant);

            event.consume();
        });  
        
        
        this.setOnDragDone((event) -> {
            final Dragboard db = event.getDragboard();
            String s = db.getString();
                      
            Jeton jj = ((ViewJeton) event.getGestureSource()).courant;
            
            if (event.isAccepted()) {
                vchev.removeViewJetonFromChevalet(courant);
            }
            
            for (ViewJeton vj : vchev.getListViewJetonsChevalet())
                System.out.println(vj.getLettre());
            ctrl.removeListJetonsChange(courant);
            ctrl.setCourant(null);
                           
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
        lettre = new Text (courant.getStr().toUpperCase());
        lettre.setFont(new Font("Serif", 24));
        lettre.setFill(Color.BLACK);   
        lettre.setStyle("-fx-font-weight: bold");
    }

    public Rectangle getRectJeton() {
        return rectJeton;
    } 
    

    public Jeton getCourant() {
        return courant;
    }
    
    public void setCourant(Jeton courant) {
        this.courant = courant;
    }
    
    public String getLettre() {
        return lettre.getText().toString();
    }
    
    public void setColor(Color col) {
        rectJeton.setFill(col);
    }
       
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
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
