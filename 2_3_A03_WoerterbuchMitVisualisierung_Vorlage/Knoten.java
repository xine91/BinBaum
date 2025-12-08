/**
 * Klasse Knoten als Bestandteil eines geordneten Binärbaums.
 * (Implementierung mit Entwurfsmuster Kompositum)
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
class Knoten extends Baumelement
{

    /** Datenelement des Knotens */
    private Woerterbucheintrag daten;

    /** Referenz auf den linken Nachfolger */
    private Baumelement linkerNachfolger;
    /** Referenz auf den rechten Nachfolger */
    private Baumelement rechterNachfolger;

    /** Das Darstellungssymbol des Knotens und der Kanten */
    private KnotenSymbol knotenSymbol;
    private KantenSymbol kantenSymbol;

    /**
     * Konstruktor für Objekte der Klasse Knoten ohne linken und rechten Nachfolger, d.h. es werden 
     * zwei Abschluss-Objekte erzeugt und den entsprechenden Referenzattributen zugewiesen.
     * @param datenNeu Referenz auf ein Objekt der KLasse Woerterbucheintrag, das vom Knoten verwaltet wird.
     */
    Knoten(Woerterbucheintrag datenNeu) 
    {
        super();
        daten = datenNeu;
        linkerNachfolger = new Abschluss();
        rechterNachfolger = new Abschluss();

        // Initialisierung der Darstellungssymbole
        knotenSymbol = new KnotenSymbol(100, 100, 25, "cyan", daten.SchlüsselAlsStringGeben());
        knotenSymbol.SichtbarkeitSetzen(true);
    }

    /**
     * Fügt ein Datenelement (Woerterbucheintrag), falls sein Schlüssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum 
     * bleibt erhalten.
     * @param datenNeu einzufügendes Datenelement (Woerterbucheintrag)
     * @return Referenz auf das eigene Objekt
     */
    @Override Baumelement Einfügen(Woerterbucheintrag datenNeu) 
    {
        // ToDo
        return null;
    }

    /*  *******************************************************
     *  Folgende Methoden sind für die Visualisierung nötig!
     *  Sie müssen nicht verstanden werden, dürfen aber auch nicht entfernt werden.
     */
    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    @Override int HöheGeben(int aktTiefe)
    {
        // lokale Attriubute
        int maxHöheLinkerTeilbaum;
        int maxHöheRechterTeilbaum;

        maxHöheLinkerTeilbaum = linkerNachfolger.HöheGeben(aktTiefe + 1);
        maxHöheRechterTeilbaum = rechterNachfolger.HöheGeben(aktTiefe + 1);

        if(maxHöheLinkerTeilbaum > maxHöheRechterTeilbaum)
        {
            return maxHöheLinkerTeilbaum;
        }
        else
        {
            return maxHöheRechterTeilbaum;
        }
    }


    /**
     * Zeichnet den Knoten passend im Zeichenfenster, ergänzt ggf. noch eine Kante zum Vorgänger
     * @param xmin der minimale Wert des Breitenbereichs
     * @param xmax der maximale Wert des Breitenbereichs
     * @param y der y-Wert der Ebene
     * @param dy der Unerschied zur nächsten Ebene
     * @param symbolVorgänger nötig, um die Kante zu zeichnen: das eigene Symbol -> ist für den neuen Knoten das Vorgängersymbol
     */
    @Override void KnotenZeichnen(int xmin, int xmax, int y, int dy, KnotenSymbol symbolVorgänger)
    {
        knotenSymbol.PositionSetzen(xmin + (xmax - xmin) / 2, y);
        // Eine Kante wird nur gezeichnet, wenn es einen Vorgänger gibt (d.h. dieser Knoten nicht die Wurzel ist)
        if(symbolVorgänger != null) 
        { 
            if(kantenSymbol == null)
            {
                kantenSymbol = new KantenSymbol(symbolVorgänger, knotenSymbol, false, "", 3, "schwarz");
            }
            else
            {
                kantenSymbol.DarstellungAktualisieren();
            }
        }

        rechterNachfolger.KnotenZeichnen(xmin + (xmax - xmin) / 2, xmax, y + dy, dy, knotenSymbol);
        linkerNachfolger.KnotenZeichnen(xmin, xmin + (xmax - xmin) / 2, y + dy, dy, knotenSymbol);
    }
}