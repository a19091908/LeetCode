package definedDS;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
	public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    
	public static Node createTree(Integer[] arr) throws Exception {
		if (arr.length == 0) {
			throw new Exception("陣列為空");
		}
		Node root = new Node(arr[0]);
		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(root);
		int index = 0;
		while (queue.isEmpty() == false && index < arr.length) {
			boolean isModified = false;
			Node tempNode = queue.peek();
			index++;
			if (index < arr.length) {
				if (arr[index] != null) {
					isModified = true;
					tempNode.left = new Node(arr[index]);
					queue.add(tempNode.left);
				}
			}
			
			index++;
			if (index < arr.length) {
				if (arr[index] != null) {
					isModified = true;
					tempNode.right = new Node(arr[index]);
					queue.add(tempNode.right);
				}
			}
			
			if(isModified)
				queue.remove();
		}
		
		return root;
	}
	
	static public void BFS(Node root) throws Exception {
		if (root == null) {
			throw new Exception("The node is null");
		}
		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(root);
		
		while(queue.isEmpty() == false) {
			Node tempNode = queue.remove();
			if (tempNode != null) {
				System.out.print(tempNode.val + ", ");
				queue.add(tempNode.left);
				queue.add(tempNode.right);
			}else {
				System.out.print("null, ");
			}
		}

		
	}
}
