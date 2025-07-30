package org.DSA_Question.Sorting$Searching;

public class SelectionSort {

    /**
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static void sortArr(int[] arr){

        for(int i=0;i<arr.length-1;i++){

            int min_index = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]< arr[min_index]){
                    min_index = j;
                }
            }

            int temp = arr[i];
            arr[i]= arr[min_index];
            arr[min_index]=temp;
        }

    }
    public static void main(String[] args) {

        int[] arr = {12, 14, 10, 9, 5, 56, 89, 0, 19, 99};

        sortArr(arr);
        for (int i : arr) System.out.println(i);
    }
}
