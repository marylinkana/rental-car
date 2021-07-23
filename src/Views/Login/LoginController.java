/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Login;

import Controllers.Login;
import Controllers.Root;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    @FXML
    private Button submit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //imageHeader.setImage(new Image("@SB_RentalCar.png"));
    }    
    
    @FXML
    private TextField email;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private Label verify;
    
    @FXML
    private ImageView imageHeader;

    @FXML
    public void connection(ActionEvent event) throws Exception {
        String verification = Controllers.Login.verify(email.getText(), password.getText());
        verify.setText(verification);
        if(verification.equals("welcome")){
                       
            if(Login.session.getUserlevel().equals("ADMINISTRATOR")){
                Root admin = new Root("Admin", "..\\Views\\Admin\\Admin.fxml");
                Stage stage = new Stage();
                admin.start(stage);
            }
            else{
                Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
                Stage stage = new Stage();
                rent.start(stage);
            }
            Stage stg = (Stage)submit.getScene().getWindow();
            stg.close();
        }
    }

    
}
