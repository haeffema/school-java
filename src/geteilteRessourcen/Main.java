package geteilteRessourcen;

public class Main {
    public static void main(String[] args) {
        Tresor tresor = new Tresor();
        startNewThread(tresor, 100);
        startNewThread(tresor, 50);
        startNewThread(tresor, 25);
        startNewThread(tresor, -25);
        startNewThread(tresor, -50);
        startNewThread(tresor, -100);
    }

    private static void startNewThread(Tresor tresor, int value) {
        new TresorZugriffThreads(tresor, value).start();
    }

}
