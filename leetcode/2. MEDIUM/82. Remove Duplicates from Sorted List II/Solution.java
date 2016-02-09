/*
	思路：	扫结点过程中，先进行一次小循环用来剔除和第一个结点相同值的结点
			直到找到最后一个和第一个结点值相同的结点，
			用这个结点每次与pre.next进行比较
			注意，最后一个与第一个结点值相同的结点，和第一个结点的指针是不一样的
			所以就会有循环中的else，即直接跳过这个结点与cur.next相连
*/


public class Solution{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		while(cur != null){
			while(cur.next != null && cur.val == cur.next.val){	
				cur = cur.next;
			}
			if(pre.next == cur){
				pre = pre.next;
			}else{	// 出现重复则改变指针
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}