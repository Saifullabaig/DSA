class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n-1;
        List<Pair<Integer, Integer>> pairs= new ArrayList<>();
        Arrays.sort(nums);
        while(i<j){
            Pair p = new Pair(nums[i], nums[j]);
            pairs.add(p);
            i++;
            j--;
        }
        int max = 0;
        for(int k=0;k<pairs.size();k++){
            Pair p = pairs.get(k);
            int sum = (int)p.getKey() + (int)p.getValue();
            if(sum > max){
                max = sum;
            }
        }
        return max;
    }
}