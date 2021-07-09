package Views.Login;

import Controllers.Root;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
/**
 *
 * @author kanab
 */
public class Index extends Application{
    
    private Stage stage = new Stage();
    
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Root login = new Root("Login", "..\\Views\\Login\\Login.fxml");
        login.start(stage);    
    }

}
