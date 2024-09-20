package org.example;

import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) {
        /*
        String[] answers = {"a", "B", "C"};
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : answers) {
            stringBuilder.append(s);
        }
        System.out.println(stringBuilder);
        stringBuilder.insert(2, "x");
        System.out.println(stringBuilder);
        stringBuilder.replace(1, 2, "zzz");
        System.out.println(stringBuilder);
        stringBuilder.delete(0, 3);
        System.out.println(stringBuilder);
         */
        String s = "apple,banana,grape";
        StringTokenizer st = new StringTokenizer(s, ",");
        System.out.println("## 1 ## " + st.countTokens());
        while (st.hasMoreTokens()) {
            System.out.println("## 2 ## " + st.countTokens());
            System.out.println(st.nextToken());
            System.out.println("## 3 ## " + st.countTokens());
        }
        System.out.println("## 4 ## " + st.countTokens());
    }
}
