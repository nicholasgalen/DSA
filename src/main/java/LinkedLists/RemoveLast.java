package LinkedLists;

public class RemoveLast {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public RemoveLast(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
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

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast(){
        // checa se a LinkedList está vazia
        if (length == 0){
            return null;
        }

        // criamos temp e pre. o Pre vai setar o penultimo numero para colocar o tail lá (já que removemos o ultimo o
        // tail tem que voltar) e o temp vai retornar o numero que removemos (que é o ultimo da lista)
        var temp = head;
        var pre = head;

        // enquanto temp.next (o proximo node) não for vazio ele executa, isso nessa ordem faz com que temp SEMPRE
        // chegue no ultimo numero e pre SEMPRE aponte para o penultimo
        while (temp.next != null){
            pre = temp;
            temp = temp.next;
        }

        // setamos o tail para o penultimo (que agora é o ultimo numero da linked list apos removermos o Last)
        tail = pre;
        // o proximo node do tail é sempre nulo, pq o tail é sempre o final
        tail.next = null;
        length--;
        if (length == 0){
            head = null;
            tail = null;
        }

        return temp;
    }

}


