package org.example;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {
    public void add(int a){
        a = a + 2;
        System.out.println("## 1 : "+ a);
    }
    public void add(ArrayList list){
        ArrayList tList = (ArrayList) list.clone();
        tList.add("B");
        System.out.println("## 3 : "+ tList);
    }

    public static void main(String[] args) {
        CloneTest test = new CloneTest();

        int a = 1;
        test.add(a);
        System.out.println("## 2 : "+ a);

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        test.add(list);
        System.out.println("## 4 : "+ list);
    }
}