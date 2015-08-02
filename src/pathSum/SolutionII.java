package pathSum;

import java.util.*;
public class SolutionII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> curr = new ArrayList<Integer>();
		
		if (root == null)
			return result;
		
		recursivePathSum(root,sum,curr,result);
		return result;	
		
	}
	
	public void recursivePathSum(TreeNode root, int sum, List<Integer> curr, List<List<Integer>> result){
		if (root == null)
			return;
		
		curr.add(root.val);
		
		if (root.val == sum && root.left == null && root.right == null){	
			result.add(new ArrayList<Integer>(curr));
		}
		
		recursivePathSum(root.left,sum-root.val,curr,result);
		recursivePathSum(root.right,sum-root.val,curr,result);
		
		curr.remove(curr.size()-1);
	}
}
