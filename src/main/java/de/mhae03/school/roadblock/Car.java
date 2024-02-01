package de.mhae03.school.roadblock;

public class Car extends Thread {

    private final Block block;

    public Car(Block block) {
        this.block = block;
    }

    @Override
    public void run() {
        System.out.println("I stopped");
        synchronized (block) {
            try {
                block.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Im driving.");
    }
}
