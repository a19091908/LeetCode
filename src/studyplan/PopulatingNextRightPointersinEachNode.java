//You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. 
//The binary tree has the following definition:
//	
//Constraints:
//		The number of nodes in the tree is in the range [0, 212 - 1].
//		-1000 <= Node.val <= 1000
//		 
//
//Follow-up:
//		You may only use constant extra space.
//		The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

package studyplan;

import java.util.LinkedList;
import java.util.Queue;

import definedDS.Node;

public class PopulatingNextRightPointersinEachNode {

	public static void main(String[] args) throws Exception {
		Integer[] nodeArr = {1,2,3,4,5,6,7};
		Node root = Node.createTree(nodeArr);
		new PopulatingNextRightPointersinEachNode().connect(root);
		Node.BFS(root);
	}
	
	// version2
	public Node connect(Node root) {
		dfs(root, null);
		return root;
	}

	private void dfs(Node currNode, Node nextNode) {
		if (currNode == null) {
			return;
		}
		currNode.next = nextNode;
		dfs(currNode.left, currNode.right);
		dfs(currNode.right, currNode.next != null ? currNode.next.left : null);	
	}
	
	
//	// version 1
//	public Node connect(Node root) {
//		if (root == null) {
//			return null;
//		}
//		
//		Queue<Node> queue = new LinkedList<Node>();
//		queue.add(root);
//		int cnt = 1, nextLevelCnt = 2;
//		while(queue.isEmpty() == false){
//			Node preNode = queue.remove();
//			if (preNode == null) {
//				continue;
//			}
//			if (cnt == nextLevelCnt-1) {
//				preNode.next = null;
//				nextLevelCnt *= 2;
//			}else{ // cnt == nextLevelCnt
//				preNode.next = queue.peek();
//			}
//			
//			queue.add(preNode.left);
//			queue.add(preNode.right);
//			cnt++;
//		}
//		return root;
//	}

}
