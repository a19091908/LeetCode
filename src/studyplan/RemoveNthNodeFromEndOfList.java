//Given the head of a linked list, remove the nth node from the end of the list and return its head.

//Constraints:
//
//The number of nodes in the list is sz.
//1 <= sz <= 30
//0 <= Node.val <= 100
//1 <= n <= sz

package studyplan;

import java.util.LinkedList;
import java.util.Queue;

import definedDS.ListNode;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		int[] ele = {1,2,3};
		int n = 3;
		
		ListNode head = ListNode.constructLinkedList(ele);
		head = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, n);
		
		ListNode tmp = head;
		while (tmp != null) {
			System.out.print(tmp.val + "->");
			tmp = tmp.next;
		}
	}
	
	// version 1
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode tmpNode = head;
//		int nodeCnt = 1;
//		while(tmpNode.next != null) {
//			tmpNode = tmpNode.next;
//			nodeCnt ++;
//		}
//		int removedNo = nodeCnt - n + 1;
//		if (removedNo == 1) {
//			head = head.next;
//		}else {
//			int preRemovedNo = removedNo-1;
//			tmpNode = head;
//			for (int i = 1; i < preRemovedNo; i++) {
//				tmpNode = tmpNode.next;
//			}
//			tmpNode.next = tmpNode.next.next;
//		}
//		return head;
//	}
	
	// version 2: one pass and two pointers
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode newHead = new ListNode(0, head);
//		ListNode fastNode = newHead;
//		ListNode slowNode = newHead;
//		
//		// Move the fastNode into the next n steps such that the distance between fastNode and slowNode is n.
//		// It implies that when the fastNode arrives at the end of the node, the slowNode keeps n distance from fastNode.
//		for (int i = 0; i < n; i++) {
//			fastNode = fastNode.next;
//		}
//		
//		while (fastNode.next != null) {
//			fastNode = fastNode.next;
//			slowNode = slowNode.next;
//		}
//		
//		slowNode.next = slowNode.next.next;
//
//		return newHead.next;
//	}
	
	   // version 3: use a queue to find the target node in one pass
		public ListNode removeNthFromEnd(ListNode head, int n) {
			Queue<ListNode> queue = new LinkedList<ListNode>();
			ListNode tempNode = head;
			int nodeCnt = 0;
			while(tempNode != null) {
				queue.add(tempNode);
				if (queue.size() > n+1) {
					queue.remove();
				}
				nodeCnt++;
				tempNode = tempNode.next;
			}
			
			if (nodeCnt == n) {
				head = head.next;
			}else {
				tempNode = queue.remove();
				tempNode.next = tempNode.next.next;
			}
			
			return head;
			
		}

}
