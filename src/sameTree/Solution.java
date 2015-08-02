package sameTree;

import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p != null && q != null) {
			if (p.val == q.val)
				return isSameTreeRecursive(p.left, q.left)
						&& isSameTreeRecursive(p.right, q.right);
			else
				return false;
		}
		return false;
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {

		Stack<TreeNode> sp = new Stack<TreeNode>();
		Stack<TreeNode> sq = new Stack<TreeNode>();
		
		sp.push(p);
		sq.push(q);
		
		while (!sp.isEmpty() && !sq.isEmpty()){
			TreeNode tp = sp.pop();
			TreeNode tq = sq.pop();
			
			if (tp == null && tq == null) 
				continue;
			if(tp == null || tq == null)
				return false;
			if(tp.val != tq.val)
				return false;
			
			sp.push(tp.left);
			sp.push(tp.right);
			sq.push(tq.left);
			sq.push(tq.right);
				
		}
		
		if (sq.size() != 0 || sp.size() != 0)
			return false;
		return true;
	}
}
