/*
Minimize the cost to make all elements in array equal
You are given two 0-indexed arrays nums and cost consisting each of n positive integers.

You can do the following operation any number of times:

Increase or decrease any element of the array nums by 1.
The cost of doing one operation on the ith element is cost[i].

Return the minimum total cost such that all the elements of the array nums become equal.

Explanation
We can make all the elements equal to 2 in the following way:

Increase the 0th element one time. The cost is 2.
Decrease the 1st element one time. The cost is 3.
Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3. The total cost is 2 + 3 + 3 = 8. It can be shown that we cannot make the array equal with a smaller cost.
Input Format
1st Line contains n integers for the array nums
2nd Line contains n integers for the arrat cost
Output Format
A single integer denoting the minimum total cost
Sample Input 1:

4
1 3 5 2
2 3 1 14
Sample Output 1:

8
Constraints:
n == nums.length == cost.length
1 <= n <= 10000
1 <= nums[i], cost[i] <= 1000000
*/

class Solution {
  public int minCost(List<Integer> nums, List<Integer> cost) {
    //Write your code here; 
    int n = nums.size();
        List<Pair> arr = new ArrayList<>();
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            arr.add(new Pair(nums.get(i), cost.get(i)));
            sum += cost.get(i);
        }
        
        Collections.sort(arr, new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.getKey(), b.getKey());
            }
        });
        
        long N = (sum + 1) / 2;
        int x = -1;
        
        for (int i = 0; i < n; i++) {
            N -= arr.get(i).getValue();
            if (N <= 0) {
                x = arr.get(i).getKey();
                break;
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            ans += Math.abs(x * cost.get(i) - nums.get(i) * cost.get(i));
        }
        
        return ans;
    }

    static class Pair {
        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int getKey() {
            return key;
        }

        int getValue() {
            return value;
        }
    }
}