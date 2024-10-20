package _01_Representation_of_LinkedList;

public class _01_SinglyLinkedList<T> {
    static class Node<T> {
        T data;
        Node<T> next;

        public Node (T data) {
            this.data = data;
        }
    }

    Node<T> head;
    int size;

    public _01_SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
}
