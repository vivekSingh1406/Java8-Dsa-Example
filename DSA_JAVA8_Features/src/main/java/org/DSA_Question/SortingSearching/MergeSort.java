package org.DSA_Question.SortingSearching;

public class MergeSort {

    public static void mergeSort(int []arr, int []left, int []right){

        int i=0,j=0,k=0;

        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }else{
                arr[k++] = right[j++];
            }
        }

        while(i<left.length){
            arr[k++] = left[i++];
        }

        while(j<right.length){
            arr[k++] = right[j++];
        }
    }

    public static void sort(int[] arr){
        if(arr.length <= 1) return;

        int[] left = new int[arr.length / 2];
        int[] right = new int[arr.length - left.length];

        for(int i = 0; i < left.length; i++) {
            left[i] = arr[i];
        }

        for(int i = 0; i < right.length; i++) {
            right[i] = arr[i + left.length];
        }

        sort(left);
        sort(right);
        mergeSort(arr, left, right);
    }

    public static void main(String[] args) {
        int []arr = {12,14,10,9,5,56,89,0,19,99};

        sort(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
