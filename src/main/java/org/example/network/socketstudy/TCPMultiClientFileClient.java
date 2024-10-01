package org.example.network.socketstudy;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPMultiClientFileClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;
    private static final String SAVE_PATH = "C:/a/client/to/save/"; // 저장할 파일 경로
    private static final String SAVE_FILE = "file.txt"; // 저장할 파일 이름

    public static void main(String[] args) {
        File path = new File(SAVE_PATH);
        if(!path.exists()) {
            path.mkdirs();
        }

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(SAVE_PATH + SAVE_FILE);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            bufferedOutputStream.close();
            System.out.println("File received from server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}