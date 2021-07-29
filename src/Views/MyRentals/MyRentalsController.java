/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.MyRentals;

import Controllers.Root;
import Entities.Car;
import Entities.Duration;
import Entities.Rent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author kanab
 */
public class MyRentalsController implements Initializable {

    
    String loginSession = Controllers.Login.session.getLogin();
    List<Rent> rentals = Controllers.Administration.getRentalsByLogin(loginSession);    
        
    @FXML
    private TableView<Rent> tableR;
    @FXML
    private TableColumn<?, ?> rental;
    @FXML
    private TableColumn<Rent, Car> immat;
    @FXML
    private TableColumn<Rent, Duration> duration;
    @FXML
    private TableColumn<Rent, Double> price;
    @FXML
    private Menu myrentalMenu;
    @FXML
    private Menu adminMenu;
    @FXML
    private Menu rentMenu;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        rental.setCellValueFactory(new PropertyValueFactory<>("idrent"));
        immat.setCellValueFactory(new PropertyValueFactory<>("car"));
        duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        price.setCellValueFactory(new PropertyValueFactory<>("rentalPrice"));
        
        tableR.setItems(FXCollections.observableArrayList(rentals));  
        
        for (Rent rentall : rentals) {
            System.out.println(rentall.getUser().getName());
        }
    }
    
    /**
     * Root the application to go to rental page
     */
    @FXML
    public void goToRent(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\Rent\\Rent.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)tableR.getScene().getWindow();
        stg.close();
    }

        @FXML
    private void goToMyRent(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\MyRentals\\MyRentals.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)tableR.getScene().getWindow();
        stg.close();
    }

    @FXML
    private void goToAdmin(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\Admin\\Admin.fxml");
        Stage stage = new Stage();
        rent.start(stage);
        
        Stage stg = (Stage)tableR.getScene().getWindow();
        stg.close();
    }
    
    
}
