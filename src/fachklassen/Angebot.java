package fachklassen;

public class Angebot {
    private int angebotsnr;
    private double angebotspreis;
    private Lieferer meinLieferer;
    private Bueromaterial meinWerbegeschenk;

    public Angebot(double angebotspreis, int angebotsnr) {
        this.angebotspreis = angebotspreis;
        this.angebotsnr = angebotsnr;
    }

    public int getAngebotsnr() {
        return angebotsnr;
    }

    public void setAngebotsnr(int pAngebotsnr) {
        angebotsnr = pAngebotsnr;
    }

    public Bueromaterial getMeinWerbegeschenk() {
        return meinWerbegeschenk;
    }

    public void setMeinWerbegeschenk(Bueromaterial pMeinWerbegeschenk) {
        meinWerbegeschenk = pMeinWerbegeschenk;
    }

    public double getAngebotspreis() {
        return angebotspreis;
    }

    public void setAngebotspreis(double pAngebotspreis) {
        angebotspreis = pAngebotspreis;
    }

    public Lieferer getMeinLieferer() {
        return meinLieferer;
    }

    public void setMeinLieferer(Lieferer pMeinLieferer) {
        meinLieferer = pMeinLieferer;
    }

}
