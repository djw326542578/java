class ListNode{
	int val;
	Node next;
}
//从链表中删除所有相同的字符

ListNode removeElements(ListNode head, int val){
	ListNode newlist =null;
	ListNode cur=head;
	while(cur!=null){
		ListNode next =cur.next;
		
		if(cur.val!=val){
			if(newlist==null){
				cur.next=newlist;
				newlist=cur;
			}else{
				ListNode last = newlist;
				while(last.next!=null){
					last=last.next;
				}
				last.next=cur;
				cur.next=null;
			}
			
		}
		cur=next;
	}
	return newlist;
}


//改

ListNode removeElements(ListNode head, int val){
	ListNode newlist =null;
	ListNode last = null;
	ListNode cur=head;
	while(cur!=null){
		ListNode next =cur.next;
		
		if(cur.val!=val){
			if(newlist==null){
				cur.next=newlist;
				last=cur;
			}else{
				last.next=cur;
			}
			last=cur;
		}
		cur=next;
	}
	if(last!=null){
		last.next = null;
	}
	return newlist;
}