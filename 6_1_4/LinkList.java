class Node{
	int val;
	Node next;
}
//反转链表

Node reverseList(Node head){
	Node newList = null;
	Node cur = head;
	while(cur!=null){
		Node next=cur.next;
		cur.next=newList;
		newList=cur;
		cur=next;
	}
	return newList;
}