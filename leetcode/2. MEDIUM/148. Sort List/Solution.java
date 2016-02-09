/*
	归并排序，需要注意的是sortList方法中，
	while这个循环执行到剩3个结点，然后拆分成2和1
	此后便不在拆分，但是，但是（因为很重要所以说两遍）
	但只是不通过fast,slow指针来拆分，因为只剩下两个结点
	firsthalf = head, secondhalf = head.next
	然后就只需要根据大小的比较将结点一个一个拼接起来即可
*/
public class Solution{
	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode slow = head, fast = head, firsthalf = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode secondhalf = slow.next; // 中点开始的后半段
		slow.next = null; 

		ListNode leftlist = null, rightlist = null;
		if(firsthalf != secondhalf){
			leftlist = sortList(firsthalf);
			rightlist = sortList(secondhalf);
		}
		return mergeTwoLists(leftlist, rightlist);
	}

	public ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist){
		if(rightlist == null) return leftlist;
		if(leftlist == null) return rightlist;

		ListNode fakehead = new ListNode(0);
		ListNode ptr = fakehead;
		while(rightlist != null && leftlist != null){
			if(leftlist.val > rightlist.val){
				ptr.next = rightlist;
				ptr = ptr.next;
				rightlist = rightlist.next;
			}else{
				ptr.next = leftlist;
				ptr = ptr.next;
				leftlist = leftlist.next;
			}
		}
		if(rightlist != null)
			ptr.next = rightlist;
		if(leftlist != null)
			ptr.next = leftlist;
		return fakehead.next;
	}
}