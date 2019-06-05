import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

public class App extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage)  throws Exception{      
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();
        Controller contr = loader.getController();
        
        stage.setTitle("Space Invaders");
        Scene scene = new Scene(root);
        
        contr.setScene(scene);
        contr.steuerungEinrichten();
        stage.setScene(scene);
        stage.show();

    }

}