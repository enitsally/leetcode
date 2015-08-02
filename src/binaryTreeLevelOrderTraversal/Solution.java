package binaryTreeLevelOrderTraversal;

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

	public List<List<Integer>> levelOrder(TreeNode root) {

		// List<List<Integer>> result = new ArrayList<List<Integer>>();
		// List<Integer> curr= new ArrayList<Integer>();
		// List<Integer> roots = new ArrayList<Integer>();
		// Stack<TreeNode> nodes = new Stack<TreeNode>();
		// Stack<TreeNode> levels = new Stack<TreeNode>();
		//
		// if (root == null)
		// return result;
		//
		// nodes.push(root);
		//
		// while (!nodes.isEmpty() || !levels.isEmpty()){
		// while (!nodes.isEmpty()){
		// TreeNode p = nodes.pop();
		// roots.add(p.val);
		// if(p.right!= null)
		// levels.push(p.right);
		// if(p.left != null)
		// levels.push(p.left);
		//
		// }
		// while (!levels.isEmpty()){
		// TreeNode tmp = levels.pop();
		// curr.add(tmp.val);
		//
		// if(tmp.right != null)
		// nodes.push(tmp.right);
		// if(tmp.left != null)
		// nodes.push(tmp.left);
		//
		// }
		//
		// if(!roots.isEmpty())
		// result.add(new ArrayList<Integer>(roots));
		// if(!curr.isEmpty())
		// result.add(new ArrayList<Integer>(curr));
		//
		// curr.clear();
		// roots.clear();

		List<List<Integer>> al = new ArrayList<List<Integer>>();
		List<Integer> nodeValues = new ArrayList<Integer>();
		if (root == null)
			return al;

		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		current.add(root);

		while (!current.isEmpty()) {
			TreeNode node = current.remove();

			if (node.left != null)
				next.add(node.left);
			if (node.right != null)
				next.add(node.right);

			nodeValues.add(node.val);
			if (current.isEmpty()) {
				current = next;
				next = new LinkedList<TreeNode>();
				al.add(nodeValues);
				nodeValues = new ArrayList<Integer>();
			}

		}
		return al;

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null)
			return result;
		List<Integer> nodeValue = new ArrayList<Integer>();
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		LinkedList<TreeNode> next = new LinkedList<TreeNode>();

		curr.add(root);

		while (!curr.isEmpty()) {
			TreeNode p = curr.poll();
			nodeValue.add(p.val);

			if (p.left != null)
				next.add(p.left);
			if (p.right != null)
				next.add(p.right);

			if (curr.isEmpty()) {
				curr = next;
				next = new LinkedList<TreeNode>();
				result.add(0, nodeValue);
				nodeValue = new ArrayList<Integer>();
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Solution s = new Solution();

		TreeNode root = s.new TreeNode(1);
		TreeNode left = s.new TreeNode(2);
		TreeNode right = s.new TreeNode(3);
		TreeNode p = s.new TreeNode(4);
		TreeNode q = s.new TreeNode(5);

		root.left = left;
		root.right = right;
		//root.left.left = p;
		//root.right.right = q;

		List<List<Integer>> r = s.levelOrderBottom(root);

		for (List<Integer> t : r) {
			System.out.println(t);
		}

	}
}
