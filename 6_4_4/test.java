class ListNode{
	int val;
	Node next;
}

public class test{
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode cur1 =l1;
		ListNode cur2 =l2;
		ListNode last = mull;
		ListNode result = mull;
		
		while(cur1 != null&& cur2 != null){
			if(cur1.val<=cur2.val){
				ListNode next =cur1.next;
				if(result==null){
					cur1.next=result;
					result.=cur1;
					
				}else{
					cur1.next=null;
					last.next=cur1;	
				}
				last=cur1;
				cur1=next;
			}else{
				ListNode.next =cur2.next;
				if(result==null){
					cur2.next=result;
					result=cur2;
					
				}else{
					cur2.next=null;
					last.next=cur2;	
				}
				last=cur2;
				cur2=next;
				
			}
		}
		if(cur1!=null&&last!=null){
			last.next=cur1;
		}else if(cur2!=null&&last!=null){
			last.next=cur2;
		}
		return result;
	}