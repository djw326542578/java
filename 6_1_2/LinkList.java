class Node{//节点
	public int value;//保存数据
	public Node next;//指向下一节点
	
	public Node(int value){
		this.value=value;
	}
}

public class LinkList{
	static void display(Node head){
	for(Node cur = head;cur!=null;cur=cur.next){
		System.out.printf("$d-->",cur.value);
	}
		System.out.println("null");
	}
	
	static Node pushFront(Node head,int value){
				
		Node newNode= new Node(value);
		newNode.next = head;
		return head;
	}
	
	static Node pushBack(Node head,int value){
		if(head==null){
			newNode.next=head;
			return node;
		}else{
			Node newNode = new Node(value);
			Node last=getLast(head);
			last.next=newNode;
			return head;
		}
	}
	
	private static Node getLast(Node head){
		Node last=head;
		while(last.next!=null){
			last =last.next;
		}
		return last;
	}
	
	static void main(String[] args){
		Node head =null;
		head=pushBack(head,1);
		head=pushBack(head,2);
		head=pushBack(head,3);
		display(head);
		head=pushFront(head,10);
		head=pushFront(head,20);
		head=pushFront(head,30);
		display(head);
	}
}
