package binaryTreeRightSide;

import java.util.*;

public class Solution {

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

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> rights = new ArrayList<Integer>();
		
		if (root == null)
			return rights;
		
		
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();		
		
		queue.add(root);
		
		
		while (queue.size()>0)
		{
			int size = queue.size();
			
			for(int i =0 ; i< size; i++)
			{
				TreeNode top = queue.remove();
				
				if (i == 0)
					rights.add(top.val);
				
				if(top.right != null)
					queue.add(top.right);
				
				if (top.left != null)
					queue.add(top.left);
			}
		}

		return rights;
	}

}
