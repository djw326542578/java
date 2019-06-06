class ListNode{
	int val;
	Node next;
}

public class test{
	public ListNode middleNode(ListNode head){//找中间结点
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null){
			fast=fast.next;
			if(fast=null){
				break;
			}
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	
}