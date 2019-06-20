class Node {
	int val;
	Node next;
}

//删除所有的 val
Node removeValue(Node head,int value){
	
	Node cur=head;
	while(cur!=null){
		if(cur.val==value&&cur==head){
			head=cur.next;
		}
		if(cur.next!=null){
			cur=cur.next;
			
			if(cur.next.val=value){
				
				if(cur.next.next==null){
				cur.next=null;
				}
			cur.next=cur.next.next;
			}
		}
		
		
	}
}

//逆置链表
Node reverseList(Node head){
	Node cur = head;
	Node newHead;
	while(cur!=null){
		if(newHead==null){
			cur=newHead;
			cur.next=null;
		}else{
			cur.next=newHead;
			newHead=cur;
		}
		cur=cur.next;
		
	}
}

