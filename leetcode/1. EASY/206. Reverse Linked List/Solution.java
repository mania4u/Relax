/*
  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  参考：http://www.nowamagic.net/librarys/veda/detail/2241
  大致意思就是每次把next的结点提到最前面
 */

public class Solution{
	public ListNode reverseList(ListNode head){
		ListNode newHead = null;
		while(head != null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
}