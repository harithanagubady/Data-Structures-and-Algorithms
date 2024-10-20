/*

https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

import java.util.HashSet;

public class _05_RemoveDuplicatesFromUnsortedList {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(4);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(2);
        ll.insertAtEnd(2);
        System.out.println("Input list:");
        System.out.println(_01_SinglyLinkedList.toString(ll.getHead()));
        //Node resHead = removeDuplicatesNaiveApproach(ll.getHead());
        Node resHead = removeDuplicatesUsingHashSet(ll.getHead());

        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(resHead));
    }


    //O(n^2)
    public static Node removeDuplicatesNaiveApproach (Node head) {

        Node outerNode = head;
        while (outerNode != null) {
            Node innerNode = outerNode;
            while (innerNode.next != null) {
                if (outerNode.data == innerNode.next.data) {
                    innerNode.next = innerNode.next.next;
                } else {
                    innerNode = innerNode.next;
                }
            }
            outerNode = outerNode.next;
        }

        return head;
    }

    //O(n) and O(n)
    public static Node removeDuplicatesUsingHashSet (Node head) {

        HashSet<Integer> set = new HashSet<>();
        Node curr = head, prev = null;
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }

        return head;
    }
}
