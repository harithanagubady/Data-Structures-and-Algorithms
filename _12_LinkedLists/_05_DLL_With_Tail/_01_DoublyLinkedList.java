package _05_DLL_With_Tail;

class Node {
    int val;
    Node prev;
    Node next;


    Node() {

    }

    Node(int d) {
        val = d;
        prev = next = null;
    }
}

// Define a _01_DoublyLinkedList class to manage the doubly linked list operations.
public class _01_DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public boolean isEmpty() {
        return head == null;
    }

    void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;

        if (isEmpty()) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    void insertAtTail(int val) {
        if (isEmpty()) {
            insertAtHead(val);
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    @Override
    public String toString() {
        Node curr = head;
        StringBuilder sb = new StringBuilder();
        while (curr != null) {
            sb.append(curr.val).append(", ");
            curr = curr.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _01_DoublyLinkedList dll = new _01_DoublyLinkedList();
        dll.insertAtHead(1);
        dll.insertAtHead(2);
        dll.insertAtHead(3);

        dll.insertAtTail(4);
        System.out.println("DLL: " + dll);

    }
}
