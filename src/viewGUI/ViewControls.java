package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 *
 * @author 0404ragrau
 */
public class ViewControls extends HBox {
    
    private final ViewButtons viewButtons;
    private final ViewChevalet viewChevalet;
    
    
    public ViewControls(ViewChevalet viewChevalet, ControllerGUI ctrl) {
        
        this.viewButtons = new ViewButtons(ctrl);
        this.viewChevalet = viewChevalet;
        
        this.viewChevalet.setSpacing(3);
        this.setAlignment(Pos.CENTER);
       
        this.setSpacing(20);
        
        this.getChildren().addAll(viewChevalet,viewButtons);
        
    }
    
    
}
