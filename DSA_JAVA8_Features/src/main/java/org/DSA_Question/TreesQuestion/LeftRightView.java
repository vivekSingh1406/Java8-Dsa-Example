package org.DSA_Question.TreesQuestion;

import java.util.ArrayList;
import java.util.List;

public class  LeftRightView {


    public static void rightView(Node curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }


    public static void leftView(Node curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.data);
        }

        leftView(curr.left, result, currDepth + 1);
        leftView(curr.right, result, currDepth + 1);
    }


    public static void main(String[] args) {

        //         20
        //       /   \
        //      8     22
        //    /  \     \
        //   4   12    11
        //      /  \
        //     10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(11);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        ArrayList<Integer> leftList = new ArrayList<>();
        leftView(root, leftList, 0);
        leftList.forEach(System.out::println);

        ArrayList<Integer> rightList = new ArrayList<>();
        rightView(root, rightList, 0);
        rightList.forEach(System.out::println);
    }
}
