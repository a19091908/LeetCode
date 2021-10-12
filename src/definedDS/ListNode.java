package definedDS;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
	
	static public ListNode constructLinkedList(int[] ele) {
		ListNode nextNode = new ListNode(ele[ele.length-1]);
		for (int i = ele.length-2; i >= 0; i--) {
			nextNode = new ListNode(ele[i], nextNode);
		}
		return nextNode;
	}
}
