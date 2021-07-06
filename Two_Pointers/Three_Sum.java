class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i == 0 || (i > 0 && nums[i-1] != nums[i])) {
                int lo = i + 1;
                int hi = nums.length - 1;
                int sum = 0 - nums[i];        
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        wrapList.add(Arrays.asList(nums[lo], nums[hi], nums[i]));                     
                        while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        hi--;
                        lo++;
                    } else if (nums[lo] + nums[hi] > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return wrapList;
    }
}

/*
15. 3Sum
Medium

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/