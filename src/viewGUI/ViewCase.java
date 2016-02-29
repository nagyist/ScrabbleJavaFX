package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Jeton;


/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase extends StackPane {

    
    Text lettre;
    Rectangle carreCase;
    ViewGrille viewGrille;
    private boolean caseJ;
    private ControllerGUI ctrl;
    int x, y;
    
    
    public ViewCase(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        this.x = x;
        this.y = y;
        this.viewGrille = viewGrille;
        this.caseJ = ctrl.getCaseJ();
        
         
        carreCase = new Rectangle(40, 40, Color.PURPLE);
        carreCase.setArcWidth(10);
        carreCase.setArcHeight(10);
        this.getChildren().add(carreCase);
        
        styleCase(lettre);
        
        

        this.getChildren().add(this.lettre); 
        
        
        
        this.setOnDragOver((event) -> {
            final Dragboard db = event.getDragboard();
            
            if (!ctrl.caseJouee(x, y)) {
                
                System.out.println("accepte drag n drop");
                event.acceptTransferModes(TransferMode.ANY);
//                }
                event.consume();
            }
            
        });
        
        this.setOnDragDropped((DragEvent event) -> {

            final Dragboard db = event.getDragboard();
            boolean success = false;
            System.out.println(viewGrille.getCourant());
            System.out.println("coucou");
            String s = db.getString();
            Jeton j = ((ViewJeton) event.getGestureSource()).courant;
            ctrl.placerLettre(x, y, j);
            
            configDrop();

            success = true;
            event.setDropCompleted(success);
            event.consume();
            
        });
    }
    
    
    private void styleCase(String lettre) {
        this.lettre = new Text(lettre);
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.WHITE);

        final String cssDefault
                = "-fx-stroke: black;\n"
                + "-fx-stroke-width: 1;\n"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";

        carreCase.setStyle(cssDefault);
    }
        
    private void configDrop() {
        
        final String cssDefault
                = "-fx-stroke: black;\n"
                + "-fx-stroke-width: 1;\n"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
        
        this.carreCase = new Rectangle(40, 40, Color.web("ffffcc"));
        carreCase.setArcWidth(10);
        carreCase.setArcHeight(10);
        this.getChildren().add(carreCase);
        carreCase.setStyle(cssDefault);

        System.out.println(viewGrille.getCourant().getChar());
        this.lettre = new Text(viewGrille.getCourant().getStr().toUpperCase());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        this.lettre.setStyle("-fx-font-weight: bold");
        this.getChildren().add(this.lettre);
    }
    
    
    public Text getLettre() {
        return lettre;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    

    abstract public void affiche();



    
  

}
