package geteilteRessourcen;

import java.util.concurrent.ThreadLocalRandom;

public class TresorZugriffThreads extends Thread {

    private final Tresor tresor;
    private final int value;

    public TresorZugriffThreads(Tresor tresor, int value) {
        this.tresor = tresor;
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            if (ThreadLocalRandom.current()
                                 .nextDouble() < 0.05) {
                synchronized (tresor) {
                    int money = tresor.getMoney();
                    if (value < 0) {
                        System.out.printf("%d€ - %d€%n", money, value * -1);
                    } else {
                        System.out.printf("%d€ + %d€%n", money, value);
                    }
                    tresor.setMoney(money + value);
                }
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
