package org.DSA_Question.TreesQuestion;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTree {


    public static ArrayList<Integer> zigZagTraversal(Node root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(root);

        while (!s1.empty() || !s2.empty()) {

            // Print nodes of current level from s1
            // and push nodes of next level to s2
            while (!s1.empty()) {
                Node curr = s1.pop();
                res.add(curr.data);

                if (curr.left != null) s2.push(curr.left);
                if (curr.right != null) s2.push(curr.right);
            }

            // Print nodes of current level from s2
            // and push nodes of next level to s1
            while (!s2.empty()) {
                Node curr = s2.pop();
                res.add(curr.data);

                if (curr.right != null) s1.push(curr.right);
                if (curr.left != null) s1.push(curr.left);
            }
        }
        return res;
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


        ArrayList<Integer> res = zigZagTraversal(root);
        for (int val : res) System.out.print(val + " ");
        System.out.println();
    }
}
