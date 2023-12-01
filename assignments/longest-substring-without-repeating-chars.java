class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;
        for(int r=0; r<n; r++){
            if(set.contains(s.charAt(r))){
                while(l<r && set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}
//https://leetcode.com/problems/longest-substring-without-repeating-characters/