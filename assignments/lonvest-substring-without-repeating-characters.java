class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int maxLen = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<n){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(l, map.get(s.charAt(r))+ 1);
            }
            len = r-l+1;
            maxLen = Math.max(len, maxLen);
            map.put(s.charAt(r), r);
            r++;
        }
        return maxLen;
    }
}
//https://leetcode.com/problems/longest-substring-without-repeating-characters/