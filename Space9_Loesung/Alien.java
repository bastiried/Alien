import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.geometry.Bounds;

public class Alien
{
    //Attribute
    private double x;
    private double y;
    private double v;

    private int zaehler; // zählt die Schritte nach links und die Schritte nach rechts
    private double breite = 48;
    private double hoehe = 48;

    private Pane flaeche;
    protected ImageView symbol;

    protected boolean getroffen; // wurde das Alien getroffen oder nicht?

    //Konstruktor
    public Alien(Pane flaeche_,double x_,double y_)
    {
        zaehler = 0;
        x = x_;
        y = y_;
        flaeche = flaeche_;
        symbolErstellen();
        v = 0.5;
        getroffen = false;

    }
    //Methoden
    private void symbolErstellen()
    {
        symbol = new ImageView(new Image("köter.png"));
        symbol.relocate(x,y);
        flaeche.getChildren().add(symbol);
    }

    public double getX()
    {
        return x;
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

    public void update()
    {
        if (getroffen == false)
        {
            zaehler++;
            if (zaehler > 300)
            {
                zaehler = 0;
                v = -v;
                y = y + 10;
            }

            x = x + v;

            symbol.relocate(x,y);
        }
    }
    // wird aufgerufen, wenn das Alien von einer Kugel getroffen wurde
    public void getroffen()
    {
        getroffen = true;
        symbol.setVisible(false);

    }

    public Bounds gebeBounds()
    {
        return symbol.getBoundsInParent();
    }
    
    public boolean getGetroffen()
    {
        return getroffen;
    }

}

