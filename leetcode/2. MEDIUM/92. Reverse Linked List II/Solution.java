// 题目是在“m到n范围内”reverse，不是说m和n两个结点互换

public class Solution{
    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null) return null;
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for(int i = 0; i < m - 1; i++) pre = pre.next;
        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        // 1 - 2 - 3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5
        for(int i = 0; i < n - m; i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        /* 
            first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4 
            上面代码只有then这点进行了结点操作 别的都是指针操作，所以只有then从3变成了4
            start之所以还是2是因为虽然start后续的指针有了变化，但是start的head一直没变，pre也是同理
        */
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        return dummy.next;
    }
}