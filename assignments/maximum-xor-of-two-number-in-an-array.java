class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i);
            HashSet<Integer> st = new HashSet<>();
            for (int n : nums) {
                st.add(n & mask);
            }
            int t = res | (1 << i);
            for (int it : st) {
                if (st.contains(it ^ t)) {
                    res = t;
                    break;
                }
            }
        }
        return res;
    }
    
}
//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/