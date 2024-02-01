package de.mhae03.school.roadblock;

import java.util.Random;

public class Roadblock extends Thread {

    private final Block block;

    public Roadblock(Block block) {
        this.block = block;
    }

    @Override
    public void run() {
        synchronized (block) {
            try {
                Thread.sleep(new Random().nextInt(5555) + 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Street is available");
            block.notifyAll();
        }
    }
}
