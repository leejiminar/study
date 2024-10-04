package org.example.socketstudy;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789); // 서버의 IP 주소와 포트 번호

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("서버에 보낼 메시지를 입력하세요: ");
        sentence = inFromUser.readLine();

        //outToServer.writeBytes(sentence + "\n"); // 한글 깨짐
        outToServer.write((sentence + "\n").getBytes());
        modifiedSentence = inFromServer.readLine();

        System.out.println("서버로부터의 응답: " + modifiedSentence);

        clientSocket.close();
    }
}
