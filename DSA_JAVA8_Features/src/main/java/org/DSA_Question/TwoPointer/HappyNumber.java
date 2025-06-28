package org.DSA_Question.TwoPointer;

public class HappyNumber {

    /**
     * Determines whether the given number is a happy number.
     *
     * @param n The number to be checked.
     * @return {@code true} if the number is happy; {@code false} otherwise.
     *
     * Time Complexity: O(log n) per step × number of steps.
     * Space Complexity: O(1)
     */
    public static boolean isHappy(int n) {

        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public static int square(int num) {

        int ans = 0;

        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(isHappy(19));
        System.out.println(isHappy(1));
    }
}
