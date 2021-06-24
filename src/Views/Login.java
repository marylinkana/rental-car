/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author kanab
 */
public class Login extends Application {
    
    
        
    @Override
    public void start(Stage primaryStage) {
        Button btnSend = new Button();
        ComboBox log = new ComboBox();
        btnSend.setText("Say 'Welcome to SB RENTAL CAR'");
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Welcome to SB RENTAL CAR!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btnSend);
        root.getChildren().add(log);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Welcome!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
