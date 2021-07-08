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

// using a stack to sovle the question
class Solution {
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        ListNode curr = head;
        
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        if (len % 2 == 0) {
            for(int i = 0; i < len / 2; i++) {
                stack.push(head.val);
                head = head.next;
            }
        
            for(int i = len / 2; i < len; i++) {
                Integer popped = stack.pop();
                if (popped != head.val) return false;
                head = head.next;
            }
            return true;
        } else {
            for(int i = 0; i < len / 2; i++) {
                stack.push(head.val);
                head = head.next;
            }
            head = head.next;
            
            for(int i = len / 2 + 1; i < len; i++) {
                Integer popped = stack.pop();
                if (popped != head.val) return false;
                head = head.next;
            }
            return true;
        }
        
    }
}

// fast and slow pointers method to find the middle and reverse the 
// second half of the linked list

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        prev = slow;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}

/* 
    234. Palindrome Linked List
Easy

Given the head of a singly linked list, return true if it is a palindrome.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
 

Follow up: Could you do it in O(n) time and O(1) space?
*/