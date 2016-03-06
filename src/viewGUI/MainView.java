package viewGUI;

import controllerGUI.ControllerGUI;
import java.awt.Label;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author raphaelgrau
 */
public final class MainView extends Stage {

    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
//    private final ViewBoutons viewBoutons;

    private final int startX = 0;
    private final int startY = 0;
    private int x0, y0;
    ViewJeton selection;

    private final BorderPane root = new BorderPane();
    private final ControllerGUI ctrl;

    public MainView(ViewGrille viewGrille, ViewChevalet viewChevalet, ControllerGUI ctrl, double x, double y) {
        this.viewChevalet = viewChevalet;
        this.viewGrille = viewGrille;
        this.ctrl = ctrl;
//        this.viewBoutons = new ViewBoutons(ctrl);
        Scene scene = new Scene(root, 800, 800);

        configurePane();

        this.setTitle("Scrabble");
        this.setScene(scene);

        this.show();

    }

    public void configurePane() {

        viewGrille.setAlignment(Pos.CENTER);

        final String cssDefault
                = "-fx-stroke: black;"
                + "-fx-stroke-width: 100;"
                + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"
                + "-fx-background-radius: 5;";

        viewGrille.setStyle(cssDefault);

        viewChevalet.setVgap(2);
        viewChevalet.setHgap(2);
        viewChevalet.setPadding(new Insets(0, 0, 30, 0));
        viewChevalet.setAlignment(Pos.CENTER);

        root.setCenter(viewGrille);
        root.setBottom(viewChevalet);
//        BorderPane.setMargin(viewChevalet, new Insets(30, 30, 30, 30));
//        BorderPane.setAlignment(viewChevalet, Pos.CENTER);
//        
        viewGrille.afficherGrille();
        viewChevalet.initChevalet();
//        viewChevalet.afficherChevalet();

        // Tests FlowPane
        Button btn = new Button();
        btn.setText("OK");
        btn.setOnAction((ActionEvent event) -> {
            System.out.println("OK!");
        });

        Label label = new Label("Scrabble");
        Button btn2 = new Button();
        btn2.setText("Cancel");

//        ViewJeton jeton = new ViewJeton("C", ctrl, viewGrille);

//        flowTest.getChildren().addAll(label, btn, btn2, jeton);    
    }
}
