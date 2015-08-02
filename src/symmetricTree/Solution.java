package symmetricTree;

import java.util.*;

public class Solution {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {

		if (root == null)
			return true;
		
		Stack<TreeNode> left = new Stack<TreeNode>();
		Stack<TreeNode> right = new Stack<TreeNode>();

		left.push(root.left);
		right.push(root.right);

		while (!left.isEmpty() && !right.isEmpty()) {
			TreeNode l = left.pop();
			TreeNode r = right.pop();

			if (l == null && r== null)
				continue;
			
			if (l == null || r == null)
				return false;
			
			if (l.val != r.val)
					return false;
				
			left.push(l.left);
			right.push(r.right);
			left.push(l.right);
			right.push(r.left);

		}

		if (!left.isEmpty() || !right.isEmpty())
			return false;

		return true;

	}

	public boolean isSymmetricRecursive(TreeNode root) {
		if (root == null)
			return true;

		if (root.left == null && root.right == null)
			return true;
		else if (root.left != null && root.right != null)
			if (root.left.val == root.right.val)
				return isOverturnedTree(root.left, root.right);
			else
				return false;

		return false;
	}

	public boolean isOverturnedTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p != null && q != null) {
			if (p.val == q.val) {
				return isOverturnedTree(p.left, q.right)
						&& isOverturnedTree(p.right, q.left);
			} else
				return false;
		}
		return false;

	}

	public static void main(String[] args) {
		Solution s = new Solution();

		TreeNode root = s.new TreeNode(1);
		TreeNode left = s.new TreeNode(2);
		TreeNode right = s.new TreeNode(3);
		
		//TreeNode e = s.new TreeNode(3);
		//TreeNode f = s.new TreeNode(3);
		root.left = left;
		root.right = right;
//		root.right.right = e;
//		root.left.left = f;
	

		System.out.println(s.isSymmetric(root));

	}
}
