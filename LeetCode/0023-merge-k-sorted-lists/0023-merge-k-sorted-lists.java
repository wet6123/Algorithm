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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;

        for (ListNode list : lists) {
            if (ans == null) {
                ans = list;
            } else {
                while (list!= null && ans.val > list.val) {
                    ans = new ListNode(list.val, ans);
                    list = list.next;
                }
                ListNode idx = ans;
                while(list != null) {
                    if (idx.val <= list.val && (idx.next == null || idx.next.val > list.val)) {
                        ListNode tmp = idx.next;
                        idx.next = new ListNode(list.val, tmp);
                        list = list.next;
                    } else {
                        idx = idx.next;
                    }
                }
            }
        }

        return ans;
    }

    // public int getLen(ListNode head) {
    //     int len = 0;
    //     ListNode current = head;
    //     while(current != null) {
    //         len++;
    //         current = current.next;
    //     }
    //     return len;
    // }
}