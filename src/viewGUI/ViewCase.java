package viewGUI;

import javafx.scene.Parent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase extends StackPane {

    
    Text lettre;
    Rectangle carreCase;
    ViewGrille viewGrille;
    private boolean caseJouee;
    
    
    public ViewCase(String lettre, ViewGrille viewGrille) {
        this.viewGrille = viewGrille;
        this.caseJouee = false;
        carreCase = new Rectangle(40, 40, Color.PURPLE);
        carreCase.setArcWidth(10);
        carreCase.setArcHeight(10);
        this.getChildren().add(carreCase);
        
        
        this.lettre = new Text (lettre);
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.WHITE);
     
        final String cssDefault = 
            "-fx-stroke: black;\n"
          + "-fx-stroke-width: 1;\n"
          + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);";
        
        carreCase.setStyle(cssDefault);

        this.getChildren().add(this.lettre); 
        
        
        
        this.setOnDragOver((event) -> {
            final Dragboard db = event.getDragboard();
            System.out.println("accepte drag n drop");
            event.acceptTransferModes(TransferMode.ANY);
//                }
            event.consume();
        });
        
        this.setOnDragDropped((DragEvent event) -> {

            final Dragboard db = event.getDragboard();
            boolean success = false;
//            this.setLettre(new Text());
            System.out.println(viewGrille.getCourant());
            System.out.println("coucou");
            
            if (!caseJouee) {           
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
    //            this.lettre.setX(15);
    //            this.lettre.setY(15);
                this.getChildren().add(this.lettre); 


                caseJouee = true;
                success = true;
                event.setDropCompleted(success);
                event.consume();
            } else {
                System.out.println("erreur");
            }
            
        });
    }
    
    public Text getLettre() {
        return lettre;
    }
    

    abstract public void affiche();


  

}
