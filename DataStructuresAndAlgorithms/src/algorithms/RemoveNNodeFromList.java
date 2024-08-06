package algorithms;

public class RemoveNNodeFromList {
	public static void main(String[] args) {
		
		
		
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		
		
		ListNode two = new ListNode(2,three);
		ListNode head = new ListNode(1, two);
		
		//ListNode head = new ListNode(1);
		
		ListNode node = head;

		System.out.println("Before removal");
		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}
		System.out.println("");

		node = removeNthFromEnd(head, 2);

		
		System.out.println("After removal");

		while (node != null) {
			System.out.print(node.val);
			node = node.next;
		}

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode next = head;
		ListNode p = null;
		while (n > 0 && next != null) {
			--n;
			next = next.next;
		}
		while (next != null) {
			p = (p!=null)?p.next:head;
			next = next.next;
		}
		if(p == null) {
			head = head.next;
		}else {
			p.next = p.next.next;
		}
		return head;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
