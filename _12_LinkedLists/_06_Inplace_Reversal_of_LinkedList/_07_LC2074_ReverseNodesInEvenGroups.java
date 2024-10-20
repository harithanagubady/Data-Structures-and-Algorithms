package _06_Inplace_Reversal_of_LinkedList;

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

/*
https://leetcode.com/problems/reverse-nodes-in-even-length-groups/
 */
public class _07_LC2074_ReverseNodesInEvenGroups {

    public static Node reverseEvenLengthGroups(Node head) {
        Node curr = head;
        int n = 0;
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        Node dummy = new Node();
        dummy.next = head;
        int size = 1;
        Node prev = dummy;
        while (size * (size + 1) / 2 < n) {
            if (size % 2 == 0) {
                Node localHead = reverse (prev.next, size);
                prev.next = localHead;
            }
            //move pointer to tail of current reversed list
            for (int count = 0; prev.next != null && count < size; prev = prev.next, count++);
            size++;
        }
        size -= 1;
        int nodesLeft = n - size * (size + 1) / 2;

        if (nodesLeft > 0 && nodesLeft % 2 == 0) {
            Node node = reverse (prev.next, nodesLeft);
            prev.next = node;
        }
        return dummy.next;
    }

    public static Node reverse (Node head, int n) {
        Node curr = head;
        while (n-- > 1) {
            Node next = curr.next;
            curr.next = next.next;
            next.next = head;
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        _01_SinglyLinkedList ll = new _01_SinglyLinkedList();

        //5,2,6,3,9,1,7,3,8,4
        ll.insertAtEnd(5);
        ll.insertAtEnd(2);
        ll.insertAtEnd(6);
        ll.insertAtEnd(3);
        ll.insertAtEnd(9);
        ll.insertAtEnd(1);
        ll.insertAtEnd(7);
        ll.insertAtEnd(3);
        ll.insertAtEnd(8);
        ll.insertAtEnd(4);


        Node head = ll.getHead();
        System.out.println("input list: \n" + _01_SinglyLinkedList.toString(head));
        Node ans = reverseEvenLengthGroups(head);
        System.out.println("output list: \n" + _01_SinglyLinkedList.toString(ans));
    }
}
