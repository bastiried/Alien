import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;

public class Alien3 extends Alien
{
    
    public Alien3(Pane flaeche_,double x_,double y_)
    {
        super(flaeche_, x_, y_);
        symbol.setImage(new Image("köter.png"));
        
    }

    
}