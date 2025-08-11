package org.DSA_Question.LinklistQuestion;

public class SingleList {

    Node head;
    int count = 0;

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
        count++;
    }

    public void addElementFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        count++;
    }

    public void addElementLast(int data){

        Node newNode  = new Node(data);
        Node temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public int findMiddleNumber() {
        if (head == null) {
            return -1;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    public void reversLinedList(){

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        head = prev;
    }

    public void deleteNode(int data){
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        current.next = current.next.next;
    }

    public int findMinElement(){

        Node temp = head;
        int minElement = Integer.MAX_VALUE;
        while(temp!=null){
            minElement = Math.min(minElement, temp.data);
            temp = temp.next;
        }
        return minElement;
    }

    public int findMaxElement(){

        Node temp = head;
        int maxElement = Integer.MIN_VALUE;
        while(temp!=null){
            maxElement = Math.max(maxElement, temp.data);
            temp = temp.next;
        }
        return maxElement;
    }

    public void sortList() {
        if (head == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }


    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SingleList ls = new SingleList();

        int[] arr = {10, 20, 30, 40, 500, 60, 70, 80, 90, 100};
        for (int j : arr) {
            ls.add(j);
        }

//        System.out.println("Original List:");
//        ls.print();

//        System.out.println("Middle Element: " + ls.findMiddleNumber());

//        ls.addElementFirst(101);
//        System.out.println("After adding 101 at beginning:");
//        ls.print();

//        ls.addElementLast(110);
//        System.out.println("After adding 110 at beginning:");
//        ls.print();

//        ls.reversLinedList();
//        ls.print();

//        ls.deleteNode(101);
//        ls.print();


//        System.out.println(ls.findMinElement());
//        System.out.println(ls.findMaxElement());

        ls.sortList();
        ls.print();
    }
}
