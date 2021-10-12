//Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.
//		
//Constraints:
//
//The number of nodes in the list is in the range [1, 100].
//1 <= Node.val <= 100
package studyplan;

public class MiddleOfTheLinkedList {

	public static void main(String[] args) {
		int[] ele = {1};
		ListNode nextNode = new ListNode(ele[ele.length-1]);
		for (int i = ele.length-2; i >= 0; i--) {
			nextNode = new ListNode(ele[i], nextNode);
		}
		
		ListNode ans = new MiddleOfTheLinkedList().middleNode(nextNode);
		System.out.println(ans.val);
	}
	
	public ListNode middleNode(ListNode head) {
        ListNode tmpNode = head;
        int nodeCnt = 1;
        while (tmpNode.next != null) {
			tmpNode = tmpNode.next;
			nodeCnt++;
		}
        tmpNode = head;
        int mid = nodeCnt/2+1;
        if(mid == 1) return tmpNode;
        for (int i = 1; i < mid; i++) {
        	tmpNode = tmpNode.next;
		}
        return tmpNode;
    }

}

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
