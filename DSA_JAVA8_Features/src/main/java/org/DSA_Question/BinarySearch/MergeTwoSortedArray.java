package org.DSA_Question.BinarySearch;

public class MergeTwoSortedArray {

    public static void mergeArrays(int[] a, int[] b){

        for (int i = b.length - 1; i >= 0; i--) {

            if (a[a.length - 1] > b[i]) {
                int last = a[a.length - 1];
                int j = a.length - 2;
                while (j >= 0 && a[j] > b[i]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = b[i];
                b[i] = last;
            }
        }
    }
    public static void main(String[] args) {

        int[] a = {1, 5, 9, 10, 15, 20};
        int[] b = {2, 3, 8, 13};
        mergeArrays(a, b);

        for (int ele : a)
            System.out.print(ele + " ");
        System.out.println();
        for (int ele : b)
            System.out.print(ele + " ");
    }
}
