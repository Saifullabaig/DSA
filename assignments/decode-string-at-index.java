class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int n = s.length();
        for(Character c: s.toCharArray()){
            if(Character.isDigit(c)){
                size = size * (c - '0');
            }else{
                size++;
            }
        }
        for(int i=n-1;i>=0;i--){
            k %= size;
            Character c = s.charAt(i);
            if(k== 0 && Character.isLetter(c)){
                return c.toString();
            }
            if(Character.isDigit(c)){
                size = size / (c - '0');
            }else{
                size--;
            }
        }
        return null;
    }
}
//https://leetcode.com/problems/decoded-string-at-index/