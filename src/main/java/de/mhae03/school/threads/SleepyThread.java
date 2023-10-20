package de.mhae03.school.threads;

public class SleepyThread extends Thread {

    private final int id;
    private final int sleepTime;

    public SleepyThread(int id, int sleepTime) {
        this.id = id;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        System.out.printf("%d: Lege mich schlafen.\n", id);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%d: Ich bin wieder wach.\n", id);
    }

}
