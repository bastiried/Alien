import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;

public class Schiff
{
    //Attribute
    private double x;
    private double y;
    private double v;

    private double breite = 48;
    private double hoehe = 48;

    private Pane flaeche;
    private ImageView symbol;

    //Konstruktor
    public Schiff(Pane flaeche_,double x_,double y_)
    {
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen();
    }
    //Methoden
    private void symbolErstellen()
    {
        symbol = new ImageView(new Image("gun1.jpg"));
        symbol.relocate(x,y);
        flaeche.getChildren().add(symbol);
    }

    public double getX()
    {
        return x+75;
    }

    public double getY()
    {
        return y;
    }

    public double getBreite()
    {
        return breite;
    }

    public void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
        symbol.relocate(x,y);
    }

    public void nachRechts()
    {
        v = 5;
        symbol.setRotate(10);
    }

    public void nachLinks()
    {
        v = -5;
        symbol.setRotate(-10);
    }

    public void update()
    {
        x = x + v;
        symbol.relocate(x,y);
    }

    public void stoppen()
    {
        v = 0;
        symbol.setRotate(0);
    }

}

