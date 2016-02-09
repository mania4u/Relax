public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;
        while(cur.next != null) {
            if (cur.val == cur.next.val) {  // if the value of 1st node is the same as the value the 2nd node
                cur.next = cur.next.next;   // make the previous node point to 3rd node
            }
            else cur = cur.next;    // find the next node
        }
        return head;
    }
}