/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Register;

import Controllers.Root;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class RegisterController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField adress;
    @FXML
    private TextField login;
    @FXML
    private TextField password;
    @FXML
    private TextField phonenumber;
    @FXML
    private DatePicker age;
    @FXML
    private Button submlit;
    @FXML
    private Label veriflog;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    /** 
     * register a new user
     */
    @FXML
    public void register(ActionEvent event) throws Exception {
        Date ageDate = Date.from(age.getValue().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        LocalDate legalAge = LocalDate.of(2003, 1, 1);
        
        if (age.getValue().isBefore(legalAge)) {
            if (Controllers.Register.verifLog(login.getText())) {
            Controllers.Register.newCustomer(login.getText(), adress.getText(), 
                name.getText(), password.getText(), phonenumber.getText(), ageDate );
            goToLogin(event);
            }
            else veriflog.setText("This login already exist");
        }
        else veriflog.setText("Your age is invalid");
        
        System.out.println("v : " + age.getValue().isBefore(legalAge));
                
    }

    /**
     * go to the login page
     */
    @FXML
    public void goToLogin(ActionEvent event) throws Exception {
        Root login = new Root("Login", "..\\Views\\Login\\Login.fxml");
        Stage stage = new Stage();
        login.start(stage);
        
        Stage stg = (Stage)submlit.getScene().getWindow();
        stg.close();
    }
 
}
