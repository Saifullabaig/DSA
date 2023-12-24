class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            Integer freq = freqMap.getOrDefault(s.charAt(i),0);
            freq++;
            freqMap.put(s.charAt(i), freq);
        }

        for(int i=0;i<s.length();i++){
            if(freqMap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
//https://leetcode.com/problems/first-unique-character-in-a-string/