package org.example.restapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String inputData = "I hate test!";
        String inputFilename = "./Test.txt";

        File file = new File(inputFilename);

        // 지시 사항에 따라 코드를 입력해 보세요.
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(inputData.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
