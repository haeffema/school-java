package de.mhae03.school.threads;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread iThread = new InteruptableThread();

        iThread.start();

        Thread.sleep(1000);

        iThread.interrupt();
    }
}