package minimunDepthofBinaryTree;

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

	public int minDepthA(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		int depth = 0;
		int min = Integer.MAX_VALUE;

		TreeNode curr = root;
		while (!stack.isEmpty() || curr != null) {

			nodes.add(curr);

			if (curr.left == null && curr.right == null) {
				depth = nodes.size();
				min = Math.min(min, depth);
				nodes.remove(nodes.size() - 1);
			}

			if (curr.right != null)
				stack.push(curr.right);

			if (curr.left != null)
				curr = curr.left;
			else {
				if (!stack.isEmpty()) {
					TreeNode tmp = stack.pop();

					while (!nodes.isEmpty()) {
						TreeNode last = nodes.get(nodes.size() - 1);
						if (last.right != tmp)
							nodes.remove(nodes.size() - 1);
						else
							break;
					}

					curr = tmp;
				} else
					curr = null;
			}

		}

		return min;
	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;
		else if (root.left == null && root.right != null)
			return 1 + minDepth(root.right);
		else if (root.left != null && root.right == null)
			return 1 + minDepth(root.left);
		else
			return 1 + Math.min(minDepth(root.right), minDepth(root.left));
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
		root.left.left = p;
		root.left.right = q;

		System.out.println(s.minDepth(root));

	}
}
