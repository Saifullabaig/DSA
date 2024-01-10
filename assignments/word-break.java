class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null) return true;
        Boolean[] memo = new Boolean[s.length()];
        return wb(s, wordDict, 0, memo);
    }

    private boolean wb(String s, List<String> dict, int pos, Boolean[] memo){
        if(pos == s.length()) return true;
        if(memo[pos] != null) return memo[pos];

        for(int i=pos+1;i<=s.length();i++){
            String str = s.substring(pos, i);
            if(dict.contains(str) && wb(s, dict, i, memo)){
                memo[pos] = true;
                return true;
            }
        }
        memo[pos] = false;
        return false;
    }
}
//https://leetcode.com/problems/word-break/