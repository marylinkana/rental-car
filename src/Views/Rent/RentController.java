/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Rent;

import Controllers.Login;
import Controllers.Root;
import Entities.Car;
import java.net.URL;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    @FXML
    private ImageView carimage;
    @FXML
    private Label descCar;
    @FXML
    private Label priceperday;
    @FXML
    private Label totalcoust;
    @FXML
    private Label discount;
    @FXML
    private Label memberdiscount;
    @FXML
    private Label rentDuration;
    @FXML
    private Label withoutdiscount;

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
    public void rent(ActionEvent event){
        String immat = car.getSelectionModel().getSelectedItem().getImmatriculation();
        String login = Login.session.getLogin();
        
        Controllers.Rental.newRent(immat, login, start.getValue(), end.getValue());
        if(Entities.User.getByLogin(login).getUserlevel().equals("NEW CUSTOMER")){
            Controllers.Administration.setUserToIndiv(login);
        } 
        
        String desc = car.getSelectionModel().getSelectedItem().getDescription();
        Double price = car.getSelectionModel().getSelectedItem().getPriceperday();
        Double carDiscount = car.getSelectionModel().getSelectedItem().getDiscount();
        
        carimage.setImage(new Image("https://img4.autodeclics.com/photos/12/352793/hd-hopium-machina---les-photos-de-la-voiture-hydrog%C3%A8ne-fran%C3%A7aise-aux-1-000-km-d-autonomie.jpg"));
        
        descCar.setText(desc);
        priceperday.setText(price.toString() + " £");
        discount.setText(carDiscount.toString() + " %");
        memberdiscount.setText(Login.session.getDiscountlevel().toString() + " %");
        
        int duration = (int)DAYS.between(start.getValue(), end.getValue());
        rentDuration.setText(String.valueOf(duration) + " days");
                
        double coust = Controllers.Rental.totalCost(Login.session, car.getSelectionModel().getSelectedItem(), duration);
        totalcoust.setText(String.valueOf(coust) + " £");
        
        double economy = car.getSelectionModel().getSelectedItem().getPriceperday() * duration;
        withoutdiscount.setText(String.valueOf(economy) + " £");

    }

    @FXML
    public void goToPay(ActionEvent event) throws Exception {
        Root rent = new Root("Rental", "..\\Views\\PayOff\\PayOff.fxml");
        Stage stage = new Stage();
        rent.start(stage);
    }

}
