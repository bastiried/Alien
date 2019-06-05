import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.animation.*;
import javafx.util.Duration;

public class Alien1 extends Alien
{

    public Alien1(Pane flaeche_,double x_,double y_)
    {
        super(flaeche_, x_, y_);
        symbol.setImage(new Image("rob.png"));

    }

    public void getroffen()
    {
        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(1));
        rt.setFromAngle(0);
        rt.setToAngle(2000);       

        FadeTransition ft = new FadeTransition();
        ft.setFromValue(1.0);
        ft.setToValue(0.0);        
        ft.setDuration(Duration.seconds(1));

        ParallelTransition pt = new ParallelTransition(symbol, rt, ft);
        pt.play();

        getroffen = true;
        //symbol.setVisible(false);

    }

}
