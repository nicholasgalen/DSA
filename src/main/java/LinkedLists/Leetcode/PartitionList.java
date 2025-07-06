package LinkedLists.Leetcode;

// Leetcode 86. Partitioning List
public class PartitionList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public PartitionList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    public void partitionList(int x){
        Node node = head;
        Node d1 = new Node(0); // node numeros menores
        Node d2 = new Node(0); // node numeros maiores
        Node prev1 = d1;
        Node prev2 = d2;

        while(node != null){
            if (node.value < x){
                prev1.next = node;
                prev1 = node;
            }
            else{
                prev2.next = node;
                prev2 = node;
            }
            node = node.next;
        }

        prev2.next = null;
        prev1.next = d2.next;

        head = d1.next;
    }

}


