package insertionSortList;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode help = new ListNode(0);
		
		ListNode curr = head.next;
		help.next = head;
		head.next = null;

		while (curr != null) {
			ListNode tmp = curr.next;
			ListNode mover = help;

			while (mover.next != null && mover.next.val <= curr.val) {
				mover = mover.next;
					
			}
			curr.next = mover.next;
			mover.next = curr;
			curr = tmp;
		}
		return help.next;
	}

	public void printList(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static void main (String[] args){
		Solution s = new Solution();
		
		ListNode head = s.new ListNode(1);
		ListNode a = s.new ListNode(1);
		
		head.next = a;
		
		ListNode result = s.insertionSortList(head);
		
		s.printList(result);
	}
}
