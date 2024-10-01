package org.example.network.socketstudy;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMultiClientFileServer {
    private static final int PORT = 1234;
    private static final String FILE_PATH = "C:/a/server/to/file.txt"; // 전송할 파일 경로

    public static void main(String[] args) {
        System.out.println("File server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new FileTransferHandler(clientSocket).start(); // 각 클라이언트를 새로운 스레드로 처리
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class FileTransferHandler extends Thread {
        private Socket clientSocket;

        public FileTransferHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                File file = new File(FILE_PATH);
                byte[] fileBytes = new byte[(int) file.length()];

                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                bufferedInputStream.read(fileBytes, 0, fileBytes.length);

                OutputStream outputStream = clientSocket.getOutputStream();
                outputStream.write(fileBytes, 0, fileBytes.length);
                outputStream.flush();

                System.out.println("File sent to client");
                bufferedInputStream.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}