/*
A flip of a number x is choosing a bit in the binary representation of x and flipping it from either 0 to 1 or 1 to 0.

Given two integers start and goal, return the minimum number of flips to convert start to goal.

Input Format:

First and only contains two space seperated integers representing the start number and the end number.

Output Format:

Return a single integer representing the minimum number of flips required to convert start number to end number.

Example 1
Input
start = 10, goal = 7
Output
3
Explanation:
The binary representation of 10 and 7 are 1010 and 0111 respectively. We can convert 10 to 7 in 3 steps:

Flip the first bit from the right: 1010 -> 1011.
Flip the third bit from the right: 1011 -> 1111.
Flip the fourth bit from the right: 1111 -> 0111. It can be shown we cannot convert 10 to 7 in less than 3 steps. Hence, we return 3.
*/

class Solution {
    public int minBitFlips(int start, int goal) {
      //Write your code here; 
       int flips = 0;
        int xorResult = start ^ goal;

        while (xorResult != 0) {
            int rightmostSetBit = xorResult & -xorResult;
            start ^= rightmostSetBit;
            xorResult = start ^ goal;
            flips++;
        }

        return flips;
 }
}