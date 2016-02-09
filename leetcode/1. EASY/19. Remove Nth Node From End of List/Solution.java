public  class Solution{
	public ListNode removeNthFromEnd(ListNode head, int n){
		ListNode first = head;
		ListNode second = head;
		if (head.next == null)		// judge whether there is only head in the listnode
			return null;
		while (n !=0 ){				// find the Nth element of the listnode FROM THE START!!!
			first = first.next;		// "first" is the location of Nth element FROM THE START
			n--;
		}
		if (first == null)			
			return head.next;
		while (first.next != null){
			first = first.next;		// seperate the listnode into two parts: "first" and "second"
			second = second.next;	
			// "first" is the latter part after Nth element; "second" is the previous part before Nth element
		}							// second.next is the location of Nth element FROM THE END!!!
		second.next = second.next.next;	
		return head;
	}
}