package org.example;

// 도입 전 get 사용시
public class Subject2 {
    public Object val; // Java의 모든 객체는 Object를 상속. Object는 최상위 Super Class

    public void add(Object obj) {
        val = obj;
        System.out.println(val);            // 3
        System.out.println(val.getClass()); // class java.lang.Integer
    }

    public Object get() {
        return val;
    }

    public static void main(String[] args) {
        Subject2 v = new Subject2();
        int a = 3;
        v.add(a);

        int b = 2;
        System.out.println(Integer.parseInt(v.get().toString()) + b);
    }
}
