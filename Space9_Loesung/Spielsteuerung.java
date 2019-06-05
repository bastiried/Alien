import java.util.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.scene.paint.Color;

/**
 * Die Klasse Spielsteuerung
 */
public class Spielsteuerung
{
    // Attribute
    private Timer timer;   //ruft immer wieder die update()- Methode auf
    private Pane flaeche; // Zeichenflaeche
    private Schiff schiff;  
    private Kugel kugel;
    private Alien[] aliens;

    private int anzahlGetroffen;
    private int anzahlAliens;

    
    private Text text;

    // Konstruktor
    public Spielsteuerung(Pane flaeche_)
    {
        flaeche = flaeche_;
        timer = new Timer(this);
        schiff = new Schiff(flaeche, 300,350);  
        kugel = new Kugel(flaeche,schiff.getX()+schiff.getBreite()/2-3, schiff.getY());
        anzahlAliens = 24;
        aliens = new Alien[anzahlAliens];
        
        for (int i = 0; i < 8; i++)
        {
            
            aliens[i] = new Alien1(flaeche, 100+ 50*i, 100);
        }
        for (int i = 0; i < 8; i++)
        {
            aliens[i+8] = new Alien2(flaeche,100+ 50*i,150);
        }
        for (int i = 0; i < 8; i++)
        {
            aliens[i+16] = new Alien3(flaeche,100+ 50*i,50);
        }

        
        anzahlGetroffen = 0;
    }

    /**
     * Die Methode update wird immer vom Timer aufgerufen.
     */
    public void update()
    {

        schiff.update();
        kugel.update();
        for (int i = 0; i < anzahlAliens; i++)
        {
            aliens[i].update();
        }

        for (int i = 0; i < anzahlAliens; i++)
        {
            if (kugel.trifft(aliens[i]))
            {
                if (aliens[i].getGetroffen()==false)
                {
                    aliens[i].getroffen();
                    anzahlGetroffen++;
                    istGewonnen();
                }
            }
        }

    }

    public void istGewonnen()
    {
        // Wenn die Anzahl der getroffenen Aliens genauso gross ist
        // wie die Anzahl der Aliens, ist das Spiel gewonnen!
        if (anzahlGetroffen == anzahlAliens)
        {
            timer.stop();
            text = new Text(200,200, "Jetzt n´ Steak!");
            text.setFill(Color.YELLOW);
            text.setFont(new Font(40));
            flaeche.getChildren().add(text);         
            

        }
    }

    /**
     * Tastensteuerung
     */
    // wird aufgerufen, wenn eine Taste gedrückt wurde
    public void gedrueckt(KeyEvent ke)
    {
        if (ke.getCode() == KeyCode.X)
        {
            Platform.exit();
        }

        if (ke.getCode() == KeyCode.LEFT)
        {
            // Das Schiff soll nach links
            schiff.nachLinks();
        }
        if (ke.getCode() == KeyCode.RIGHT)
        {
            // Das Schiff soll nach rechts
            schiff.nachRechts();
        }
        if (ke.getCode() == KeyCode.S)
        {
            timer.start();
        }

        if (ke.getCode() == KeyCode.SPACE)
        {
            kugel.setPosition(schiff.getX()+schiff.getBreite()/2-3, schiff.getY());
            kugel.setV(-2);
            kugel.sichtbarMachen();
        }

    }

    // wird aufgerufen, wenn eine Taste losgelassen wurde
    public void losgelassen(KeyEvent ke)
    {
        if (ke.getCode() != KeyCode.SPACE)
        {
            schiff.stoppen();
        }
    }

}
