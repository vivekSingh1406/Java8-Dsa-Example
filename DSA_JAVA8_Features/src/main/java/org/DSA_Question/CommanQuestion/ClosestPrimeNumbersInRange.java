package org.DSA_Question.CommanQuestion;

public class ClosestPrimeNumbersInRange {

    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int[] closestPrimes(int left, int right) {
        int[] answer = {-1, -1};
        int prevPrime = -1;
        int diff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1) {
                    int currentDiff = i - prevPrime;
                    if (currentDiff < diff) {
                        diff = currentDiff;
                        answer[0] = prevPrime;
                        answer[1] = i;
                    }
                    if (diff == 1 || diff == 2) return answer;
                }
                prevPrime = i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

       int  left = 10, right = 19 ;
       int[] ans = closestPrimes(left, right);

        for (int an : ans) {
            System.out.println(an);
        }
    }
}
