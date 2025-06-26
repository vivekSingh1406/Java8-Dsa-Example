package org.DSA_Question.CommanQuestion;

public class DivideStringIntoGroupsOfSizeK {

    /**
     *
     * @param s     The input string to be divided.
     * @param k     The length of each substring group.
     * @param fill  The character used to fill the last group if it's shorter than `k`.
     * @return      An array of strings, where each string is of length `k`.
     *              The last group is padded with `fill` if needed.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static String[] divideString(String s, int k, char fill) {

        StringBuilder sb = new StringBuilder(s);

        while (sb.length() % k != 0) sb.append(fill);

        String[] res = new String[sb.length() / k];
        for (int i = 0; i < sb.length() / k; i++) {
            res[i] = sb.substring(i * k, (i + 1) * k);
        }
        return res;
    }

    public static void main(String[] args) {

        String st = "abcdefghi";
        int k = 3;
        char fill = 'x';


        String st1 = "abcdefghij";
        int k1 = 3;
        char fill1 = 'x';

        String[] ans = divideString(st, k, fill);
        for (String an : ans) System.out.print(an+" ");

        System.out.println();
        String[] ans1 = divideString(st1, k1, fill1);
        for (String an : ans1) System.out.print(an+" ");

    }
}
