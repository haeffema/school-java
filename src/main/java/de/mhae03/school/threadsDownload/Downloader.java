package de.mhae03.school.threadsDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {

    Semaphore semaphore;

    public Downloader(Semaphore semaphore, String threadName) {
        super(threadName);
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.printf("Starting %s...%n", this.getName());
        try {
            System.out.printf("%s is waiting for a permit...%n", this.getName());
            semaphore.acquire();
            System.out.printf("%s gets a permit.%n", this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s started downloading.%n", this.getName());
        downloadFile();
        System.out.printf("%s finished downloading.%n", this.getName());
        semaphore.release();
    }

    private void downloadFile() {
        OutputStream outputStream;
        InputStream inputStream;
        String fileLink = "https://central.github.com/deployments/desktop/desktop/latest/win32";
        String path = "C:\\dev\\repo\\school-java\\src\\main\\resources";
        try {
            URL url = new URL(fileLink);
            URLConnection connection = url.openConnection();
            inputStream = connection.getInputStream();
            try {
                outputStream = new FileOutputStream(path);
            } catch (Exception ignored) {
                System.out.printf("%s error on the path.%n", this.getName());
                return;
            }
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, length);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

}
