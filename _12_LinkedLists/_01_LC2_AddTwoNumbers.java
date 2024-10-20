/*
https://leetcode.com/problems/add-two-numbers/
 */

import java.util.Scanner;

public class _01_LC2_AddTwoNumbers {

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int d = 0;
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while (l1 != null || l2 != null || d != 0) {
            int dig1 = l1 != null ? l1.val : 0;
            int dig2 = l2 != null ? l2.val : 0;

            int sum = dig1 + dig2 + d;

            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;

            d = sum / 10;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        ListNode head = dummy.next;
        dummy.next = null;
        return head;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int len1 = scn.nextInt();
        ListNode dummy1 = new ListNode(0);
        ListNode ptr1 = dummy1;

        while (len1-- > 0) {
            ptr1.next = new ListNode(scn.nextInt());
            ptr1 = ptr1.next;
        }

        int len2 = scn.nextInt();
        ListNode dummy2 = new ListNode(0);
        ListNode ptr2 = dummy2;
        while (len2-- > 0) {
            ptr2.next = new ListNode(scn.nextInt());
            ptr2 = ptr2.next;
        }

        ListNode head1 = dummy1.next;
        ListNode head2 = dummy2.next;
        dummy1.next = null;
        dummy2.next = null;
        ListNode ptr = addTwoNumbers(head1, head2);
        int sum = 0;
        int fac = 1;
        while (ptr != null) {
            sum += fac * ptr.val;
            ptr = ptr.next;
            fac *= 10;
        }
        System.out.println(sum);
    }
}
