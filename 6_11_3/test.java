public ListNode deleteDuplication(ListNode pHead){
	ListNode prev = new ListNode(0);
	ListNode p1=pHead;
	ListNode p2=pHead.next;
	ListNode head=prev;
	
	while(p2!=null){
		if(p1.val!=p2.val){
			prev=p1;
			p1=p1.next;
			p2=p2.next;
		}else{
			while(p2!=null&&p1.val==p2.val){
				p2=p2.next;
			}
			prev.next=p2;
			p1=p2;
			if(p2!=null){
				p2=p2.next;
			}
		}
	}
	return head;
}