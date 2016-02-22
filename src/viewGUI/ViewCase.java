package viewGUI;

import javafx.scene.Parent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 *
 * @author 0404ragrau
 */
public abstract class ViewCase extends Parent {

    
    Text lettre;
    Rectangle carreCase;
    ViewGrille viewGrille;
    
    public ViewCase(String lettre, ViewGrille viewGrille) {
        this.viewGrille = viewGrille;
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
        
        
        
        this.setOnDragOver((event) -> {
            final Dragboard db = event.getDragboard();
            System.out.println("accepte drag n drop");
//                DataFormat paintFormat = DataFormat.lookupMimeType(Paint.class.getName());
//                paintFormat = (paintFormat == null) ? new DataFormat(Paint.class.getName()) : paintFormat;
//                if (event.getGestureSource() != test && db.hasContent(paintFormat)) {

            event.acceptTransferModes(TransferMode.ANY);
//                }
            event.consume();
        });
        
        this.setOnDragDropped((DragEvent event) -> {

            final Dragboard db = event.getDragboard();
            boolean success = true;
//            this.setLettre(new Text());
            System.out.println(viewGrille.getCourant());
            System.out.println("coucou");
            
            
            this.carreCase = new Rectangle(40, 40, Color.web("ffffcc"));
            this.getChildren().add(carreCase);
//            carreCase.setStyle(cssDefault);
            System.out.println(viewGrille.getCourant().getChar());
            this.lettre = new Text(viewGrille.getCourant().getStr());
            this.lettre.setFont(new Font("Serif", 24));
            this.lettre.setFill(Color.BLACK);
            this.lettre.setX(15);
            this.lettre.setY(15);
            this.getChildren().add(this.lettre); 
            
            

            event.setDropCompleted(success);
            event.consume();
        });
    }
    
    public Text getLettre() {
        return lettre;
    }

    

    
    
    abstract public void affiche();
  

}
