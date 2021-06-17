/* 
again using two pointers, one moves faster on move slower to
locate the new head and root given a certain gap in between. 
*/

public static ListNode rotateRight(ListNode head, int k) {
	if(head==null)
        return null;
	int size = 1; // since we are already at head node
	ListNode fast=head;
	ListNode slow = head;
	
	while(fast.next != null){
	    size++;
	    fast = fast.next;
	}
	
	for(int i = size - k % size; i > 1; i--) {
        slow = slow.next;
    } // i>1 because we need to put slow.next at the start.
	
    // No dummy variable.
	fast.next = head;
	head = slow.next;
	slow.next = null;
	
	return head;
}

/*
61. Rotate List
Medium

Given the head of a linked list, rotate the list to the right by k places.

Example 1:

Input: head = [1,2,3,4,5], k = 2
Output: [4,5,1,2,3]

Example 2:

Input: head = [0,1,2], k = 4
Output: [2,0,1]
 

Constraints:

The number of nodes in the list is in the range [0, 500].
-100 <= Node.val <= 100
0 <= k <= 2 * 109
*/