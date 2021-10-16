//You are given two binary trees root1 and root2.
//
//Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.
//
//Return the merged tree.
//
//Note: The merging process must start from the root nodes of both trees.
//
//Constraints:
//
//	The number of nodes in both trees is in the range [0, 2000].
//	-104 <= Node.val <= 104

package studyplan;

import definedDS.TreeNode;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) throws Exception {
		Integer[] root1Arr = {1,3,2,5}, root2Arr = {2,1,3,null,4,null,7};
		TreeNode root1 = TreeNode.createTree(root1Arr);
		TreeNode root2 = TreeNode.createTree(root2Arr);
		TreeNode ans = new MergeTwoBinaryTrees().mergeTrees(root1, root2);
		TreeNode.BFS(ans);
	}
	
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
	    if (root1 == null && root2 != null) {
			return root2;
		}else if(root1 != null && root2 != null){
			root1.val += root2.val;
			root1.left = mergeTrees(root1.left, root2.left);
			root1.right = mergeTrees(root1.right, root2.right);
		}

		return root1;
	}

}
