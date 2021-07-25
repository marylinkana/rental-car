/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.PayOff;

import Controllers.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class PayoffController implements Initializable {

    @FXML
    private Button confirm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /** 
     * confirm the payment of the rental and back to rental page
     */
    @FXML
    public void confirm(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)confirm.getScene().getWindow();
        stg.close();
    }
    
}
