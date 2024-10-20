/*
https://leetcode.com/problems/remove-duplicates-from-an-unsorted-linked-list/description/
 */
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

import java.util.HashMap;

public class _06_LC1836_RemoveDuplicatesFromUnsortedList {

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
        Node resHead = deleteDuplicatesUnsorted(ll.getHead());

        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(resHead));
    }

    //O(n + m) //O(n + m)
    public static Node deleteDuplicatesUnsorted(Node head) {
        HashMap<Integer, Integer> nodeCount = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            int count = nodeCount.getOrDefault(curr.data, 0);
            count += 1;
            nodeCount.put(curr.data, count);
            curr = curr.next;
        }

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        curr = head;

        while (curr != null) {
            if (nodeCount.get(curr.data) > 1) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return head = dummy.next;
    }
}
