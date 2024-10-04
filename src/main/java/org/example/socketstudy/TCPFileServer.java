package org.example.socketstudy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer {
    private static final int PORT = 1234;
    private static final String FILE_PATH = "C:/a/server/to/file.txt"; // 파일 경로 설정

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("File server is waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            File file = new File(FILE_PATH);
            byte[] fileBytes = new byte[(int) file.length()];

            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedInputStream.read(fileBytes, 0, fileBytes.length);

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(fileBytes, 0, fileBytes.length);
            outputStream.flush();

            bufferedInputStream.close();
            socket.close();
            System.out.println("File sent to client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
