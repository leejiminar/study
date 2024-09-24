package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        /*
        * 예외의 종류
        * 모든 에러와 예외 클래스는 Throwable을 상속
        *
        * checked예외
        * 컴파일 시점에 체크
        * 명시적인 예외 처리 필요s
        *
        * Unchecked 예외
        * 런타임 시점에 체크
        * 명시적인 처리를 강제하지 않음
        * */
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("#  S");
//        try {
//            System.out.println("#  1");
//            Class.forName("com.some.nonex");
//            System.out.println("#  2");
//            String str = sc.next();
//        } catch (ClassNotFoundException e) {
//            System.out.println("#  catch");
//            //throw new RuntimeException(e);
//            //e.printStackTrace();
//        } finally {
//            try {   if  (sc != null) {  sc.close(); }   } catch (Exception e) {}
//            System.out.println("#   finally");
//        }
//        System.out.println("#  E");

        try (BufferedReader reader = new BufferedReader(new FileReader("d:/someFile.txt"))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
