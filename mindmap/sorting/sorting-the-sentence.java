class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] ans = new String[words.length];
        for(String word: words){
            int i = word.length()-1;
            ans[word.charAt(i)-'1'] = word.substring(0, i);   
        }
        return String.join(" ", ans);
    }
}
//https://leetcode.com/problems/sorting-the-sentence/