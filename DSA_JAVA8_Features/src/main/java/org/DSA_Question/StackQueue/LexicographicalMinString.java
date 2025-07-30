package org.DSA_Question.StackQueue;

import java.util.Stack;

public class LexicographicalMinString {

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "cb*a*ba*";
        System.out.println(removeStars(input));
        String input1 = "aaba*";
        System.out.println(removeStars(input1));
    }
}
