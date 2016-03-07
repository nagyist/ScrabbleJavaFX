package viewGUI;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author 0404ragrau
 */
public class ViewButtons extends HBox {
    
    
        public ViewButtons() {
            
            Button btnOK = new Button();
            btnOK.setText("OK");
            btnOK.setOnAction((ActionEvent event) -> {
                System.out.println("OK!");
            });

            Button btnCancel = new Button();
            btnCancel.setText("Cancel");
            
            this.getChildren().addAll(btnOK, btnCancel);
            
            this.setAlignment(Pos.CENTER);

            
        }
    
    

    
    
    
}
