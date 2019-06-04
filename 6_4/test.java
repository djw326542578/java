class Node{
	int val;
	Node next;
	
	node(int val){this.val=val;}
}

class test{
	
	public static Node PushFront(Node head,int val){
		Node node = new Node(val);
		node.next=head;
		return node;
	}
	
	public static Node popBack(Node head){
		Node list=head;
		
		if(head==null){
			return null;
		}
		
		if(head.next==null){
			return null;
		}
		
		while(list.next.next!=null){
			list= list.next;
		}
		list.next=null;
		return head;
		
	}
	
	public Node reverseList(Node head){
		ListNode newlist=null;
		ListNode cur=head;
		
		while(cur!=null){
			ListNode next=cur.next;
			cur.next=newlist;
			newlist=cur;
			cur=next;
		}
		return newlist;
	}
	
}