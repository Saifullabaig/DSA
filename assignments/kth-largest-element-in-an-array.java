class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        int max = 0;
        for(int i=0;i<k;i++){
            max = q.remove();
        }
        return max;
    }
}
//https://leetcode.com/problems/kth-largest-element-in-an-array/