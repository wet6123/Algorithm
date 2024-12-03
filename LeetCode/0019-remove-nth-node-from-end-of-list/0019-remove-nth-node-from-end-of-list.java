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
        int len = getLen(head);
        int skipIdx = len - n;
        int[] ans = new int[len - 1];
        int idx = 0;

        ListNode before = null;
        ListNode current = head;
        for(int i = 0; i < len; i++) {
            if (i == skipIdx) {
                if (before != null)
                    before.next = current.next;
                else
                    head = current.next;
                break;
            }
            before = current;
            current = current.next;
        }
        return head;
    }

    public int getLen(ListNode head) {
        int len = 0;
        ListNode current = head;
        while(current != null) {
            len++;
            current = current.next;
        }
        return len;
    }
}