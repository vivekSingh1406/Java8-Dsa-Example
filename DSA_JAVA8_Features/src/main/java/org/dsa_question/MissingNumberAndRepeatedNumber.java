package org.dsa_question;

public class MissingNumberAndRepeatedNumber {

    public static int[] findMissingAndRepeatedValues(int[][] grid) {
        int [] ans = new int[2];
        int n = grid.length;
        int [] freq = new int[n*n+1];
        for(int i = 0 ; i<grid.length ; i++){
            for(int j = 0; j<grid[0].length ; j++){
                freq[grid[i][j]]++;
            }
        }

        for(int i = 1; i<freq.length ; i++){
            if(freq[i]==2) ans[0] = i;
            if(freq[i]==0) ans[1] = i;
        }

        return ans;
    }
    public static void main(String[] args) {

        int[][] arr = {{9,1,7}
                ,{8,9,2}
                ,{3,4,6}};
        int[] ans = findMissingAndRepeatedValues(arr);
        for (int an : ans) {
            System.out.print(an+" ");
        }
    }
}
