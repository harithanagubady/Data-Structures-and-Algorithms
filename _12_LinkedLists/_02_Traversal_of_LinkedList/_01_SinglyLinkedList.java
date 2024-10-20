package _02_Traversal_of_LinkedList;

public class _01_SinglyLinkedList<T> {

    static class Node<T> {
        T data;
        _01_SinglyLinkedList.Node<T> next;

        public Node (T data) {
            this.data = data;
        }
    }

    _01_SinglyLinkedList.Node<T> head;
    int size;

    public _01_SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    void traverse (_01_SinglyLinkedList.Node<T> head) {
        _01_SinglyLinkedList.Node<T> curr = head;
        while (curr != null) {
            System.out.print(" | " + curr.data + " | -> ");
            curr = curr.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        _01_SinglyLinkedList<Integer> l = new _01_SinglyLinkedList<>();
        l.head = new _01_SinglyLinkedList.Node<>(5);
        l.traverse(l.head);
    }
}
