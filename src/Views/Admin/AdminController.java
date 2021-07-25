/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import Controllers.Root;
import Entities.Car;
import Entities.User;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class AdminController implements Initializable {
    private final ObservableList carsList = FXCollections.observableArrayList();
    private final ObservableList usersList = FXCollections.observableArrayList();
    private final ObservableList levelsList = FXCollections.observableArrayList();



    @FXML
    private TextField immat;
    @FXML
    private TextField price;
    @FXML
    private TextField desc;
    @FXML
    private ChoiceBox<Car> carsCB;
    @FXML
    private TextField carDiscount;
    @FXML
    private ChoiceBox<User> usersCB;
    @FXML
    private ChoiceBox<String> userLevelsCB;
    @FXML
    private Button sendCar;
    @FXML
    private Button sendCarDiscount;
    @FXML
    private Button sendDiscount;
    @FXML
    private Button goToRent;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Car> cars = Controllers.Administration.getCars();
        for (Car car : cars) {
            carsList.addAll(car);
        }
        carsCB.setItems(carsList);
        
        List<User> users = Controllers.Administration.getUsers();
        for (User user : users) {
            usersList.addAll(user);
        }
        usersCB.setItems(usersList);
        
        levelsList.add("ADMINISTRATOR");
        levelsList.add("BUSINESS MEMBER");
        levelsList.add("INDIVIDUAL MEMBER");
        userLevelsCB.setItems(levelsList);

    }     

    // create new car
    @FXML
    public void newCar(ActionEvent event) throws Exception {
        Controllers.Administration.newCar(immat.getText(), desc.getText(), Double.valueOf(price.getText()));
        refrech();
    }

    //  update car discount
    @FXML
    public void setCarDiscount(ActionEvent event) throws Exception {
        String immat = carsCB.getSelectionModel().getSelectedItem().getImmatriculation();
        Controllers.Administration.SetCarDiscount(Double.valueOf(carDiscount.getText()), immat);
        refrech();
    }
    
    // update user level
    @FXML
    public void setUserLevel(ActionEvent event) throws Exception {
        String user = usersCB.getSelectionModel().getSelectedItem().getLogin();
        String level = userLevelsCB.getSelectionModel().getSelectedItem();
        if(level == "BUSINESS MEMBER"){
            Controllers.Administration.setUserToBusiness(user);
        }
        else if(level == "ADMINISTRATO"){
            Controllers.Administration.setUserToAdmin(user);
        }
        else if(level == "INDIVIDUAL MEMBER"){
            Controllers.Administration.setUserToIndiv(user);
        }
        refrech();
    }
    
    // Root the application to go to rental page
    @FXML
    public void goToRent(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)sendCar.getScene().getWindow();
        stg.close();
    }

    // refrech the page
    private void refrech() throws Exception {
        Root rent = new Root("Rental", "..\\Views\\Admin\\Admin.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)sendCar.getScene().getWindow();
        stg.close();
    }
    
}
