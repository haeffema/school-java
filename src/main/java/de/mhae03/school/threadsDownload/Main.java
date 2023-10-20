package de.mhae03.school.threadsDownload;

import java.util.concurrent.Semaphore;

public class Main {

    private static final int MAX_AMOUNT_OF_THREADS = 4;
    private static final Semaphore SEMAPHORE = new Semaphore(MAX_AMOUNT_OF_THREADS);

    public static void main(String[] args) {
        for (int i = 0; i < 26; i++) {
            startDownloader(String.valueOf((char) ((char) 65 + i)));
        }
    }

    private static void startDownloader(String name) {
        new Downloader(SEMAPHORE, name).start();
    }

}
