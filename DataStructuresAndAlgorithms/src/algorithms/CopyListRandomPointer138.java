package algorithms;

public class CopyListRandomPointer138 {
	public static void main(String[] args) {

		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);

		// Set next pointer
		node5.next = null;
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;

		// Set random pointer
		node1.random = null;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;
		Node head = node1;
		display(head);
		System.out.println("-----------");
		Node head2 = copyRandomList(head);
		
	}

	public static Node display(Node head) {
		Node node = head;
		while(node != null) {
			System.out.println(node.val+"; next=>"+node.next+"; random->"+node.random);
			node = node.next;
		}
			
		return head;

	}

	public static Node copyRandomList(Node head) {
		if(head == null)
			return null;
		
		// Pass 1 create clone nodes
		Node current = head;
		while(current != null) {
			Node clone = new Node(current.val);
			clone.next = current.next;
			clone.random = current.random;
			current.next = clone;
			current = clone.next;
		}
		
		current = head; 
		Node head2 = current.next;
		Node current2 = head2;
		while(current2 != null) {
			if(current.random != null)
				current2.random = current.random.next;
			
			if(current2.next == null)
				break;
			
			current2 = current2.next.next;
		}
		current = head;
		current2 = head2;
		
		while(current != null && current2 != null) {
			
			if(current2.next != null) {
				current.next = current2.next;
				current = current.next;
				current2.next = current.next;
				current2 = current2.next;
			}else {
				current.next = current2.next;
				break;
			}
		}
		display(head);
		System.out.println("-------");
		display(head2);
		System.out.println("-------");
		
		
		return head2;

	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
	@Override
	public String toString() {
		return this.val+"";
	}
}
