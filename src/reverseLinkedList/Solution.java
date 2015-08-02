package reverseLinkedList;

public class Solution {

	/**
	 * Definition for singly-linked list.
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode current = head;
		ListNode next = head.next;

		while (current.next != null) {
			current.next = next.next;
			next.next = head;
			head = next;
			next = current.next;
		}
		return head;

	}

	public ListNode reverseListR(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		ListNode first = head;
		ListNode rest = head.next;
		
		rest = reverseListR(rest);
		first.next.next = first;
		first.next = null;
		
		return rest;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
