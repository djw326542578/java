class Node{
	int val;
	Node next;
	
}

int getLength(Node head){
	Node num = head;
	int count = 0;
	while(num!=null){
		num=num.next;
		count++
	}
	
}

Node findMiddle(Node head){
	Node fast = head;
	Node slow = head;
	
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