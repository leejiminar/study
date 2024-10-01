package org.example.network.socketstudy;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class TCPHeartbeatServer {
    private static final int PORT = 1234;
    private static final int TIMEOUT = 5000; // 5초 후 클라이언트 응답이 없으면 연결 종료

    public static void main(String[] args) {
        System.out.println("Heartbeat monitoring server started...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new HeartbeatHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HeartbeatHandler extends Thread {
        private Socket socket;
        private BufferedReader input;
        private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        public HeartbeatHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                scheduler.scheduleAtFixedRate(() -> checkHeartbeat(), 0, 5, TimeUnit.SECONDS);

                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Received: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        private void checkHeartbeat() {
            try {
                if (!socket.isClosed()) {
                    socket.setSoTimeout(TIMEOUT);
                    System.out.println("Client is alive.");
                } else {
                    System.out.println("Client disconnected.");
                    closeConnection();
                }
            } catch (IOException e) {
                System.out.println("Client heartbeat timeout.");
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                socket.close();
                scheduler.shutdown();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}