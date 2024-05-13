class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for(int i=0;i<n;i++){
            int left = 0;
            int right = m-1;
            int count = 0;
            while(left<=right){
                int mid = left + (right-left)/2;
                if(spells[i]*1l*potions[mid] >= success){
                    right=mid-1;
                    count = Math.max(count,m - mid);
                }else{
                    left=mid+1;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
}
//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/