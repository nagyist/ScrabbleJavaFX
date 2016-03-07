package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author raphaelgrau
 */
public final class MainView {

    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
    private final ViewControls viewControls;


    private final int startX = 0;
    private final int startY = 0;
    private int x0, y0;
    ViewJeton selection;

    private final VBox root = new VBox();
    private final ControllerGUI ctrl;

    public MainView(Stage stage, ViewGrille viewGrille, ViewChevalet viewChevalet, ControllerGUI ctrl, double x, double y) {
        this.ctrl = ctrl;
        this.viewChevalet = viewChevalet;
        this.viewGrille = viewGrille;
        this.viewControls = new ViewControls(viewChevalet);
        Scene scene = new Scene(root);//, 600, 800);

        configurePane();

        stage.setTitle("Scrabble");
        stage.setScene(scene);
        stage.show();
    }

    public void configurePane() {

        //viewGrille.setAlignment(Pos.CENTER);

        final String cssDefault
                = "-fx-stroke: black;"
                + "-fx-stroke-width: 100;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-radius: 5;";

//        viewGrille.setStyle(cssDefault);

//        viewChevalet.setVgap(2);
//        viewChevalet.setHgap(2);
//        viewChevalet.setPadding(new Insets(0, 0, 30, 0));
        //viewChevalet.setAlignment(Pos.CENTER);

        root.getChildren().add(viewGrille);
        
        root.getChildren().add(viewControls);
        
        root.setSpacing(20);
        root.setPadding(new Insets(30, 30, 30, 30));
        
     
        viewGrille.afficherGrille();
        viewChevalet.initChevalet();
//        viewChevalet.afficherChevalet();

        // Tests FlowPane
 
    }
}
