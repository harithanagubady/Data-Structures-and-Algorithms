package _03_Basic_Operations_on_SLL;

public class _01_SinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node () {

        }
        public Node(int data) {
            this.data = data;
        }
    }

    public Node getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    private Node head;
    private int size;

    public Node getTail() {
        return tail;
    }

    private Node tail;

    public _01_SinglyLinkedList() {
        this.head = null;
        this.size = 0;
        this.tail = null;
    }

    public _01_SinglyLinkedList(Node node) {
        this.head = node;
        this.size = 1;
        this.tail = node;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAtHead(int val) {

        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertAfter(int prev, int val) {

        Node curr = head;
        while (curr != null && curr.data != prev) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Given prev value does not exist");
            return;
        } else {
            Node newNode = new Node(val);
            newNode.next = curr.next;
            if (newNode.next == null) tail = newNode;
            curr.next = newNode;
        }

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

        Node newNode = new Node(val);
        prev.next = newNode;
        this.tail = newNode;
        size++;
    }

    public void delete(int val) {

        Node curr = head;
        Node prev = new Node();
        while (curr != null && curr.data != val) {
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Value not found");
            return;
        }
        prev.next = curr.next;
        if (curr == head) {
            head = curr.next;
        }
        if (prev.next == null) {
            tail = prev;
        }
        size--;
    }

    public void deleteAtHead() {

        Node curr = head;

        if (curr == null) {
            System.out.println("Empty list");
            return;
        }

        int val = curr.data;
        head = curr.next;
        System.out.println(val + " removed");
        size--;
    }

    public void deleteAtEnd() {

        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node prev = new Node();
        Node curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
        }

        int val = curr.data;
        if (curr == head) {
            head = null;
        }

        System.out.println(val + " removed");
        prev.next = curr.next;
        size--;
    }

    //default
    public boolean search (int val) {
        return searchIterative(val);
    }

    public boolean search (int val, boolean isRecursive) {
        if (isRecursive) {
            return searchRecursive(head, val);
        } else {
            return searchIterative(val);
        }
    }

    private boolean searchIterative(int val) {

        if (head == null) {
            System.out.println("Empty list");
            return false;
        }

        Node curr = head;
        while (curr != null && curr.data != val) {
            curr = curr.next;
        }

        return curr != null;
    }


    private boolean searchRecursive(Node curr, int val) {

        if (curr == null) {
            System.out.println("Empty list");
            return false;
        }

        if (curr.data == val) {
            return true;
        }

        return searchRecursive(curr.next, val);
    }


    public static StringBuilder toString(_01_SinglyLinkedList.Node head) {
        StringBuilder s = new StringBuilder();
        Node curr = head;
        //int count = 0;
        while (curr != null) {
            s.append("| ").append(curr.data).append(" | -> ");
            curr = curr.next;
            //System.out.println(count++);
        }
        s.append("NULL");
        return s;
    }

    public static void main(String[] args) {
        System.out.println("Create new LinkedList with one node");
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList(new Node(2));
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        int val = 1;
        System.out.println("Insert " + val + " at the head");
        ll.insertAtHead(1);
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        int prev = 5;
        val = 3;
        System.out.println("Insert " + val + " after " + prev);
        ll.insertAfter(prev, val);
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        prev = 2;
        System.out.println("Insert " + val + " after " + prev);
        ll.insertAfter(prev, val);
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        val = 4;
        System.out.println("Insert " + val + " at the end");
        ll.insertAtEnd(val);
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        val = 3;
        System.out.println("Delete " + val);
        ll.delete(val);
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        System.out.println("Delete at the head");
        ll.deleteAtHead();
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        System.out.println("Delete at the end");
        ll.deleteAtEnd();
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        System.out.println("Delete at the end");
        ll.deleteAtEnd();
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        System.out.println("Delete at the end");
        ll.deleteAtEnd();
        System.out.println(_01_SinglyLinkedList.toString(ll.head));
        System.out.println();

        val = 2;
        System.out.println("Default Search (iterative) " + val);
        System.out.println(ll.search(val));
        System.out.println();

        System.out.println("Search Recursive " + val);
        System.out.println(ll.search(val, true));
        System.out.println();
    }
}
