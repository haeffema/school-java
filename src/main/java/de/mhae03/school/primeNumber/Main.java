package de.mhae03.school.primeNumber;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final int threadNumber = 5;
    private static final int range = 10000000;
    private static final List<CheckThread> threadList = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i <= threadNumber; i++){
            startThread();
        }
        for (int i = 1; i < range; i++) {
            final CheckThread checkThread = getFreeThread();
            if (checkThread.isPrime) {
                System.out.println(checkThread.number);
            }
            checkThread.number = i;
            checkThread.run();
        }
    }

    private static CheckThread getFreeThread() {
        while (true) {
            for (final CheckThread thread : threadList) {
                if (thread.available) {
                    thread.available = false;
                    return thread;
                }
            }
        }
    }

    private static void startThread() {
        threadList.add(new CheckThread());
    }

}
