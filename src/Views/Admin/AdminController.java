/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class AdminController implements Initializable {

    @FXML
    private TextField immat;
    @FXML
    private TextField price;
    @FXML
    private TextField desc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void create(ActionEvent event) throws Exception {
        Controllers.Administration.newCar(immat.getText(), desc.getText(), Double.valueOf(price.getText()));
        Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
        Stage stage = new Stage();
        rent.start(stage);
    }
    
}
