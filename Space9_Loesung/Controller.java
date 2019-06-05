
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.input.KeyEvent;
import javafx.scene.*;

public class Controller {

    private Spielsteuerung spielSteuerung; 
    private Scene scene;

    @FXML // fx:id="flaeche"
    private Pane flaeche; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {       
        spielSteuerung = new Spielsteuerung(flaeche);
       

    }

    public void setScene(Scene scene_)
    {
        scene = scene_;
    }

    public void steuerungEinrichten()
    {
        scene.setOnKeyPressed(e -> {
                spielSteuerung.gedrueckt(e);
            });

        scene.setOnKeyReleased(e -> {
            
                spielSteuerung.losgelassen(e);

            });
    }
}
