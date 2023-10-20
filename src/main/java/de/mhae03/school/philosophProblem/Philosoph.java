package de.mhae03.school.philosophProblem;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Philosoph extends Thread {

    private Semaphore leftFork;
    private final Semaphore rightFork;
    private final int id;
    private boolean hungry;

    public Philosoph(Semaphore leftFork, Semaphore rightFork, int id) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.id = id;
    }

    public void setLeftFork(Semaphore leftFork) {
        this.leftFork = leftFork;
    }

    public Semaphore getRightFork() {
        return rightFork;
    }

    @Override
    public void run() {
        while (!Thread.currentThread()
                      .isInterrupted()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (hungry) {
                System.out.printf("%d is eating...%n", id);
                if (0.1 < ThreadLocalRandom.current()
                                           .nextDouble()) {
                    leftFork.release();
                    rightFork.release();
                    hungry = false;
                    System.out.printf("%d stopped eating.%n", id);
                }
            } else {
                if (0.1 < ThreadLocalRandom.current()
                                           .nextDouble()) {
                    try {
                        System.out.printf("%d is getting hungry...%n", id);
                        leftFork.acquire();
                        rightFork.acquire();
                        hungry = true;
                    } catch (InterruptedException e) {
                        System.out.printf("Not all forks available for %d.%n", id);
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

}
