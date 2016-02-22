package viewGUI;

import controllerGUI.ControllerGUI;
import java.awt.Label;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author raphaelgrau
 */
public class MainView extends Stage {

    private final ViewChevalet viewChevalet;
    private final ViewGrille viewGrille;
//    private final ViewBoutons viewBoutons;

    private int startX = 0;
    private int startY = 0;
    private int x0, y0;
    ViewJeton selection;

    private BorderPane root = new BorderPane();
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

//        Rectangle rect = new Rectangle();
////        Rectangle test = new Rectangle(40, 40, Color.web("ffffcc"));
////        Text t = new Text ("h");
//        ViewJeton test = new ViewJeton("h");
//
////        FlowPane flowTest = new FlowPane();
////        flowTest.getChildren().add(test);
//        root.setTop(test);




//        viewGrille.setOnDragEntered(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* the drag-and-drop gesture entered the target */
//                /* show to the user that it is an actual gesture target */
//                if (event.getGestureSource() != viewGrille
//                        && event.getDragboard().hasString()) {
//                    
//                    viewGrille.setFill(Color.GREEN);
//                }
//
//                event.consume();
//            }
//        });
//        
//        target.setOnDragExited(new EventHandler<DragEvent>() {
//            public void handle(DragEvent event) {
//                /* mouse moved away, remove the graphical cues */
//                target.setFill(Color.BLACK);
//
//                event.consume();
//            }
//        });
//        viewGrille.setOnDragDropped(new EventHandler<DragEvent>() {
//
//            public void handle(DragEvent event) {
//                /* data dropped */
//                /* if there is a string data on dragboard, read it and use it */
//                Dragboard db = event.getDragboard();
//                boolean success = false;
//                if (db.hasString()) {
////                    viewGrille.setText(db.getString());
//                    success = true;
//                }
//                /* let the source know whether the string was successfully 
//                 * transferred and used */
//                event.setDropCompleted(success);
//
//                event.consume();
//            }
//        });

//        root.setOnMousePressed((MouseEvent e) -> {
//            startX = (int) e.getX();
//            startY = (int) e.getY();
//            selection = null;
//            
//            
//            for (ViewJeton vJeton : viewChevalet) {
//                if (vJeton.isOn((int) e.getX(), (int) e.getY())) {
//                    selection = vJeton;
//                    x0 = selection.getX();
//                    y0 = selection.getY();
//                }
//            }
//        });
//
//        root.setOnMouseReleased((MouseEvent e) -> {
//            int stopX = (int) e.getX();
//            int stopY = (int) e.getY();
//            if (stopX > startX && stopY > startY) {
//                if (mode == Mode.RECTANGLE) {
//                    shapeList.add(new Rectangle(startX, startY, stopX - startX, stopY - startY));
//                } else if (mode == Mode.CIRCLE) {
//                    shapeList.add(new Circle(startX, startY, Math.min(stopX - startX, stopY - startY) / 2));
//                }
//                repaint();
//            }
//        });
//
//        root.setOnMouseDragged((MouseEvent e) -> {
//            if (mode == Mode.MOVE && selection != null) {
//                selection.moveTo(x0 + (int) e.getX() - startX, y0 + (int) e.getY() - startY);
//                repaint();
//            } else if (mode == Mode.CIRCLE || mode == Mode.RECTANGLE) {
//                drawGhost((int) e.getX(), (int) e.getY());
//            }
//        });
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
        viewChevalet.afficherChevalet();

        // Tests FlowPane
        Button btn = new Button();
        btn.setText("OK");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("OK!");
            }
        });

        Label label = new Label("Scrabble");
        Button btn2 = new Button();
        btn2.setText("Cancel");

//        ViewJeton jeton = new ViewJeton("C", ctrl, viewGrille);

//        flowTest.getChildren().addAll(label, btn, btn2, jeton);    
    }
}
