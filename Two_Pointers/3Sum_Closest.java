class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        while (lo < hi && (nums[lo] == nums[lo + 1])) lo++;
                        lo++;
                    } else {
                        while (lo < hi && (nums[hi] == nums[hi - 1])) hi--;
                        hi--;
                    }
                    if (Math.abs(target - sum) < Math.abs(target - min)) {
                        min = sum;
                    }
                }
            }
        }
        return min;
    }
}

/*
16. 3Sum Closest
Medium

Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 

Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
Accepted
608,698
Submissions
1,310,396
*/