package org.DSA1_Question.Math;

public class DivideTwoInteger {

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        return dividend/divisor;
    }

    public static void main(String[] args) {

        System.out.println(divide(10, 3));
        System.out.println(divide(-2147483648, -1));
    }
}
