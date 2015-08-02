package binaryTreePreOrderTraversal;

import java.util.*;

public class Solution {

	public List<Integer> preorderTraversalA(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();

		help(root, result);
		return result;
	}

	public void help(TreeNode node, List<Integer> res) {
		if (node == null)
			return;
		
		res.add(node.val);
		help(node.left,res);
		help(node.right,res);

	}

	/**
	 * Definition for a binary tree node.
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<Integer> preorderTraversal(TreeNode root){
		List<Integer> result = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		while (root != null || !stack.isEmpty()){
			if (root != null){
				stack.push(root);
				result.add(root.val);
				root = root.left;
			}
			else{
				root = stack.pop();
				root = root.right;
			}
		}
		return result;
	}

}
