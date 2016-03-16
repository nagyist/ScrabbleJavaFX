package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
    private final VBox root = new VBox();
    private final String cssDefault = "-fx-stroke: black; -fx-stroke-width: 100; -fx-background-radius: 5;"
                                    + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)";

    public MainView(Stage stage, ViewGrille viewGrille, ViewChevalet viewChevalet, ControllerGUI ctrl) {
        this.viewChevalet = viewChevalet;
        this.viewGrille = viewGrille;
        this.viewControls = new ViewControls(viewChevalet, ctrl);
        Scene scene = new Scene(root);//, 600, 800);

        configurePane();

        stage.setTitle("Scrabble");
        stage.setScene(scene);
        stage.show();
    }

    public void configurePane() {

        viewGrille.setStyle(cssDefault);

        root.getChildren().add(viewGrille);
        root.getChildren().add(viewControls);
        
        root.setSpacing(20);
        root.setPadding(new Insets(30, 30, 30, 30));

        viewGrille.afficherGrille();
        viewChevalet.initChevalet();
    }
}
