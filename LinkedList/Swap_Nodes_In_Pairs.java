/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;   //edge case: empty list  
        }
        ListNode res = new ListNode(0); //dummy node before head
        res.next = head;
        helper(res, head, head.next); 
        return res.next;
    }
    
    public void helper(ListNode prev, ListNode left, ListNode right) {
        if (right == null ) {
            return; //if only left is not empty, we are done 
        } else {
            prev.next = right; 
            left.next = right.next;
            right.next = left;
            if (left.next == null) {. //if the next left is empty, we are done
                return;
            }
            helper(left, left.next, left.next.next);
        }
    }
}

/*
24. Swap Nodes in Pairs
Medium

Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
*/