class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            int len = r-l+1;
            int maxFreq = Collections.max(map.values());
            if(len - maxFreq > k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        
        return max;
    }
}
//https://leetcode.com/problems/longest-repeating-character-replacement/