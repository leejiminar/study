package org.example.restapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

public class HttpRequestBySocket {
    private static final String HOST = "api.openweathermap.org";
    private static final int PORT = 443;

    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();

        try(
                Socket socket = factory.createSocket(HOST, PORT);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter write = new PrintWriter(outputStream, true);

                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))
        ){
            write.println("GET /data/2.5/weather?lat=36.5&lon=127.0&appid=802f611842d9fbf242d026e9f227217d HTTP/1.1");
            write.println("Host: "+ HOST);
            write.println("User-Agent: Chrome");
            write.println("Connection:L close");
            write.println();

            StringBuilder response = new StringBuilder();
            String line;
            boolean isContent = false;
            while((line = reader.readLine()) != null) {
                if(!isContent) {
                    if(line.isEmpty()) {
                        isContent = true;
                    }
                    continue;
                }
                response.append(line);
            }

            System.out.println(response.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}