class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] snum = Arrays.copyOf(nums, n);
        Arrays.sort(snum);
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            mp.put(snum[i], i);
        }
        for (int i = 0; i < n; i++) {
            nums[i] = mp.get(nums[i]);
        }
        return nums;
    }
}