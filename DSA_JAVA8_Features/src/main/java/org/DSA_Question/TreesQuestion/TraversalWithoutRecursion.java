package org.DSA_Question.TreesQuestion;

import java.util.Stack;


public class TraversalWithoutRecursion {

    public static void inorderTraversal(Node root){

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }


    public static void preorderTraversal(Node root){

        if(root==null) return ;
        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()){

            Node top = stack.pop();

            System.out.print(top.data +" ");

            if(top.right!=null) stack.add(top.right);
            if(top.left!=null) stack.add(top.left);
        }
    }


    public static void postorderTraversal(Node root){

        if (root == null) return;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node curr = stack1.pop();
            stack2.push(curr);

            if (curr.left != null) stack1.push(curr.left);
            if (curr.right != null) stack1.push(curr.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
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

        inorderTraversal(root);
        System.out.println();
        preorderTraversal(root);
        System.out.println();
        postorderTraversal(root);

    }
}
