package addTwoNumbers;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);

		if (l1 == null && l2 == null)
			return result;
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		ListNode p = l1;
		ListNode q = l2;
		int preNumber = 0;
		ListNode curr = result;

		while (p != null || q != null) {
			if (p != null) {
				preNumber += p.val;
				p = p.next;
			}
			if (q != null) {
				preNumber += q.val;
				q = q.next;
			}
			ListNode newNode = new ListNode(preNumber % 10);

			preNumber = preNumber / 10;

			curr.next = newNode;
			curr = curr.next;

			if (preNumber > 0) {
				curr.next = new ListNode(preNumber);
			}

		}

		return result.next;

	}
	
	public ListNode addTwoNumbersII(ListNode l1){
		ListNode result = new ListNode(0);
		if (l1 == null)
			return result;
		
		int preNode = addTwo(l1,result);
		
		if (preNode > 0){
			result.val = preNode;
			return result;
		}
		
		return result.next;			
				
	}
	public int addTwo(ListNode l1,  ListNode result){ 
		int preNode = 0;
		if (l1.next == null)
		{
			int sum = l1.val +1;
			ListNode newNode = new ListNode(sum%10);
			newNode.next = result.next;
			result.next = newNode;
			preNode = sum/10;
		}
		
		else{
			preNode = addTwo(l1.next, result);
			int sum = preNode + l1.val;
			ListNode newNode = new ListNode(sum%10);
			newNode.next = result.next;
			result.next = newNode;
			preNode = sum/10;
		}
		
		return preNode;		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();

		ListNode l1 = s.new ListNode(9);
		ListNode a = s.new ListNode(9);
		ListNode b = s.new ListNode(9);
		ListNode c = s.new ListNode(9);

		l1.next = a;
		a.next = b;
		b.next = c;


		ListNode print = s.addTwoNumbersII(l1);
		String output ="";
		while (print!=null){
			output += print.val + ",";
			print = print.next;
		}
		System.out.println(output);
	}
	
	
}
