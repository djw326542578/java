class Node{
	int val;
	Node next;
	
}
public Node partition(Node head,int x){
	Node small=null;
	Node big=null;
	Node last1 = null;
	Node last2 = null;
	for(Node cur = head;cur!=null;cur=cur.next){
		if(cur.val<x){
			if(small==null){
				small=cur;
			}else{
				cur.next=null;
				last1.next=cur;	
			}
			last1= cur;
		}else{
			if(big==null){
				big=cur;				
			}else{
				cur.next=null;
				last2.next=cur;	
			}
			last2 = cur;
		}
	}
	if(small == null){
		return big;
	}else{
		last1.next = big;
		if(last2)
	}
}