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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++; 
            curr = curr.next;
        }

        int target = length - n;
        int index = -1;
        ListNode dummy = new ListNode();
        dummy.next = head;
        curr = dummy;
        while (index < target - 1) {
            index++;
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return dummy.next;
    }
}
