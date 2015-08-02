package intersectionofTwoLinkedLists;

public class Solution {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null)
	            return null;
	        int lenA = 0;
	        int lenB = 0;
	        ListNode p = headA, q = headB;
	        while(p != null){
	            lenA++;
	            p = p.next;
	        }
	        
	        while(q != null){
	            lenB ++;
	            q = q.next;
	        }
	        
	        p = headA;
	        q = headB;
	        
	        int diff =Math.abs(lenA-lenB);
	        if (lenA > lenB){
	            for(int i =0; i< diff; i++)
	                p = p.next;
	        }
	        else {
	            for(int i =0; i< diff; i++)
	                q = q.next;
	        }
	        
	        while(p!=null){
	            if (p == q)
	                return p;
	            p = p.next;
	            q = q.next;
	        }
	        
	        return null;
	}
	
	public static void main (String[] args){
		Solution s = new Solution();
		ListNode a = s.new ListNode(1);
		ListNode b = s.new ListNode(1);
		ListNode c = s.new ListNode(2);
		a.next = c;
		
		System.out.println(s.getIntersectionNode(a, b));
	}
}
