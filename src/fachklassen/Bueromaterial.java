package fachklassen;

import java.util.ArrayList;

public class Bueromaterial {
    private ArrayList<Angebot> angebotsliste = new ArrayList<Angebot>();
    private int bueromaterialnr;
    private String bezeichnung;

    public int getBueromaterialnr() {
        return bueromaterialnr;
    }

    public void setBueromaterialnr(int pBueromaterialnr) {
        bueromaterialnr = pBueromaterialnr;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String pBezeichnung) {
        bezeichnung = pBezeichnung;
    }

    public void setAngebot(Angebot pAngebot) {
        angebotsliste.add(pAngebot);
    }

    public Angebot getAngebot(int pStelle) {
        return angebotsliste.get(pStelle);
    }

}
