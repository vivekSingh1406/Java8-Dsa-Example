package org.DSA_Question.MathProblem;

import java.util.LinkedList;
import java.util.List;

public class AddArrayFormInteger {

    public static List<Integer> addToArrayForm(int[] num, int k) {

        LinkedList<Integer> result = new LinkedList<>();
        int i = num.length - 1;

        while (i >= 0 || k > 0) {
            if (i >= 0) {
                k += num[i];
                i--;
            }
            result.addFirst(k % 10);
            k /= 10;
        }

        return result;
    }

    public static void main(String[] args) {

        int []num = {1,2,0,0};
        int k = 34;
        List<Integer> list = addToArrayForm(num, k);
        list.forEach(i -> System.out.print(i+ " "));
    }
}
