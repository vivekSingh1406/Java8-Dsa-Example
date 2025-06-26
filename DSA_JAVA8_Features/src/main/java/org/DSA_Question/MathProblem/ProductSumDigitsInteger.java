package org.DSA_Question.MathProblem;

public class ProductSumDigitsInteger {

    public static int subtractProductAndSum(int n) {

        int sum =0;
        int mul = 1;
        while(n!=0){
            int r = n%10;
            sum = sum +r ;
            mul = mul * r;
            n /=10;
        }
        return mul-sum;
    }
    public static void main(String[] args) {

        int num = 234;
        int num1 = 4421;

        System.out.println(subtractProductAndSum(num));
        System.out.println(subtractProductAndSum(num1));
    }
}
