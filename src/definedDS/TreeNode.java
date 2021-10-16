package definedDS;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	public static TreeNode createTree(Integer[] arr) throws Exception {
		if (arr.length == 0) {
			throw new Exception("陣列為空");
		}
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
		queue.add(root);
		int index = 0;
		while (queue.isEmpty() == false && index < arr.length) {
			boolean isModified = false;
			TreeNode tempNode = queue.peek();
			index++;
			if (index < arr.length) {
				if (arr[index] != null) {
					isModified = true;
					tempNode.left = new TreeNode(arr[index]);
					queue.add(tempNode.left);
				}
			}
			
			index++;
			if (index < arr.length) {
				if (arr[index] != null) {
					isModified = true;
					tempNode.right = new TreeNode(arr[index]);
					queue.add(tempNode.right);
				}
			}
			
			if(isModified)
				queue.remove();
		}
		
		return root;
	}
	
	static public void BFS(TreeNode root) throws Exception {
		if (root == null) {
			throw new Exception("The node is null");
		}
//		ArrayList<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
		queue.add(root);
		
		while(queue.isEmpty() == false) {
			TreeNode tempNode = queue.remove();
			if (tempNode != null) {
				System.out.print(tempNode.val + ", ");
//				list.add(tempNode.left.val == null ? -9999 : tempNode.left.val);
//				System.out.print(tempNode.left.val + ", ");
				queue.add(tempNode.left);
//				list.add(tempNode.right.val == null ? -9999 : tempNode.right.val);
//				System.out.print(tempNode.right.val + ", ");
				queue.add(tempNode.right);
			}else {
				System.out.print("null, ");
			}
		}
		
//		for(Integer tempNode : list) {
//			System.out.print(tempNode + ", ");
//		}
		
	}


}
