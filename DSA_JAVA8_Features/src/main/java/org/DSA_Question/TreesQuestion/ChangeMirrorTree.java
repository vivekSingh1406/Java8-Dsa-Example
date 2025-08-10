package org.DSA_Question.TreesQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class ChangeMirrorTree {

    public static void mirror(Node root){

        if(root==null) return;
        mirror(root.left);
        mirror(root.right);

        //swap the left and right subtree
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void levelOrder(Node root) {
        if (root == null) return;


        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();

                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        //        1
        //       / \
        //      2   3
        //     / \
        //    4   5
        Node r2 = new Node(1);
        r2.left = new Node(2);
        r2.right = new Node(3);
        r2.left.left = new Node(4);
        r2.left.right = new Node(5);

        mirror(r2);
        levelOrder(r2);
    }
}
