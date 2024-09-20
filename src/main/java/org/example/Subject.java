package org.example;

public class Subject <T> {
    public T val;

    public void add(T obj) {
        val = obj;
        System.out.println(val);
        System.out.println(val.getClass());
        System.out.println(val.getClass().getName());
    }

    public static void main(String[] args) {
        Person p = new Person();

        Subject subject0 = new Subject();
        subject0.add(3);
        subject0.add("A");
        subject0.add(p);

        Subject<Integer> subject1 = new Subject<>();
        subject1.add(3);

        Subject<String> subject2 = new Subject<>();
        subject2.add("true");

        Subject<Person> subject3 = new Subject<>();
        subject3.add(p);
    }
}

class Person {
    String name;
}