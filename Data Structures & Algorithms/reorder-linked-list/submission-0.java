/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        // find half point of the list
        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        // reverse the second half
        ListNode curr = first.next;

        ListNode prev = null;
        first.next = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // merge two list
        ListNode l = head;
        ListNode r = prev;
        while (r != null) {
            ListNode leftNext = l.next;
            l.next = r;
            ListNode rNext = r.next;
            r.next = leftNext;
            l = leftNext;
            r = rNext;
        }
    }}   
