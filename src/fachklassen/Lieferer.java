package fachklassen;

import java.util.ArrayList;

public class Lieferer {
    private int lieferernr;
    private String lieferername;
    private ArrayList<Angebot> angebotsliste = new ArrayList<Angebot>();

    public Lieferer(int lieferernr, String lieferername) {
        this.lieferernr = lieferernr;
        this.lieferername = lieferername;
    }

    public int getLieferernr() {
        return lieferernr;
    }

    public void setLieferernr(int pLieferernr) {
        lieferernr = pLieferernr;
    }

    public String getLieferername() {
        return lieferername;
    }

    public void setLieferername(String pLieferername) {
        lieferername = pLieferername;
    }

    public Angebot getAngebot(int pStelle) {
        return angebotsliste.get(pStelle);
    }

    public void setAngebot(Angebot pAngebot) {
        angebotsliste.add(pAngebot);
    }

    public int getAnzahl() {return angebotsliste.size();}

    public double berechneDurchschnitt() {
        double sum = 0;
        for (final Angebot angebot : angebotsliste) {
            sum += angebot.getAngebotspreis();
        }
        return sum / getAnzahl();
    }

    public double berechneMax() {
        double max = 0;
        for (final Angebot angebot : angebotsliste) {
            max = (Math.max(max, angebot.getAngebotspreis()));
        }
        return max;
    }

}
