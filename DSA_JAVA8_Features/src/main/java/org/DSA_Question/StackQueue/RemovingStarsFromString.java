package org.DSA_Question.StackQueue;

import javax.print.event.PrintEvent;
import java.util.Stack;

public class RemovingStarsFromString {


    public static String removeStars(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') st.pop();
            else st.push(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : st) {
            sb.append(c);
        }

        return sb.toString();
    }
    public static void main(String[] args) {

        System.out.println(removeStars("vivek****singh***bais**"));
    }
}
