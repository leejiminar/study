package org.example;

import java.util.Arrays;

public class Main3 {
    public static int[] copyOf(int[] original, int newLength) {
        int[] copy = new int[newLength];
        System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
        return copy;
    }

    public static void main(String[] args) {
        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;
        System.out.println(Arrays.toString(a));

        int[] b = copyOf(a, 5);
        System.out.println(Arrays.toString(b));
    }
}