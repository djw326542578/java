ListNode reverseList(ListNode head){
	ListNode newlist=null;
	ListNode cur=head;
	while(cur!=null){
		ListNode next=cur.next;
		cur.next=newlist;
		newlist=cur;
		cur=next;
	}
	
	
}
