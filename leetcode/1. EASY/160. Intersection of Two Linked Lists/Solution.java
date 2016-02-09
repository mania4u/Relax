// 要求的是两个链表重合部分的第一个点，而不是相同的第一个点
// 若节点相同，意味着节点之后的部分都是相同的！！

public class Solution{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB){
		int lenA = length(headA), lenB = length(headB);
		while(lenA > lenB){
			headA = headA.next;
			lenA--;
		}
		while(lenA < lenB){
			headB = headB.next;
			lenB--;
		}

		while(headA != headB){
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private int length(ListNode node){
		int length = 0;
		while(node != null){
			node = node.next;
			length++;
		}
		return length;
	}
}