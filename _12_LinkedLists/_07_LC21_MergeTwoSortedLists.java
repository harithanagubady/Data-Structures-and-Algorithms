/*
https://leetcode.com/problems/merge-two-sorted-lists/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _07_LC21_MergeTwoSortedLists {

    //O(m + n), O(m + n)
    public static Node mergeTwoListsRecursive(Node list1, Node list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node result = null;
        if (list1.data <= list2.data) {
            result = list1;
            result.next = mergeTwoListsRecursive (list1.next, list2);
        } else {
            result = list2;
            result.next = mergeTwoListsRecursive (list1, list2.next);
        }

        return result;
    }

    //O(m + n)  O(1)
    public static Node mergeTwoListsIterative(Node list1, Node list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        Node head = null;
        Node tail = null;

        if (list1.data <= list2.data) {
            head = tail = list1;
            list1 = list1.next;
        } else {
            head = tail = list2;
            list2 = list2.next;
        }

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }
        tail.next = list1 != null ? list1 : list2;
        return head;
    }

    public static void main(String[] args) {
        _01_SinglyLinkedList ll1 = new _01_SinglyLinkedList();
        ll1.insertAtEnd(1);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(4);
        System.out.println("Input list 1:");
        System.out.println(_01_SinglyLinkedList.toString(ll1.getHead()));

        _01_SinglyLinkedList ll2 = new _01_SinglyLinkedList();
        ll2.insertAtEnd(2);
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(7);
        System.out.println("Input list 2:");
        System.out.println(_01_SinglyLinkedList.toString(ll2.getHead()));

        Node resHead = mergeTwoListsIterative(ll1.getHead(), ll2.getHead());
        System.out.println("Output list:");
        System.out.println(_01_SinglyLinkedList.toString(resHead));
    }
}
