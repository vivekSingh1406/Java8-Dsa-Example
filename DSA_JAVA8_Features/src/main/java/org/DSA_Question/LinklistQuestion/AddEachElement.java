package org.DSA_Question.LinklistQuestion;

public class AddEachElement {

    Node head;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Recursive function to add all elements
    public int addAllElement(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + addAllElement(node.next);
    }

    public static void main(String[] args) {

        AddEachElement ad = new AddEachElement();

        int[] arr = {10, 20, 30, 43, 50, 60, 70, 80, 90, 101};
        for (int j : arr) {
            ad.add(j);
        }

        System.out.println("Sum of all elements: " + ad.addAllElement(ad.head));
    }
}