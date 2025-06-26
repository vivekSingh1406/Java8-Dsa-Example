package org.DSA_Question.MathProblem;

public class NumberStepsReduceNumberZero {

    public static int numberOfSteps(int num) {
        return steps(num);
    }

    public static int steps(int num){
        return helper(num, 0);
    }

    public static int helper(int num, int count){
        if(num == 0) return count;
        if(num % 2 == 0) return helper(num / 2, ++count);
        else return helper(num - 1, ++count);
    }

    public static void main(String[] args) {

        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(123));
    }
}
