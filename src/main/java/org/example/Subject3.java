package org.example;

// 도입 후 get 사용시
public class Subject3 <T> {
    public T val; // 사용하는 곳에서 T(타입 변수)를 받아 자료형을 유동적으로 지정

    public void add(T obj) {
        val = obj;
        System.out.println(val);            // S
        System.out.println(val.getClass()); // class java.lang.String
    }

    public T get() {
        return val;
    }

    public static void main(String[] args) {
        Subject3<Integer> v = new Subject3<>();
        v.add(3);

        System.out.println(v.get() + 2);
    }
}