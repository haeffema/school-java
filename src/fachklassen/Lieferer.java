package fachklassen;

import java.util.ArrayList;

public class Lieferer {
    private int lieferernr;
    private String lieferername;
    private ArrayList<Angebot> angebotsliste = new ArrayList<Angebot>();

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

}
