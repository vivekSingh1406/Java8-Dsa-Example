package org.DSA_Question.StackQueue;

import java.util.Stack;

public class ClearDigit {

    public static String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    // same problem need to solve using stack
    public static String clearDigit(String s){

        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && Character.isDigit(ch)) st.pop();
            else st.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        System.out.println(clearDigit("abc"));
        System.out.println(clearDigit("acd34"));
    }
}
