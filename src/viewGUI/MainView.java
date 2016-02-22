package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
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

    
    public MainView(ViewGrille viewGrille, ViewChevalet viewChevalet, ControllerGUI ctrl, double x, double y) {
        this.viewChevalet = viewChevalet;
        this.viewGrille = viewGrille;
//        this.viewBoutons = new ViewBoutons(ctrl);
        Scene scene = new Scene(root, 800, 800);
        
        configurePane();

        this.setTitle("Scrabble");
        this.setScene(scene);
        
        this.show();
        
        
        
        
        
        viewChevalet.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {

            Dragboard db = viewChevalet.startDragAndDrop(TransferMode.COPY_OR_MOVE);
            
            ClipboardContent content = new ClipboardContent();
            content.putString(viewChevalet.getText());
            db.setContent(content);
            
            event.consume();
            }

            
        });
        
       viewGrille.setOnDragOver(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                if (event.getGestureSource() != viewChevalet &&
                event.getDragboard().hasString())
                
                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                
            event.consume();
            }
        });
       
       
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
       
        viewGrille.setOnDragDropped(new EventHandler<DragEvent>() {
            public void handle(DragEvent event) {
                /* data dropped */
                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasString()) {
//                    viewGrille.setText(db.getString());
                    success = true;
                }
                /* let the source know whether the string was successfully 
                 * transferred and used */
                event.setDropCompleted(success);

                event.consume();
            }
        });
       
            
            
        
        
        
        
        
        
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
        
        final String cssDefault = 
            "-fx-stroke: black;"
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
//        Button btn = new Button();
//        btn.setText("OK");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("OK!");
//            }
//        });
//
//        Label label = new Label("Scrabble");
//        Button btn2 = new Button();
//        btn2.setText("Cancel");
//
//        ViewJeton jeton = new ViewJeton("C");
//
//        FlowPane flowTest = new FlowPane();
//        flowTest.getChildren().addAll(label, btn, btn2, jeton);    
//        root.setTop(flowTest);
    } 
}