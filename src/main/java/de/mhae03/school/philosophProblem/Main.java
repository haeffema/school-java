package de.mhae03.school.philosophProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Main {

    private static final List<Philosoph> PHILOSOPH_LIST = new ArrayList<>();
    private static final int PHILOSOPH_AMOUNT = 15;

    public static void main(String[] args) {
        for (int i = 0; i < PHILOSOPH_AMOUNT; i++) {
            addAndStartPhilosoph(i + 1);
        }
    }

    private static Semaphore newFork() {
        return new Semaphore(1);
    }

    private static void addAndStartPhilosoph(int id) {
        if (PHILOSOPH_LIST.isEmpty()) {
            Philosoph philosoph = new Philosoph(newFork(), newFork(), id);
            PHILOSOPH_LIST.add(philosoph);
            philosoph.start();
        } else {
            Semaphore leftFork = PHILOSOPH_LIST.get(PHILOSOPH_LIST.size() - 1)
                                               .getRightFork();
            Semaphore rightFork = newFork();
            PHILOSOPH_LIST.get(0)
                          .setLeftFork(rightFork);
            Philosoph philosoph = new Philosoph(leftFork, rightFork, id);
            PHILOSOPH_LIST.add(philosoph);
            philosoph.start();
        }
    }

}
