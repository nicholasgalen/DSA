package LinkedLists.Leetcode;

// Leetcode 24. Swap Nodes in Pairs
public class SwapPairs {

    private Node head;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public SwapPairs(int value) {
        Node newNode = new Node(value);
        head = newNode;
    }

    public Node getHead() {
        return head;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void makeEmpty() {
        head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public Node swapPairs(Node head) {
        if (head == null || head.next == null) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node first = head;
        Node second = head.next;

        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            prev.next = second;

            prev = first;
            first = first.next;
            if (first != null) second = first.next;
        }

        return dummy.next;
    }


}

