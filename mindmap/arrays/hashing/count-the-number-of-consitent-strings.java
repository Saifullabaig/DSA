class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count = 0;
        Set<Character> allSet = new HashSet<>();
        for(int i=0;i<allowed.length();i++){
            allSet.add(allowed.charAt(i));
        }

        for(String word: words){
            int temp = 0;
            for(Character c: word.toCharArray()){
                if(allSet.contains(c))
                {
                    temp++;
                }else{
                    break;
                }
            }
            if(temp == word.length()){
                count++;
            }
        }
        return count;
    }
}
//https://leetcode.com/problems/count-the-number-of-consistent-strings/