class Solution {
    public List<String> removeAnagrams(String[] words) {
        String prev = "";
        List<String> res = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            char[] ch = words[i].toCharArray();
            Arrays.sort(ch);
            String curr = String.valueOf(ch);
            if(!curr.equals(prev)){
                res.add(words[i]);
                prev = curr; 
            }
        }
        return res;
    }
}
https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/