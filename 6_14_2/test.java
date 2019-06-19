class Node {
	int val;
	Node random;
	Node next;
}

Node copyRandomList(Node head){
	
	Node cur=head;
	while(cur!=null){
		Node node= new Node(cur.val);
		
		node.next=cur.next;
		cur.next=node;
		cur=cur.next.next;
	}
	
	cur=head;
	while(cur!=null){
		if(cur.random!=null){
			cur.next.random=cur.random.next;	
		}else{
			cur.next.random=null;
		}
		cur=cur.next.next;
	}
	
	cur=head;
	Node newHead = head.next;
	while(cur!=null){
		Node node = cur.next;
		cur.next=node.next;
		if(node.next!=null){
			node.next=node.next.next;
		}
		cur=cur.next;
	}
}