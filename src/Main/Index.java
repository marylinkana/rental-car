package Main;

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
        Root register = new Root("Register", "..\\Views\\Register\\Register.fxml");
        register.start(stage);    
    }
}
