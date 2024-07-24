class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) > 0){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
                set.add(ch);
                if(set.size() == map.size()){
                    ans++;
                }
            }
        }
        return ans;
    }
}
//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/