/*
https://leetcode.com/problems/intersection-of-two-linked-lists/description/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

public class _10_LC160_IntersectionOfLLs {

    public static Node getIntersectionNodeTwoPointers(Node headA, Node headB) {
        Node ptr1 = headA;
        Node ptr2 = headB;

        while (ptr1 != null || ptr2 != null) {
            if (ptr1 == null) ptr1 = headB;
            else if (ptr2 == null) ptr2 = headA;
            if (ptr1.equals(ptr2)) return ptr1;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return null;
    }

    public static Node getIntersectionNodeBruteForce(Node headA, Node headB) {
        int ac = 0;
        int bc = 0;
        Node a = headA;
        Node b = headB;
        while (a != null) {
            ac++;
            a = a.next;
        }
        while (b != null) {
            bc++;
            b = b.next;
        }
        while (ac > bc) {
            ac--;
            headA = headA.next;
        }
        while (bc > ac) {
            bc--;
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }


    public static void main(String[] args) {
        _01_SinglyLinkedList ll1 = new _01_SinglyLinkedList();
        ll1.insertAtEnd(4);
        ll1.insertAtEnd(1);

        _01_SinglyLinkedList ll2 = new _01_SinglyLinkedList();
        ll2.insertAtEnd(5);
        ll2.insertAtEnd(6);
        ll2.insertAtEnd(1);

        _01_SinglyLinkedList ll3 = new _01_SinglyLinkedList();
        ll3.insertAtEnd(8);
        ll3.insertAtEnd(4);
        ll3.insertAtEnd(5);

        Node tail1 = ll1.getTail();
        Node tail2 = ll2.getTail();

        tail1.next = ll3.getHead();
        tail2.next = ll3.getHead();

        Node head1 = ll1.getHead();
        Node head2 = ll2.getHead();

        //Node intersectionNode = getIntersectionNodeTwoPointers(head1, head2);
        Node intersectionNode = getIntersectionNodeTwoPointers(head1, head2);

        System.out.println("Intersection Node: ");
        if (intersectionNode == null) System.out.println("NULL");
        else System.out.println(intersectionNode.data);
    }
}
