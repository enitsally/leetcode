package convertSortedArraytoBinarySearchTree;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;

		return sortedArrayToBST(num, 0, num.length - 1);
	}

	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);

		return root;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] { 0, 1, 2 };
		TreeNode root = s.sortedArrayToBST(nums);

		System.out.println(root);
	}
}
