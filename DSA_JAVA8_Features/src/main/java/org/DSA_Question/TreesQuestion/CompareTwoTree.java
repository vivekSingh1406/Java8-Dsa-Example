package org.DSA_Question.TreesQuestion;

public class CompareTwoTree {


    public static boolean isIdentical(Node n1, Node n2) {

        if(n1==null && n2==null) return true;
        if(n1==null || n2==null) return false;


        return (n1.data == n2.data) &&
                isIdentical(n1.left, n2.left) &&
                isIdentical(n1.right, n2.right);
    }


    public static void main(String[] args) {

        //        1
        //       / \
        //      2   3
        //     /
        //    4
        Node r1 = new Node(1);
        r1.left = new Node(2);
        r1.right = new Node(3);
        r1.left.left = new Node(4);

        // Representation of input binary tree 2
        //        1
        //       / \
        //      2   3
        //     /
        //    4
        Node r2 = new Node(1);
        r2.left = new Node(2);
        r2.right = new Node(3);
        r2.left.left = new Node(4);
        r2.left.right = new Node(5);

        if (isIdentical(r1, r2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
