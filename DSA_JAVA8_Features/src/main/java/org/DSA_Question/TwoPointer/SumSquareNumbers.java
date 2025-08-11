package org.DSA_Question.TwoPointer;

public class SumSquareNumbers {

    public static boolean squareSum(int c) {

        int start = 0;
        int end = (int) Math.sqrt(c);

        while(start<=end){
            int sum = start*start + end*end;
            if(sum==c) return true;
            else if (sum<c) start++;
            else end--;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println(squareSum(5));
        System.out.println(squareSum(3));
        System.out.println(squareSum(9));

    }
}
