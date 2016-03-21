package viewGUI;

import controllerGUI.ControllerGUI;
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

    
    private Text lettre;
    private Rectangle carreCase;
    private final ViewGrille viewGrille;
    private final int x, y;
    private final String cssCasesGrilleDefault = "-fx-stroke: transparent; -fx-stroke-width: 3;\n";

    
    public ViewCase(int x, int y, String lettre, ViewGrille viewGrille, ControllerGUI ctrl) {
        this.x = x;
        this.y = y;
        this.viewGrille = viewGrille;
        
        initCarreCase();
        initLettreCase(lettre);
        
        this.getChildren().add(this.lettre); 

        
        this.setOnDragOver((event) -> {
    
            if (ctrl.casePossible(x,y)) { 
            // methode casePossible() avec les tests
//            if (!ctrl.caseJouee(x, y) && !ctrl.caseTempJouee(x,y)) {     
                System.out.println("accepte drag n drop");
                event.acceptTransferModes(TransferMode.ANY);
                event.consume();
            } 
        });
        
        this.setOnDragDropped((event) -> {

            boolean success = false;
//            System.out.print("courant : ");
//            System.out.println(viewGrille.getCourant());
            System.out.println(ctrl.getCourant());
            
            Jeton j = ((ViewJeton) event.getGestureSource()).getCourant();
            ctrl.placerLettreTemp(x, y, j);
//            ctrl.setXToViewJeton(x, j);
//            ctrl.setYToViewJeton(y, j);
            System.out.println("ViewJeton x : " + ctrl.getViewJeton(j).getX());
            System.out.println("ViewJeton y : " + ctrl.getViewJeton(j).getY());
            
            this.getChildren().add(ctrl.getViewCaseTemp(j));
            
            success = true;
            event.setDropCompleted(success);
            event.consume();

        });   
    }
    
    private void initCarreCase() {
        carreCase = new Rectangle(40, 40, Color.PURPLE);
        carreCase.setArcWidth(10);
        carreCase.setArcHeight(10);
        carreCase.setStyle(cssCasesGrilleDefault);
        this.getChildren().add(carreCase);
    }
    
    private void initLettreCase(String lettre) {   
        this.lettre = new Text(lettre.toUpperCase());
        this.lettre.setFont(new Font("Serif", 24));
        this.lettre.setFill(Color.BLACK);
        this.lettre.setStyle("-fx-font-weight: bold");
    }
    
      
   
    public Text getLettre() {
        return lettre;
    }
    
    public void setLettre(String lettre) {
        this.lettre = new Text(viewGrille.getCourant().getStr().toUpperCase());
    }
    
    public Rectangle getCarreCase() {
        return carreCase;
    }   
    
    public void setColorCase(Color col) {
        carreCase.setFill(col);
    }
    
    public void setStyleCase(String style) {
        carreCase.setStyle(style);
    }
       
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    } 
}
