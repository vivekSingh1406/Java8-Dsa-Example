package org.DSA_Question.TreesQuestion;

public class MaximumDepthBinaryTree {

    public static int height(Node root){

        if(root==null) return -1;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        //     12
        //    /  \
        //   8   18
        //  / \
        // 5   11
        Node root = new Node(12);
        root.left = new Node(8);
        root.right = new Node(18);
        root.left.left = new Node(5);
        root.left.right = new Node(11);
        root.left.left.left = new Node(3);

        System.out.println(height(root));
    }
}
