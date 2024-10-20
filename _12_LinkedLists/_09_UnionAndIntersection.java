/*
https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 */

import _03_Basic_Operations_on_SLL._01_SinglyLinkedList;
import _03_Basic_Operations_on_SLL._01_SinglyLinkedList.Node;

import java.util.HashSet;

public class _09_UnionAndIntersection {

    public static void main(String[] args) {
        _01_SinglyLinkedList ll1 = new _01_SinglyLinkedList();
        ll1.insertAtEnd(1);
        ll1.insertAtEnd(2);
        ll1.insertAtEnd(3);
        ll1.insertAtEnd(4);

        _01_SinglyLinkedList ll2 = new _01_SinglyLinkedList();
        ll2.insertAtEnd(2);
        ll2.insertAtEnd(3);
        ll2.insertAtEnd(4);
        ll2.insertAtEnd(5);
        System.out.println("input 1: \n" + _01_SinglyLinkedList.toString(ll1.getHead()));
        System.out.println("input 2: \n" + _01_SinglyLinkedList.toString(ll2.getHead()));
        System.out.println();

        System.out.println("Approach 1");
        Node[] res = unionAndIntersectionApproach1(ll1.getHead(), ll2.getHead());
        System.out.println("Union: \n" + _01_SinglyLinkedList.toString(res[0]));
        System.out.println("Intersection: \n" + _01_SinglyLinkedList.toString(res[1]));

        System.out.println();

        System.out.println("Approach 2");
        Node[] res2 = unionAndIntersectionApproach2(ll1.getHead(), ll2.getHead());
        System.out.println("Union: \n" + _01_SinglyLinkedList.toString(res2[0]));
        System.out.println("Intersection: \n" + _01_SinglyLinkedList.toString(res2[1]));
    }

    //O(m + n)  O(m * n * k) k - no of common elements
    public static Node[] unionAndIntersectionApproach1 (Node head1, Node head2) {
        Node[] nodeArr = new Node[2];
        Node headOfUnion = union(head1, head2);
        nodeArr[0] = _05_RemoveDuplicatesFromUnsortedList.removeDuplicatesUsingHashSet(headOfUnion);
        nodeArr[1] = intersection (head1, head2);
        return nodeArr;
    }

    //O(m + n)  O(m + n)
    public static Node[] unionAndIntersectionApproach2 (Node head1, Node head2) {
        Node[] nodeArr = new Node[2];
        HashSet<Integer> set = new HashSet<>();
        Node curr = head1;

        while (curr != null) {
            set.add(curr.data);
            curr = curr.next;
        }

        curr = head2;
        Node intersectionDummy = new Node();
        Node curr2 = intersectionDummy;
        while (curr != null) {
            if (!set.add(curr.data)) {
                curr2.next = new Node(curr.data);
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        nodeArr[1] = intersectionDummy.next;

        Node unionDummy = new Node();
        Node curr3 = unionDummy;
        for (int i : set) {
            curr3.next = new Node(i);
            curr3 = curr3.next;
        }
        nodeArr[0] = unionDummy.next;
        return nodeArr;
    }

    //O(m * n * k)
    private static Node intersection(Node head1, Node head2) {
        _01_SinglyLinkedList result = new _01_SinglyLinkedList();
        Node curr = head1;
        while (curr != null) {
            if (isPresent(head2, curr.data) && !isPresent(result.getHead(), curr.data)) {
                result.insertAtEnd(curr.data);
            }
            curr = curr.next;
        }
        return result.getHead();
    }

    private static boolean isPresent(Node head, int value) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == value) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    //O(m + n)
    private static Node union(Node head1, Node head2) {
        _01_SinglyLinkedList result = new _01_SinglyLinkedList();
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node curr = head1;
        while (curr != null) {
            result.insertAtEnd(curr.data);
            curr = curr.next;
        }

        curr = head2;
        while (curr!= null) {
            result.insertAtEnd(curr.data);
            curr = curr.next;
        }

        return result.getHead();
    }
}
