public class Solution{
	public boolean hasCycle(ListNode head){
		if(head == null || head.next == null) return false;
		ListNode walker = head;
		ListNode runner = head;
		while(runner.next != null && runner.next.next != null){
			walker = walker.next;
			runner = runner.next.next;
			if(walker == runner) return true;
		}
		return false;
	}
}