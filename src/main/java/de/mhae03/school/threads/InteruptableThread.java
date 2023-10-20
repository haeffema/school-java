package de.mhae03.school.threads;

public class InteruptableThread extends Thread {
    @Override
    public void run() {
        while (!Thread.currentThread()
                      .isInterrupted()) {
            System.out.println("Ich laufe.");
        }
        System.out.println("Auf Wiedersehen!");
    }
}
