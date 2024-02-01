package de.mhae03.school.roadblock;

public class Main {

    public static void main(String[] args) {
        final Block block = new Block();
        final Roadblock roadblock = new Roadblock(block);
        roadblock.start();
        addCars(1, block);
    }

    public static void addCars(int amount, Block block) {
        for (int i = 0; i < amount; i++) {
            final Car car = new Car(block);
            car.start();
        }
    }

}
