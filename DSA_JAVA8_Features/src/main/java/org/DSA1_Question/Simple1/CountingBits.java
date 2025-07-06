package org.DSA1_Question.Simple1;

public class CountingBits {

    public static int[] countBits(int n) {
        int[] arr =new int[n+1];
        for(int i=0;i<arr.length;i++){
            int c=0,num=i;

            while(num>0){
                if((num&1)!=0) c++;
                num=num>>1;
            }
            arr[i]=c;
        }
        return arr;
    }
    public static void main(String[] args) {

        int[] ans = countBits(5);
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}
