class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = new int[n];
        st.push(prices[n-1]);
        ans[n-1] = prices[n-1];
        for(int i = n-2;i>=0;i--){
            while(!st.isEmpty() && st.peek() > prices[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i] = prices[i];
            }else{
                ans[i] = prices[i] - st.peek();
            }
            st.push(prices[i]);
        }
        return ans;
    }
}
//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/