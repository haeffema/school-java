package de.mhae03.school.primeNumber;

public class CheckThread extends Thread {

    boolean available = true;
    boolean isPrime = false;
    int number = 0;

    @Override
    public void run() {
        isPrime = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        available = true;
    }
}
