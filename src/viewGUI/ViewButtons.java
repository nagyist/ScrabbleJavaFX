package viewGUI;

import controllerGUI.ControllerGUI;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;

/**
 *
 * @author 0404ragrau
 */
public class ViewButtons extends HBox {
    
    
        public ViewButtons(ControllerGUI ctrl) {
            
            Button btnOK = new Button();
            btnOK.setText("Valider");
            btnOK.setOnAction((ActionEvent event) -> {
                System.out.println("OK!");
                ctrl.validerCoup(ctrl.getListCasesTemp());
//                , ctrl.getListJetonsJoues());
                
            });

            Button btnCancel = new Button();
            btnCancel.setText("Annuler");
            btnCancel.setOnAction((ActionEvent event) -> {
                System.out.println("Annuler!");
                ctrl.annulerDerniereLettre();
            });
            
            Button btnChange = new Button();
            btnChange.setText("Changer jetons");
            btnChange.setOnAction((ActionEvent event) -> {
                System.out.println("Change!");
                ctrl.changerJetonsSelected();
            });
            
//            Button btnNewWindow = new Button();
//            btnNewWindow.setText("Nouvelle fenêtre");
//            btnNewWindow.setOnAction((ActionEvent event) -> {
//                System.out.println("Nouvelle fenêtre!");
//                ctrl.nouvelleFenetre();
//            });
            
            Tooltip t = new Tooltip("Tooltip!");
        Tooltip.install(btnCancel, t);
            
            this.getChildren().addAll(btnOK, btnCancel, btnChange); //, btnNewWindow);
            this.setSpacing(5);
            this.setAlignment(Pos.CENTER);          
        }
    
}
