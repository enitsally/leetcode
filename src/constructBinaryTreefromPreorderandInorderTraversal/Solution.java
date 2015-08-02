package constructBinaryTreefromPreorderandInorderTraversal;

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(inorder == null || preorder == null || preorder.length != inorder.length)
			return null;
		
		int  n = inorder.length;
		return buildTree(preorder, inorder, 0, n-1,0, n-1);
	
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder, int s1, int e1, int s2, int e2){
		if (s1 >= inorder.length || s2 >= inorder.length)
			return null;
		if(s1 == e1) 
			return new TreeNode(preorder[s1]);
		if( s1 > e1 || s2 > e2)
			return null;
		
		int rootval = preorder[s1];
		TreeNode root = new TreeNode(rootval);
		int i;
		
		for( i= s2; i <= e2; i++){
			if(inorder[i] == rootval)
				break;
		}
		
		int leftlength = i - s2;
		//int rightlength = e2 - i;
		
		root.left = buildTree(preorder, inorder, s1+1, s1+leftlength, s2, i-1);
		root.right = buildTree(preorder,inorder,s1+leftlength+1, e1, i+1, e2);
		
		return root;
		
	}
}
