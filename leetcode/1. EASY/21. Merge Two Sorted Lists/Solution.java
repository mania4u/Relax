public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)	
			return null;
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode newhead = new ListNode(0);
		ListNode p = newhead;	// p is used as a pointer
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {	// when the value of l1 is bigger than the value of l2
				p.next = l2;		// p.next(the pointer of new list) points to the l2
				l2 = l2.next;		// l2 pops the first node and the rest of l2 became the new l2
			} else {				 
				p.next = l1;		// same as the above
				l1 = l1.next;
			}
			p = p.next;		// p points to the p.next
		}
		if (l1 == null)		
		// when reach the end of l1, just attach the rest of l2 to the new list because it's sorted
			p.next = l2;
		else
			// when reach the end of l2, just attach the rest of l1 to the new list because it's sorted
			p.next = l1;	
		
		return newhead.next;	
		// the reason return "newhead.next" not "newhead" because there is always a "0" at the head of list
	}
}