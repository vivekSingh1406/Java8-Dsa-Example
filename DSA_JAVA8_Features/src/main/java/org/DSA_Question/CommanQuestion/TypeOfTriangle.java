package org.DSA_Question.CommanQuestion;


public class TypeOfTriangle {

    public static String triangleType(int[] numb) {
        if(numb[0]+numb[1]<=numb[2] || numb[1]+numb[2]<=numb[0] || numb[0]+numb[2]<=numb[1]){
            return "none";
        }
        if(numb[0]==numb[1] && numb[1]==numb[2]){
            return "equilateral";
        }
        if(numb[0]!=numb[1] && numb[0]!=numb[2] && numb[1]!=numb[2]){
            return "scalene";
        }
        return "isosceles";
    }

    public static void main(String[] args) {

        int[] arr = {3,3,3};
        int[] arr1 = {3,4,5};

        System.out.println(triangleType(arr));
        System.out.println(triangleType(arr1));
    }
}
