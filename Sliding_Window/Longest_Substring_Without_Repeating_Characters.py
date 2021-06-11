class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()                             #intialize a set to keep track duplicate in the window 
        l = 0                                       #initialize the left window (pointer)
        res = 0                                     #the window size to be returned 
        
        #go through the string and r is the right window (pointer)
        for r in range(len(s)) :
            while s[r] in charSet :                 #if the new right elem is still in window, shrink window
                charSet.remove(s[l])
                l += 1
            charSet.add(s[r])                       #add new right elem to set 
            res = max(res, r - l + 1)               #update the max window size
        return res            


# 3. Longest Substring Without Repeating Characters
# Medium

# Given a string s, find the length of the longest substring without repeating characters.

 

# Example 1:

# Input: s = "abcabcbb"
# Output: 3
# Explanation: The answer is "abc", with the length of 3.
# Example 2:

# Input: s = "bbbbb"
# Output: 1
# Explanation: The answer is "b", with the length of 1.
# Example 3:

# Input: s = "pwwkew"
# Output: 3
# Explanation: The answer is "wke", with the length of 3.
# Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
# Example 4:

# Input: s = ""
# Output: 0
 

# Constraints:

# 0 <= s.length <= 5 * 104
# s consists of English letters, digits, symbols and spaces.