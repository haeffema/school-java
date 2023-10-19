package threads;

import java.time.LocalDateTime;

public class DateRunnable implements Runnable {

    private final int id;

    public DateRunnable(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for (int x = 0; x < 200; x++) {
            System.out.printf("%d: %s\n", this.id, LocalDateTime.now()
                                                                .toString());
        }
    }

}
