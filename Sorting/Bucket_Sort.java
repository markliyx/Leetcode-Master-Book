class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // let's do a bucket sort
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (Integer key : map.keySet()) {
            int pos = map.get(key);
            if (bucket[pos] == null) bucket[pos] = new ArrayList<Integer>();
            bucket[pos].add(key);
        }
        
        ArrayList<Integer> tgt = new ArrayList<Integer>(k);
        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (int j = 0; j < bucket[i].size() && tgt.size() < k; j++) {
                tgt.add(bucket[i].get(j).intValue());
            }
        }
        return tgt.stream().mapToInt(i->i).toArray();
    }
}

/*
347. Top K Frequent Elements
Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

Accepted
626,859
Submissions
994,226
*/