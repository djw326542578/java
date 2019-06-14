public ListNode getMid(ListNode head){
	ListNode fast = head;
	ListNode slow = head;
	
	while(fast!=null){
		fast=fast.next;
		if(fast==null){
			break;
		}
		slow=slow.next;
		fast=fast.next;
	}
	return slow;
}
}