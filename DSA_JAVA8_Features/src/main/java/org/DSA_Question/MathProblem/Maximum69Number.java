package org.DSA_Question.MathProblem;

public class Maximum69Number {

    public static int maximum69Number (int num) {
        return Integer.parseInt(("" + num).replaceFirst("6", "9"));
    }

    public static void main(String[] args) {

        int num = 9669;
        int num1 = 9996;

        System.out.println(maximum69Number(num));
        System.out.println(maximum69Number((num1)));
    }
}
