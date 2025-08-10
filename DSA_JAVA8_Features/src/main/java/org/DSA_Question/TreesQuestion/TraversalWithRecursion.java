package org.DSA_Question.TreesQuestion;

import java.util.ArrayList;

public class TraversalWithRecursion {


    public static void inorderTraversal(Node root, ArrayList<Integer> list){

        if(root==null) return;

        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    public static void preorderTraversal(Node root, ArrayList<Integer> list){

        if(root==null) return;

        list.add(root.data);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    public static void postorderTraversal(Node root, ArrayList<Integer> list){

        if(root==null) return;

        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.data);
    }

    public static void print(ArrayList<Integer> list){

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //         12
        //        /  \
        //       8   18
        //      / \
        //     5  11
        //    / \
        //   3   7

        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(7);

        ArrayList<Integer> ans = new ArrayList<>();
        inorderTraversal(root, ans);
        print(ans);

        ArrayList<Integer> ans1 = new ArrayList<>();
        preorderTraversal(root, ans1);
        print(ans1);


        ArrayList<Integer> ans2 = new ArrayList<>();
        postorderTraversal(root, ans2);
        print(ans2);
    }
}
