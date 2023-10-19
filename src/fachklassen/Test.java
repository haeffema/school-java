package fachklassen;

public class Test {
    public static void main(String[] args) {
        Bueromaterial b1 = new Bueromaterial(89, "Kugelschreiber");
        Bueromaterial b2 = new Bueromaterial(90, "Schnellhefter");
        Angebot a1 = new Angebot(1.90, 500);
        a1.setMeinWerbegeschenk(b1);
        Angebot a2 = new Angebot(0.50, 501);
        a2.setMeinWerbegeschenk(b2);
        Lieferer l1 = new Lieferer(100, "Schmidt KG");
        l1.setAngebot(a1);
        l1.setAngebot(a2);
    }
}
