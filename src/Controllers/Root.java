/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kanab
 */
public class Root extends Application{
    
    private String title;
    private String resource;

    /**
     * construtor of root with title of the page and the path
     */
    public Root(String title, String resource) {
        this.title = title;
        this.resource = resource;
    }

    /**
     * set the new scene and show 
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent;
        parent = FXMLLoader.load(
                getClass().getResource(resource));
        Scene scene = new Scene(parent);

        stage.setTitle(title); 
        stage.setScene(scene);
        stage.show();  
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
