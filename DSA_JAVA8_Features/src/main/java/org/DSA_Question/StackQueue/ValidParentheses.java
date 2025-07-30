package org.DSA_Question.StackQueue;

import java.util.Stack;

public class ValidParentheses {


    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        if(s.length()%2!=0) return false;  // base condition
        for (char c : s.toCharArray()) {   // other
            if (c == '(') {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            } else if (st.isEmpty() || st.pop() != c) {
                return false;
            }
        }

        return st.isEmpty();
    }

    public static boolean valid(String s){

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') sb.append(')');
            else if (c == '[') sb.append(']');
            else if (c == '{') sb.append('}');
            else {
                if (sb.isEmpty() || sb.charAt(sb.length() - 1) != c) return false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        return sb.isEmpty();
    }
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("({[)]}"));
    }
}
