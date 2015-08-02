package binaryTreenorderTraversal;

import java.util.*;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		inorderTraversalR(root, result);
		return result;
	}

	public void inorderTraversalR(TreeNode root, List<Integer> result) {
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			result.add(root.val);
		else if (root.left != null && root.right == null) {
			inorderTraversalR(root.left, result);
			result.add(root.val);
		} else if (root.left == null && root.right != null) {
			result.add(root.val);
			inorderTraversalR(root.right, result);
		} else {
			inorderTraversalR(root.left, result);
			result.add(root.val);
			inorderTraversalR(root.right, result);
		}

	}

	public List<Integer> inorderTraversalR(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		if (root == null)
			return result;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		HashSet<TreeNode> visit = new HashSet<TreeNode>();

		nodes.push(root);

		while (!nodes.isEmpty()) {
			TreeNode p = nodes.pop();

			if ((p.left == null && p.right == null) || visit.contains(p)){
				result.add(p.val);
			}
			else if(!visit.contains(p)){
				if(p.right != null)
					nodes.push(p.right);
				
				nodes.push(p);
				visit.add(p);
				
				if(p.left != null)
					nodes.push(p.left);
			}	

		}

		return result;
	}

	public static void main(String[] args) {

		Solution s = new Solution();
		TreeNode root = s.new TreeNode(3);
		TreeNode left = s.new TreeNode(1);
		TreeNode right = s.new TreeNode(2);
		root.left= left;
		root.right = right;

		System.out.println(s.inorderTraversalR(root));
	}
}
