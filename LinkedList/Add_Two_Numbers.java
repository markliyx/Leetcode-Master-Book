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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        helper(l1, l2, res, 0);
        return res.next;

    }
    
    public void helper(ListNode l1, ListNode l2, ListNode res, int incre) {
        if (l1 == null && l2 == null) {
            if (incre != 0) {
                res.next = new ListNode(incre);
            }
            return;
        }
        
        //if l1 is null
        if (l1 == null && l2 != null) {
            res.next = new ListNode((l2.val + incre) % 10);
            helper(l1, l2.next, res.next, (l2.val + incre) / 10);
        }
        
        //if l2 is null
        if (l1 != null && l2 == null) {
            res.next = new ListNode((l1.val + incre) % 10);
            helper(l1.next, l2, res.next, (l1.val + incre) / 10);
        }
        
        //neither are null 
        if (l1 != null && l2 != null) {
            res.next = new ListNode((l1.val + l2.val + incre) % 10);
            helper(l1.next, l2.next, res.next, (l1.val + l2.val + incre) / 10);
        }
    }
}

/*
More optimal solution
*/

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}

/*
2. Add Two Numbers
Medium

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
*/