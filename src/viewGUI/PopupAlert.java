package viewGUI;

import controllerGUI.ControllerGUI;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author raphaelgrau
 */
public class PopupAlert extends Alert implements Observer {


    public PopupAlert(AlertType type) {
        super(type);
    }
    
    public void alertType(AlertType type) {
        this.setAlertType(type);
    }

    public void alertTitle(String str) {
        this.setTitle(str);
    }
    
    public void alertHeader(String str) {
        this.setHeaderText(str);
    }
    
    public void alertContent(String str) {
        this.setContentText(str);
    }
    
//    public void btAction() {
//        if ()
//            // annuleCoup
//        else
//            // confirmCoup
//    }
    
    
    
    
    public void displayPopupAlert() {
        this.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                System.out.println("alert clicked OK");
                //btAction() ==> action après avoir clické sur OK
                ;
            }
        });
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
       displayPopupAlert();
    }
    
    
    
}
