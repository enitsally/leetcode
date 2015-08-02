package reorderList;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode walker = head;
		ListNode runner = head;

		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;

		}

		ListNode left = head;
		ListNode right = walker.next;
		walker.next = null;
		System.out.println("Left list:");
		printList(left);
		
		
		//reverse a link
		ListNode help = new ListNode(0);
		while (right != null){
			ListNode tmp = right;
			right = right.next;
			tmp.next =null;
			
			tmp.next = help.next;
			help.next= tmp;
			
		}
		right = help.next;
		System.out.println("Right list:");
		printList(right);
		
		//merge the two link
		while (right != null && left != null){
			ListNode tmp = right;
			right = right.next;
			tmp.next = null;
			
			tmp.next = left.next;
			left.next = tmp;
			left = left.next.next;
		}
		

	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	

	public static void main(String[] args) {
		Solution s = new Solution();

		ListNode head = s.new ListNode(1);
		ListNode node = s.new ListNode(2);
		ListNode q = s.new ListNode(3);
		ListNode b = s.new ListNode(4);
		ListNode c = s.new ListNode(5);
		head.next = node;
//		node.next = q;
//		q.next = b;
//		b.next = c;

		s.reorderList(head);
		s.printList(head);
	}
}
