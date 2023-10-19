package threads;

import java.time.LocalDateTime;

public class DateThread extends Thread {

    private final int id;

    public DateThread(int id) {
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
