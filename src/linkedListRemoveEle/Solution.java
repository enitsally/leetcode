package linkedListRemoveEle;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode removeElements(ListNode head, int val) {

		ListNode zeroHead = new ListNode(0);
		zeroHead.next = head;

		ListNode p = zeroHead;
		while (p.next != null) {
			if (p.next.val == val) {
				ListNode next = p.next;
				p.next = next.next;

			} else {
				p = p.next;
			}

		}
		return zeroHead.next;

	}
}