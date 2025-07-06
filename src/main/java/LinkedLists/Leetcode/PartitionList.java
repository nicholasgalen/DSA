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

        // Os dummys guardam o inicio da lista
        Node d1 = new Node(0); // node numeros menores
        Node d2 = new Node(0); // node numeros maiores

        // Os prevs guardam o final da lista
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

        // Como o ultimo numero da lista dos numeros maiores (d2) ainda aponta para o proximo numero da lista possivelmente,
        // temos que declarar ele como null para nao entrar em um ciclo infinito
        prev2.next = null;
        // Usamos o dummy para guardar a ordem da lista e nao precisar iterar novamente para pegar o primeiro valor dela
        prev1.next = d2.next;

        head = d1.next;
    }

}


