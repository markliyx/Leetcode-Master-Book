class Solution {
    // two pass solution
    public void sortColors(int[] nums) {
        int head = 0, tail = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                while(head < tail && nums[head] == 0) head++;
                if (head < i) swap(head, i, nums);
            } 
        }
        
        for (int i = head; i < nums.length; i++) {
            if (nums[i] == 2) {
                while(head < tail && nums[tail] == 2) tail--;
                if (tail > i) swap(tail, i, nums);
            }
        }
    }
    
    public void swap(int i, int j, int[] nums) {
        int toSwap = nums[i];
        nums[i] = nums[j];
        nums[j] = toSwap;
    } 

    public void sortColors(int[] nums) {
        // 1-pass
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }
}

/* 
75. Sort Colors
Medium

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/