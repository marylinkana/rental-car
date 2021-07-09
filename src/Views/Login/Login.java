package Views.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author kanab
 */
public class Login extends Application {
        
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage loginPage) throws Exception {
        Parent parent = FXMLLoader.load(
            getClass().getResource("NewLogin.fxml"));
        Scene scene = new Scene(parent);
        loginPage.setTitle("Login"); 
        loginPage.setScene(scene);
        loginPage.show(); 
    }
    
}
