package LinkedLists.Leetcode;

// Leetcode 92. Reverse Linked List II
public class ReverseBetween {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public ReverseBetween(int value) {
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
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append(current.value).append(" -> ");
            current = current.next;
        }
        // Remove the last " -> " and print the result
        if (output.length() > 0) {
            output.setLength(output.length() - 4);
            System.out.println(output.toString());
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
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

    public void reverseBetween(int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node previous = dummy;

        for (int i = 0; i < m; i++) {
            if (previous.next == null) return;
            previous = previous.next;
        }

        if (previous.next == null || previous.next.next == null) return;

        Node current = previous.next;
        Node move = current.next;

        for (int i = 0; i < n - m; i++) {
            current.next = move.next;
            move.next = previous.next;
            previous.next = move;
            move = current.next;
        }

        head = dummy.next;
    }

}