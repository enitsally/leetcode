package countCompleteTreeNodes;

public class Solution {

	public int countNodes(TreeNode root) {
		
		if (root == null)
			return 0;
		
		int leftHeight = getLeftHeight(root) +1;
		int rightHeight = getRightHeight(root) +1;
		
		if (leftHeight == rightHeight)
//			return  (2<<(leftHeight-1))-1;
			return (int)(Math.pow(2, leftHeight)-1);
			
		else {
			return countNodes(root.left) + countNodes(root.right) + 1;
		}
		
	}
	
	public int getLeftHeight(TreeNode node)
	{
		if (node == null)
			return 0;
		int height = 0;
		while (node.left !=null)
		{
			height ++;
			node = node.left;
		}
		return height;
	}
	
	public int getRightHeight(TreeNode node)
	{
		if (node == null)
		return 0;
		
		int height = 0;
		
		while (node.right != null)
		{
			height ++;
			node = node.right;
		}
		
		return height;
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
