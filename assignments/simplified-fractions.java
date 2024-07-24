class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for(int i=1;i<n;i++){
            for(int j=2;j<=n;j++){
                if(i<j && gcd(i,j) == 1){
                    res.add(i+"/"+j);
                }
            }
        }
        return res;
    }
    private int gcd(int a, int b){
        if(a == 0) return b;
        return gcd(b%a, a);
    }
}
//https://leetcode.com/problems/simplified-fractions/