package org.example;

// <? extends Integer>  상위 경계 와일드카드
class Member {
    private int id;
    private int age;

    public Member(int id, int age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[MEMBER "+ id +"-"+ age +"]";
    }
}

class Car extends Member {
    public Car(int id, int age) {
        super(id, age);
    }
}

public class Test {
    public static <T extends Member> String returnString(T input) {
        return input.toString();
    }

    private Test() {}

    public static void main(String[] args) {
        Member member = new Member(1, 20);
        Car car = new Car(1, 20);

        System.out.println(Test.returnString(car));
    }
}
