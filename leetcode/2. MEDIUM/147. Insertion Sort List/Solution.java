// 控制三个指针pre,cur,next。
// 将pre.next也就是要输出的head和每次的cur的值进行比较并插到合适位置

public class Solution{
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode sortedlisthead = new ListNode(0);
		ListNode cur = head;
		while(cur != null){
			ListNode next = cur.next;
			ListNode pre = sortedlisthead;
			while(pre.next != null && pre.next.val < cur.val)
				pre = pre.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return sortedlisthead.next;
	}
}