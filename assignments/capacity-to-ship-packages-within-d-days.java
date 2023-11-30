class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxi = 0, sum = 0;
        for(int i=0;i<n;i++){
            sum += weights[i];
            if(weights[i]>maxi){
                maxi = weights[i];
            }
        }
        int left = maxi;
        int right = sum+1;
        while(left<=right){
            int mid = left + (right-left)/2;
            int reqDays = find(weights, mid);
            if(reqDays<=days){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }

    int find(int[] weights, int capacity){
        int load = 0;
        int days = 1;
        for(int i =0;i<weights.length;i++){
            if(weights[i] + load > capacity){
                days +=1;
                load = weights[i];
            }else{
                load = load + weights[i];
            }
        }
        return days;
    }
}
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/