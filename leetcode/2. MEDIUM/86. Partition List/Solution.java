public class Solution{
	public ListNode partition(ListNode head, int x){
		if(head == null || head.next == null) return head;
		ListNode small = new ListNode(0);
		ListNode newsmallhead = small;
		ListNode big = new ListNode(0);
		ListNode newbighead = big;

		while(head != null){
			if(head.val < x){
				small.next = head;
				small = small.next;
			}else{
				big.next = head;
				big = big.next;
			}
			head = head.next;
		}
		big.next = null;
		small.next = newbighead.next;
		return newsmallhead.next;
	}
}