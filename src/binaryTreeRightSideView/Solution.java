package binaryTreeRightSideView;

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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> right = new ArrayList<Integer>();
		
		if (root == null)
			return right;
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<TreeNode> view = new LinkedList<TreeNode>();
		queue.add(root);
		right.add(root.val);
		
		while (!queue.isEmpty() || !view.isEmpty()){
			
			TreeNode curr = queue.remove();
			
			if(curr.right != null)
				view.add(curr.right);
			if(curr.left != null)
				view.add(curr.left);
			
			if(queue.isEmpty() && !view.isEmpty()){
				queue = view;
				view = new LinkedList<TreeNode>();
				right.add(queue.peek().val);
			}	
			
		}
		return right;
	}
	
	 public List<Integer> rightSideViewII(TreeNode root) {
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
