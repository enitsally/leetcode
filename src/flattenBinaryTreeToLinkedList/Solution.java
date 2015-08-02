package flattenBinaryTreeToLinkedList;
import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty() ){
            
            stack.push(curr.right);
            
            if (curr.left != null){
                curr.right = curr.left;
                curr.left = null;
            }
            else if (!stack.isEmpty()){
                TreeNode p = stack.pop();
                curr.right = p;
            }
            
            curr = curr.right;
        }
        
        //Test
    }
	
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("John",100);
		map.put("Ming",99);
		map.put("QQ",80);
		map.put("Ming",70);
		
		Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
		
		while (it.hasNext()){
			Map.Entry<String, Integer> i = it.next();
			System.out.println(i.getKey() + " has score " + i.getValue());
		}
		
	}
}
