class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Initializing the map that will record the constituent and index of a given value
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        // Populate the map 
        for (int i = 0; i < nums.length; i++) {
            //If the curr value is in the map, there is a two sum 
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};

            //if not, record the contituent
            } else {
                map.put(target - nums[i], i);
            }
        }
        return null;
    }
}

/*
1. Two Sum
Easy

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/