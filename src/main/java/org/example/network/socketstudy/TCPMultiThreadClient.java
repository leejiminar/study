package org.example.network.socketstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPMultiThreadClient {
    private static final String SERVER_ADDRESS = "183.102.97.161";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)) {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            new Thread(new MessageReceiver(input)).start();

            String message;
            while (true) {
                message = keyboard.readLine();
                output.println(message);

                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class MessageReceiver implements Runnable {
        private BufferedReader input;

        public MessageReceiver(BufferedReader input) {
            this.input = input;
        }

        public void run() {
            try {
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Server: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}