class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int left = l[i];
            int right = r[i];
            int count = 0;
            int[] temp = new int[right - left + 1];
            while(left<=right){
                temp[count++]=nums[left++];
            }
            Arrays.sort(temp);
            int diff1 = -1;
            int diff2 = -1;
            boolean flag = true;
            for(int j=temp.length-1;j>=1;j--){
                int diff = temp[j] - temp[j-1];
                diff2 = diff1;
                diff1 = diff;
                if(diff1 != -1 && diff2 != -1 && diff1 != diff2){
                    flag = false;
                }
            }
            ans.add(flag);
        }
        return ans;
        
    }
}