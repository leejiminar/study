package org.example.socketstudy;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class TCPHeartbeatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;
    private static final int INTERVAL = 3000; // 3초마다 heartbeat 전송

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.scheduleAtFixedRate(() -> sendHeartbeat(output), 0, INTERVAL, TimeUnit.MILLISECONDS);

            System.out.println("Heartbeat started, press Enter to stop...");
            System.in.read(); // Enter를 누르면 종료
            scheduler.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendHeartbeat(PrintWriter output) {
        output.println("heartbeat");
        System.out.println("Sent heartbeat to server");
    }
}