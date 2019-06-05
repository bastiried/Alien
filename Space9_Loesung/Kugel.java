import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.geometry.Bounds;


public class Kugel
{
   private double x;
   private double y;
   private double v;
   private double radius;
   private boolean sichtbar;
   private Circle symbol;
   private Pane flaeche;
   
   public Kugel(Pane flaeche_, double x_, double y_)
   {
       flaeche = flaeche_;
       sichtbar = false;
       radius = 3;
       x = x_;
       y = y_;
       v = 0;
       
       // Das Symbol erstellen und auf die Zeichenflaeche setzen.
       symbol = new Circle(radius,Color.YELLOW);
       symbol.relocate(x,y);
       symbol.setVisible(false);
       flaeche.getChildren().add(symbol);
    }
   
   public void update()
   {
       y = y + v;
       symbol.relocate(x,y);
    }
    
    public void setPosition(double x_, double y_)
    {
        x = x_;
        y = y_;
    }
    
    public void setV(double v_)
    {
        v = -10;
    }
    public double getRadius()
    {
        return radius;
    }
    public void sichtbarMachen()
    {
        sichtbar = true;
        symbol.setVisible(true);
    }
    public void unsichtbarMachen()
    {
        sichtbar = false;
        symbol.setVisible(false);
    }
    public boolean trifft(Alien alien)
    {
        Bounds kugelBounds = symbol.getBoundsInParent();  // Rahmen der Kugel
        Bounds alienBounds = alien.gebeBounds();          // Rahmen des Aliens
        if (kugelBounds.intersects(alienBounds))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
