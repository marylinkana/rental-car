/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Rent;

import Controllers.Login;
import Entities.Car;
import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javax.sound.midi.ControllerEventListener;

/**
 * FXML Controller class
 *
 * @author kanab
 */
public class RentController implements Initializable {
    private final ObservableList carsList = FXCollections.observableArrayList();


    @FXML
    private DatePicker start;
    @FXML
    private DatePicker end;
    @FXML
    private ChoiceBox<Car> car;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Car> cars = Controllers.Administration.getCars();
        for (Car car : cars) {
            carsList.addAll(car);
        }
        car.setItems(carsList);
    }    

    @FXML
    public void rent(ActionEvent event) {
        String immat = car.getSelectionModel().getSelectedItem().getImmatriculation();
        String login = Login.session.getLogin();
        System.out.println(immat + login + start.getValue() + end.getValue());
        Controllers.Rental.newRent(immat, login, start.getValue(), end.getValue());
    }
}
