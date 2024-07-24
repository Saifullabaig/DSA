class Solution {
    public int maxResult(int[] nums, int k) {
        Deque<Pair<Integer, Integer>> dq = new LinkedList<>() {{
            offer(new Pair<>(0, nums[0]));
        }};
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst().getKey() < i-k){
                dq.pollFirst();
            }
            max = nums[i] + (dq.isEmpty() ? 0 : dq.peekFirst().getValue());
            while(!dq.isEmpty() && dq.peekLast().getValue() <= max){
                dq.pollLast();
            }
            dq.offerLast(new Pair<>(i, max));
        }
        return max;
    }
}
//https://leetcode.com/problems/jump-game-vi/