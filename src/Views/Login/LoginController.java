/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Login;

import Controllers.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class LoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label verify;

    @FXML
    public void connection(ActionEvent event) throws Exception {
        String verification = Controllers.Login.verify(email.getText(), password.getText());
        verify.setText(verification);
        if(verification.equals("welcome")){
            Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
            Stage stage = new Stage();
            rent.start(stage);
        }
    }

    
}
