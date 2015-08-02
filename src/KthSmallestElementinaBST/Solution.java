package KthSmallestElementinaBST;

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

	public int kthSmallest(TreeNode root, int k) {
		if (root == null || k == 0)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int cnt = 0;
		int result = 0;
		TreeNode curr = root;

		while (!stack.isEmpty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				if (!stack.isEmpty())
					curr = stack.pop();
				cnt++;
				if (cnt == k)
					result = curr.val;

				curr = curr.right;
			}
		}

		return result;
	}

	public int kthSmallestA(TreeNode root, int k) {

		List<Integer> leafList = new ArrayList<Integer>();
		convertList(root, leafList);
		
		return leafList.get(k-1);

	}

	public void convertList(TreeNode root, List<Integer> leaf) {
		if (root.left == null && root.right == null) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(root.val);
			leaf.addAll(tmp);
		}

		else {
			if (root.left != null)
				convertList(root.left, leaf);
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(root.val);
			leaf.addAll(tmp);
			if (root.right != null)
				convertList(root.right, leaf);
		}

	}

	public static void main(String[] args) {
		Solution s = new Solution();

		TreeNode root = s.new TreeNode(1);

		int k = 1;

		System.out.println(s.kthSmallestA(root, k));
	}
}
