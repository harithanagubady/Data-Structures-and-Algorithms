package _04_Basic_Operations_on_DLL;

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;

// Define a _01_DoublyLinkedList class to manage the doubly linked list operations.
public class _01_DoublyLinkedList {

    public static class Node {
        public int val;
        public Node prev;
        public Node next;


        public Node() {

        }

        public Node(int d) {
            val = d;
            prev = next = null;
        }
    }

    public Node head;
    public int size;

    public void insertAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        size++;
    }

    public void insertAtEnd(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }

        Node prev = head;
        while (prev.next != null) {
            prev = prev.next;
        }

        prev.next = new Node(val);
        size++;
    }

    public void insertAfter(int prevVal, int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null && curr.val != prevVal) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("The given value does not exist");
            return;
        }
        Node newNode = new Node(val);  // Create a new Node with the given value.
        newNode.next = curr.next;
        curr.next = newNode;
        newNode.prev = curr;
        if (newNode.next != null)
            newNode.next.prev = newNode;
        size++;
    }

    void delete(int val) {

        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node curr = head;

        while (curr != null && curr.val != val) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("val " + val + " does not exist");
            return;
        }

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        } else {
            head = curr.next;
        }

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }
        size--;
    }

    boolean search(int key) {
        Node curr = head;
        while (curr != null && curr.val != key) {
            curr = curr.next;
        }
        return curr != null;
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

        System.out.println("DLL: " + dll);
        System.out.println("Search 2: " + dll.search(2));  // true
        dll.delete(2);
        System.out.println("Search 2: " + dll.search(2));  // false
    }
}
