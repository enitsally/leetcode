package rootToLeafSum;

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

	public int sumNumbers(TreeNode root) {
		
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null)
			return root.val;
				
		LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
		LinkedList<Integer> value = new LinkedList<Integer>();
		int total = 0;
		
		nodes.push(root);
		value.push(root.val);
	
		while (!nodes.isEmpty()){
			TreeNode tmp = nodes.poll();
			int sumValue = value.poll();
			
			if (tmp.left == null && tmp.right == null){
				total = total + sumValue;
			}
			
			if (tmp.left != null){
				nodes.push(tmp.left);
				value.push(sumValue * 10 + tmp.left.val);
			}
			
			if (tmp.right != null){
				nodes.push(tmp.right);
				value.push(sumValue * 10 + tmp.right.val);
			}
			
		}
		return total;
	}
	
	public int sumNumbersII(TreeNode root){
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		
		getSumNumbers(root, curr,result);
		
		int total = 0;
		for(List<Integer> tmp : result){
			int subTotal = 0;
			
			for(int i : tmp){
				subTotal = subTotal *10 +i;
			}
			
			total = total + subTotal;
		}
		
		return total;
	}
	
	public void getSumNumbers(TreeNode root, List<Integer> curr, List<List<Integer>> result){
		if (root == null)
			return;
		
		curr.add(root.val);
		if (root.left == null && root.right == null){
			result.add(new ArrayList<Integer>(curr));
		}
		
		getSumNumbers(root.left, curr, result);
		getSumNumbers(root.right,curr,result);
		curr.remove(curr.size()-1);
	}
	
}
