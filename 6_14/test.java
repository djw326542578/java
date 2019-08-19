class Node{
	int val;
	Node next;
	Node random;
	
}
//复制复杂链表
//1.先遍历原链表，进行结点复制，将新结点放到对应的老结点的后面
//2.遍历每组（老+新结点） 再进行 random 的赋值
//3.拆分新链表


public class test{
	
	public Node copyRandomList(Node head){	
		// 1.
		Node cur = head;
		while(cur!=null){
			Node node = new Node(cur.val);
			
			node.next = cur.next;
			cur.next = node;
			cur=cur.next.next;
		}
		
		// 2.
		cur = head;
		while(cur !=null){
			if(cur.random!=null){
				cur.next.random = cur.random.next;
			}else{
				cur.next.random=null;
			}
			cur=cur.next.next;
		}
		
	
		// 3.
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
}