class ListNode{
	int val;
	Node next;
}

public class test{//找第K个结点

	public ListNode FindKthToTail(ListNode head,int k){
		ListNode cur=head;
		ListNode front=head;
	
		int length=0;
		for(cur;cur!=null;cur=cur.next){
			length++
		}
		if(length<k){
			return null;
		}
		
		for(inti=0;i<k;i++){
			front=front.next;
		}
		while(front!=null)
		{
			cur=cur.next;
			front=front.next;
		
		}
		return cur;
	}

}