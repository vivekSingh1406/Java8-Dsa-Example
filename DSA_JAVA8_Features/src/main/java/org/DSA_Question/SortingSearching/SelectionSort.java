package org.DSA_Question.SortingSearching;

public class SelectionSort {


/**
 * Key Features:
 * -------------
 * - In-place sorting (does not use extra space)
 * - Simple and easy to implement
 * - Not stable by default (equal elements may be reordered)
 * - Performs fewer swaps than Bubble Sort (at most n - 1 swaps)
 *
 * Time Complexity: O(n²) - still compares all element
 * Space Complexity: O(1) - constant space used for swapping
 * Use Cases:
 *
 * - Suitable for small arrays
 * - Not efficient for large datasets
 * - Good for teaching and understanding sorting mechanisms
 *
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
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
