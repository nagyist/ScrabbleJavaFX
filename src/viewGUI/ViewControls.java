package viewGUI;

import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author 0404ragrau
 */
public class ViewControls extends HBox {
    
    private final ViewButtons viewButtons;
    private final ViewChevalet viewChevalet;
    
    
    public ViewControls(ViewChevalet viewChevalet) {
        
        this.viewButtons = new ViewButtons();
        this.viewChevalet = viewChevalet;
        
        this.setAlignment(Pos.CENTER);
       
        this.setSpacing(20);
        
        this.getChildren().addAll(viewChevalet,viewButtons);
        
    }
    
    
}
