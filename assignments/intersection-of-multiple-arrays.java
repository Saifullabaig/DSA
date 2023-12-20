class Solution {
    public List<Integer> intersection(int[][] nums) {
        int freq[] = new int[1001];
        int len = nums.length;

        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                freq[nums[i][j]]++;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<1001; i++){
            if(freq[i] == len) res.add(i);
        }
        return res;
    }
}
//https://leetcode.com/problems/intersection-of-multiple-arrays/