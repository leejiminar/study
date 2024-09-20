package org.example;

public class Main {
    public static void main(String[] args) {
        String str = "This is";

        System.out.println(str.equals("This is"));
        System.out.println(str.equals("this is")); // 대소문자 구별
        System.out.println(str.length()); // 공백, 특수문자 포함
        System.out.println(str.indexOf("s")); // 문자 처음 위치 h=1, s=3
        System.out.println(str.lastIndexOf("s")); // 문자 마지막 위치 s=6
        System.out.println(str.toLowerCase()); // 소문자로 변경
        System.out.println(str.toUpperCase()); // 대문자로 변경

        str = null;
        System.out.println(str == null); // str=null;는 true
        str = " ";
        System.out.println(str.isEmpty()); // str="";는 true, str=" ";는 false
        System.out.println(str.isBlank()); // str="";는 true, str=" ";는 true

        str = null;
        /*
        if(str.equals("AA")) { // NullPointerException
            System.out.println("같음");
        }
        */
        if(str != null && str.equals("AA")) {
            System.out.println("같음 1");
        } else {
            System.out.println("다름 1");
        }
        if("AA".equals(str)) {
            System.out.println("같음 2");
        } else {
            System.out.println("다름 2");
        }
    }
}