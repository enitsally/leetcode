package isPalindromeList;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return false;
		if (head.next == null)
			return true;
		ListNode runner = head;
		ListNode walker = head;

		while (runner.next != null && runner.next.next != null) {
			walker = walker.next;
			runner = runner.next.next;
		}

		if (runner.next != null) {
			runner = runner.next;
		}

		ListNode left = head;
		ListNode right = walker.next;
		walker.next = null;

		ListNode help = new ListNode(0);

		while (right != null) {

			ListNode curr = right;
			right = right.next;
			curr.next = null;

			ListNode next = help.next;
			help.next = curr;
			curr.next = next;

		}

		right = help.next;

		while (right != null) {
			if (left.val != right.val) {
				return false;
			}

			left = left.next;
			right = right.next;

		}
		return true;

	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		
		ListNode root = s.new ListNode(1);
		ListNode a = s.new ListNode(2);
		//ListNode b = s.new ListNode(2);
		//ListNode c = s.new ListNode(1);
		
		root.next = a;
		//a.next = b;
		//b.next = c;
		
		System.out.println(s.isPalindrome(root));
		
		
		
	}
}
