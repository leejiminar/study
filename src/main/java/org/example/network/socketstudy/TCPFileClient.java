package org.example.network.socketstudy;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPFileClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;
    private static final String SAVE_PATH = "C:/a/client/to/save/file.txt"; // 저장할 파일 경로 설정

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            byte[] buffer = new byte[1024];
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(SAVE_PATH);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            int bytesRead;
            while ((bytesRead = inputStream.read(buffer, 0, buffer.length)) != -1) {
                bufferedOutputStream.write(buffer, 0, bytesRead);
            }

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            socket.close();
            System.out.println("File received from server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

