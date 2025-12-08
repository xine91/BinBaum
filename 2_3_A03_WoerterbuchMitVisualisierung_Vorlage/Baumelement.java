/**
 * Abstrakte Klasse Baumelement zur Realisierung einer Baumstruktur mit Hilfe des Entwurfsmusters
 * Kompositum: Die Klasse legt ausschließlich die Schnittstelle für die Klassen
 * Knoten und Abschluss in Form von Methoden fest.
 * 
 * @author Peter Brichzin
 * @version 23.5.24
 */
abstract class Baumelement
{
    /**
     * Der Konstruktor ist nur der Vollständigkeit halber angegeben.
     */
    Baumelement()
    {
        // nichts zu tun
    }

    /**
     * Fügt ein Datenelement, falls sein Schlüssel noch nicht vorhanden ist,  
     * in die bestehende Datenstruktur ein. D.h. die Eigenschaft geordneter Binärbaum 
     * bleibt erhalten.
     * @param datenNeu das Datenelement des einzufügenden Knoten
     * @return (neues) Nachfolgeelement des Aufrufers
     */
    abstract Baumelement Einfügen(Woerterbucheintrag datenNeu);       

    /*  *******************************************************
     *  Folgende Methoden sind für die Visualisierung nötig!
     *  Sie müssen nicht verstanden werden, dürfen aber auch nicht entfernt werden.
     */

    /**
     * Berechnet die Höhe des Baums und gibt diesen Wert zurück
     * @param aktTiefe Tiefe des aktuellen Knotens
     * @return die Höhe = maximale Tiefe (der bisher besuchten Knoten)
     */
    abstract int HöheGeben(int aktTiefe);

    /**
     * Zeichnet den Knoten passend im Zeichenfenster, ergänzt ggf. noch eine Kante zum Vorgänger
     * @param xmin der minimale Wert des Breitenbereichs
     * @param xmax der maximale Wert des Breitenbereichs
     * @param y der y-Wert der Ebene
     * @param dy der Unterschied zur nächsten Ebene
     * @param symbolVorgänger nötig, um die Kante zu zeichnen: das eigene Symbol -> ist für den neuen Knoten das Vorgängersymbol
     */
    abstract void KnotenZeichnen(int xmin, int xmax, int y, int dy, KnotenSymbol symbolVorgänger);

}
