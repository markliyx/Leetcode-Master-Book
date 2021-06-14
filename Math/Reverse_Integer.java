class Solution {
    public int reverse(int x) {
        int res = 0;
        
        while (x != 0) {
            int append = x % 10; // get the last digit 
            int newRes = res * 10 + append; // curr res plus the last digit
            x = x /10;  // get rid off the last digit in x
            
            // check for integer overflow (works around the wrap around nature of java integer)
            // detail see below 
            if (newRes / 10 != res) {
                return 0;
            }
            // update the res
            res = newRes;
        }
        return res;
    }
}

/*
7. Reverse Integer
Easy

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
Example 4:

Input: x = 0
Output: 0
 

Constraints:

-231 <= x <= 231 - 1

Hi, everyone!

Nice solution, but, as many others, I didn't get the line if ((newResult - tail) / 10 != result).

We're interested on what happens when an integer overflows. Well, it is rolled over. Practically speaking, if you would try

    public static void main(String[] args) {
        int rollMeOver= Integer.MAX_VALUE + 1;
        System.out.println(rollMeOver);
    }
You will get as an output -2147483648 which represents the lowest value for an integer (Integer.MIN_VALUE).

Thus, in our problem, if newResult is going to overflow we are sure that newResult / 10 != result (this is the reason that @Inception_wzd said that we don't need to subtract the tail first because by / 10 we are already losing the last digit).

By the way, the same thing happens for the underflow.

    public static void main(String[] args) {
        int rollMeOver= Integer.MIN_VALUE - 1;
        System.out.println(rollMeOver);
    }
This is going to output the Integer.MAX_VALUE which is 2147483647 .

Hope it helps!

Good luck! :D
*/