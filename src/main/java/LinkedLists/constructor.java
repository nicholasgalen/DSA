package LinkedLists;

class constructor {

    private static Node head;
    private static Node tail;
    private static int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }


    constructor(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }


    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public static void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public static void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public static void main(String[] args) {
        printAll();
    }
}



