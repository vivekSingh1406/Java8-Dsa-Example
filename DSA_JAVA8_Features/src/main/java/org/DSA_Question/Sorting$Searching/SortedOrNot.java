package org.DSA_Question.Sorting$Searching;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedOrNot {

    /**
     * check array is sorted or not
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static boolean checkSort(int[] arr){

        for(int i=1;i<arr.length;i++){
            if(arr[i-1] > arr[i]) return false;
        }
        return true;
    }

    /**
     * check there is duplicate data or not in a array
     * Time Complexity: O(n log n) + O(n) = O(n log n)
     * Space Complexity: O(1)
     */
    public static boolean checkDuplicate(int[] arr){

        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]) return false;
        }
        return true;

    }


    /**
     * remove duplicate data in a array
     * Time Complexity: O(n) + O(n) = O(n)
     * Space Complexity: O(1)
     */
    public static void removeDuplicate(int[] arr){

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1;i<arr.length;i++){
            if(arr[i] != arr[i-1]) list.add(arr[i-1]);
        }
        list.add(arr[arr.length - 1]);

        for (Integer integer : list) {
            System.out.print(integer +" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        int[] arr = {1,15,95,36,8,55,2};
        int[] arr1 = {1,2,3,4,5,6,6,7,7};

//        System.out.println(checkSort(arr));
//        System.out.println(checkSort(arr1));


//        System.out.println(checkDuplicate(arr));
//        System.out.println(checkDuplicate(arr1));

        removeDuplicate(arr);
        removeDuplicate(arr1);

    }
}
