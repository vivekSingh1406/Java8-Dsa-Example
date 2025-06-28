package org.ArrayString;

public class SecondLargest {

    public static int secondHighest(int []num){

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int val : num){
            if(val > first){
                second = first;
                first = val;
            } else if (val > second && val != first) {
                second = val;
            }
        }
        return second;
    }

    public static int secondLowest(int []num){

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int val : num){
            if(val < first){
                second = first;
                first = val;
            } else if (val < second && val != first) {
                second = val;
            }
        }
        return second;
    }

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 4, 5, 1, 1};

        System.out.println(secondHighest(numbers));
        System.out.println(secondLowest(numbers));
    }
}
