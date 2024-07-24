class Solution {
    public char findKthBit(int n, int k) {
        return nthRow(n).charAt(k-1);
    }
    public String nthRow(int n){
        if(n==1){
            return "0";
        }
        String temp = nthRow(n-1);
        return temp + "1" + reverse(invert(temp));
    }
    public String invert(String s){
        int n = s.length();
        StringBuilder inv = new StringBuilder();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1'){
                inv.append('0');
            }else{
                inv.append('1');
            }
        }
        return inv.toString();
    }
    public String reverse(String s){
        StringBuilder rev = new StringBuilder(s);
        return rev.reverse().toString();
    }
}
//https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/