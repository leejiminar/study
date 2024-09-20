package org.example;

import java.io.*;

public class IoBuffered {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println("이름을 입력해 주세요: ");
        bw.write("name : ");
        bw.write(br.readLine());

        System.out.println("나이를 입력해 주세요: ");
        bw.write(", age : ");
        bw.write(br.readLine());

        bw.flush();

        br.close();
        bw.close();
    }

}
