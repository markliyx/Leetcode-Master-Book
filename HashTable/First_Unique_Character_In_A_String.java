class Solution {
    public int firstUniqChar(String s) {

        // Initialize a hashmap to store character and index 
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        // Go through all the characters, and use map to check for duplicates
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.replace(s.charAt(i), -1);
            } else {
                map.put(s.charAt(i), i);
            }
        }

        // return all the index values and find the smallest non -1 value 
        int index = -1;
        for (Integer i: map.values()) {
            if (index == -1) {
                index = i;
            } else if (i != -1 && i < index) {
                index = i;
            }
        }

        // output the first non duplicate value's index
        return index;
    }
}

/*
387. First Unique Character in a String
Easy

Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
 

Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
*/