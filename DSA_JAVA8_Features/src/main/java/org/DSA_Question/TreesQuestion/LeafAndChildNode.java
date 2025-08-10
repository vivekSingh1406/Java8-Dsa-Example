package org.DSA_Question.TreesQuestion;

public class LeafAndChildNode {

    public static void findLeafNodes(Node root) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        findLeafNodes(root.left);
        findLeafNodes(root.right);
    }

    public static void findChildNodes(Node root) {
        if (root == null) return;

        if (root.left != null || root.right != null) {
            System.out.print(root.data + " ");
        }
        findChildNodes(root.left);
        findChildNodes(root.right);
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

        System.out.print("Leaf Nodes: ");
        findLeafNodes(root);
        System.out.println();

        System.out.print("Child Nodes: ");
        findChildNodes(root);
    }
}
